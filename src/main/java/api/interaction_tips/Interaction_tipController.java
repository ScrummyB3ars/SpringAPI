package api.interaction_tips;

import api.error.ErrorController;
import api.theme_tips.Theme_tip;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;

import javax.xml.ws.Response;
import java.util.Random;

@RestController
public class Interaction_tipController {
    @Autowired
    private Interaction_tipRepository itr;

    @RequestMapping(value= "/interaction_tips", method= RequestMethod.GET)
    public ResponseEntity getAllInteractionTips() {
        return new ResponseEntity<>(itr.findAll(),HttpStatus.OK);
    }

    @RequestMapping(value="/interaction_tips/random", method = RequestMethod.GET)
    public ResponseEntity getRandomInteractionTip(){
        try{
            Integer random = new Random().nextInt((int) itr.count() +1);
            Interaction_tip it = itr.findOne(new Long(random));
            return new ResponseEntity<>(it, HttpStatus.OK);
        }
        catch(Exception e){
            return ErrorController.ApiError(e);
        }
    }

    @RequestMapping(value="/interaction_tips/add", method = RequestMethod.POST)
    public ResponseEntity postInteractionTip(@RequestBody Interaction_tip it){
        it.setId(itr.findHighestId()+1);
        itr.save(it);
        return new ResponseEntity<>(it, HttpStatus.CREATED);
    }

    @RequestMapping(value="/interaction_tips/delete", method = RequestMethod.DELETE)
    public ResponseEntity deleteInteractionTip(@RequestBody String body){
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