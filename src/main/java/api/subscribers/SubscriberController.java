package api.subscribers;

import api.error.ErrorController;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;

@RestController
public class SubscriberController {
    @Autowired
    private SubscriberRepository sr;

    @RequestMapping(value= "/subscribers", method= RequestMethod.GET)
    public ResponseEntity getSubscribers() {
        return new ResponseEntity(sr.findAll(), HttpStatus.OK);
    }

    @RequestMapping(value="**",method = RequestMethod.GET)
    public ResponseEntity getAnythingelse(){
        return new ResponseEntity("Welcome to the toddlr-api.", HttpStatus.OK);
    }

    @RequestMapping(value = "/subscribers/{facebook_id}")
    public ResponseEntity getSingleSubscriber (@PathVariable("facebook_id") int fb_id) {
        return new ResponseEntity(sr.findSubscriberByFacebook_id(fb_id), HttpStatus.OK );
    }
    @RequestMapping(value="/subscribers/add", method = RequestMethod.POST)
    public ResponseEntity postSubscriber(@RequestBody postSubscriber payload){
        try{
            Subscriber s = new Subscriber(sr.findHighestId().longValue() + 1, payload.getFacebook_id(), payload.getAge_group_id());
            sr.save(s);
            return new ResponseEntity(s, HttpStatus.CREATED);
        }
        catch (Exception e) {
            return ErrorController.ApiError(e);
        }
    }
    @RequestMapping(value="/subscribers/delete", method = RequestMethod.DELETE)
    public ResponseEntity deleteSubscriber(@RequestBody String body) throws IOException {
        try{
            String s = (new ObjectMapper().readTree(body).findValue("facebook_id")+"").replace('"', ' ').trim();
            sr.deleteWithFacebook_id(s);
            return new ResponseEntity(HttpStatus.ACCEPTED);
        }
        catch (Exception e) {
            return ErrorController.ApiError(e);
        }
    }



}
