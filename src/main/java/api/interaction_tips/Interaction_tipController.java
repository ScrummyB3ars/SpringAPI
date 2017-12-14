package api.interaction_tips;

import api.Error.ErrorController;
import api.theme_tips.Theme_tip;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.context.Theme;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Random;

@RestController
public class Interaction_tipController {
    @Autowired
    private Interaction_tipRepository itr;

    @RequestMapping(value= "/interaction_tips", method= RequestMethod.GET)
    public ResponseEntity getAllInteractionTips() {
        return new ResponseEntity(itr.findAll(),HttpStatus.OK);
    }

    @RequestMapping(value="/interaction_tips/random", method = RequestMethod.GET)
    public ResponseEntity getRandomInteractionTip(){
        try{
            Integer random = new Random().nextInt((int) itr.count() +1);
            Interaction_tip it = itr.findOne(new Long(random));
            return new ResponseEntity(it, HttpStatus.OK);
        }
        catch(Exception e){
            return ErrorController.ApiError(e);
        }
    }
}