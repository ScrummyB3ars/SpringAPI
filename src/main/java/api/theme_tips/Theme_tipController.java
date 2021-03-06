package api.theme_tips;

import api.error.ErrorController;
import api.subscribers.Subscriber;
import api.subscribers.SubscriberRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.context.Theme;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Random;

@RestController
public class Theme_tipController {
    @Autowired
    private Theme_tipRepository ttr;
    @Autowired
    private SubscriberRepository sr;

    @RequestMapping(value= "/theme_tips", method= RequestMethod.GET)
    public ResponseEntity getAllThemeTips() {
        return new ResponseEntity<>(ttr.findAll(),HttpStatus.OK);
    }

    @RequestMapping(value="/theme_tips/random", method = RequestMethod.GET)
    public ResponseEntity getRandomThemeTip(@RequestParam(value="facebook_id", defaultValue = "null") String facebook_id){
        try{
            Theme_tip t;
            if(facebook_id.equals("null")){
                Integer random = new Random().nextInt((int) ttr.count() +1);
                t = ttr.findOne(new Long(random));
            }
            else {
                t = ttr.findRandomTheme_Tip(sr.findSubscriberByFacebook_id(facebook_id).getAge_group_id());
            }
            return new ResponseEntity<>(t, HttpStatus.OK);
        }
        catch(Exception e){
           return ErrorController.ApiError(e);
        }
    }

    @RequestMapping(value="/theme_tips/{id}", method = RequestMethod.GET)
    public ResponseEntity getSingleThemeTipById(@PathVariable("id") int id){
        try {
            return new ResponseEntity<>(ttr.findOne(new Long(id)), HttpStatus.OK);
        }
        catch(Exception e){
            return ErrorController.ApiError(e);
        }
    }

    @RequestMapping(value="/theme_tips/add", method = RequestMethod.POST)
    public ResponseEntity<Theme_tip> postThemeTip(@RequestBody Theme_tip tt){
        tt.setId(new Long(ttr.findHighestId())+1);
        ttr.save(tt);
        return new ResponseEntity<>(tt, HttpStatus.CREATED);
    }

    @RequestMapping(value="/theme_tips/delete", method = RequestMethod.DELETE)
    public ResponseEntity deleteInteractionType(@RequestBody String body){
        try {
            String s = (new ObjectMapper().readTree(body).findValue("id")+"").replace('"', ' ').trim();
            ttr.delete(new Long(Integer.parseInt(s)));
            return new ResponseEntity(HttpStatus.ACCEPTED);
        }
        catch(Exception e){
            return ErrorController.ApiError(e);
        }
    }
}
