package api.themes;

import api.error.ErrorController;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
public class ThemeController {
    @Autowired
    private ThemeRepository tr;

    @RequestMapping(value= "/themes", method= RequestMethod.GET)
    public ResponseEntity getAllThemes() {
        return new ResponseEntity<>(tr.findAll(),HttpStatus.OK);
    }

    @RequestMapping(value="/themes/add", method = RequestMethod.POST)
    public ResponseEntity postTheme(@RequestBody Theme t){
        try{
            t.setId(tr.findHighestId() + 1);
            tr.save(t);
            return new ResponseEntity<>(t, HttpStatus.CREATED);
        }
        catch(Exception e){
            return ErrorController.ApiError(e);
        }
    }

    @RequestMapping(value="/themes/delete", method = RequestMethod.DELETE)
    public ResponseEntity deleteTheme(@RequestBody String body){
        try {
            String s = (new ObjectMapper().readTree(body).findValue("id")+"").replace('"', ' ').trim();
            tr.delete(new Long(Integer.parseInt(s)));
            return new ResponseEntity(HttpStatus.ACCEPTED);
        }
        catch(Exception e){
            return ErrorController.ApiError(e);
        }
    }
}
