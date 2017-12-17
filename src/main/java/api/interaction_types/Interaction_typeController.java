package api.interaction_types;

import api.error.ErrorController;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
public class Interaction_typeController {
    @Autowired
    private Interaction_typeRepository itr;

    @RequestMapping(value= "/interaction_types", method= RequestMethod.GET)
    public ResponseEntity getAllTypes() {
        return new ResponseEntity<>(itr.findAll(),HttpStatus.OK);
    }

    @RequestMapping(value="/interaction_types/add", method = RequestMethod.POST)
    public ResponseEntity postInteractionType(@RequestBody Interaction_type it){
        try{
            it.setId(itr.findHighestId() + 1);
            itr.save(it);
            it.getId();
            return new ResponseEntity<>(it, HttpStatus.CREATED);
        }
        catch(Exception e){
            return ErrorController.ApiError(e);
        }
    }

    @RequestMapping(value="/interaction_types/delete", method = RequestMethod.DELETE)
    public ResponseEntity deleteInteractionType(@RequestBody String body){
        try {
            String s = (new ObjectMapper().readTree(body).findValue("id")+"").replace('"', ' ').trim();
            itr.delete(new Long(Integer.parseInt(s)));
            return new ResponseEntity(HttpStatus.ACCEPTED);
        }
        catch(Exception e){
            return ErrorController.ApiError(e);
        }
    }
}
