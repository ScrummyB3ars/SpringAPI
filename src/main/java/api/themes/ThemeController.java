package api.themes;

import api.error.ErrorController;
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
        return new ResponseEntity(tr.findAll(),HttpStatus.OK);
    }

    @RequestMapping(value="/themes/add", method = RequestMethod.POST)
    public ResponseEntity<Theme> postTheme(@RequestBody Theme t){
        try{
            t.setId(tr.findHighestId() + 1);
            tr.save(t);
            return new ResponseEntity(t, HttpStatus.OK);
        }
        catch(Exception e){
            return ErrorController.ApiError(e);
        }
    }
}
