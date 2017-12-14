package api.users;

import api.Error.ErrorController;
import api.Users.UserRepository;
import api.subscribers.Subscriber;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.coyote.Request;
import org.apache.coyote.Response;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import javax.swing.text.html.HTML;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

@RestController
public class SubscriberController {
    @Autowired
    private UserRepository ur;

    @RequestMapping(value= "/subscribers", method= RequestMethod.GET)
    public Iterable<Subscriber> getSubscribers() {
        return sr.findAll();
    }

    @RequestMapping(value="**",method = RequestMethod.GET)
    public String getAnythingelse(){
        return "Welcome to the toddlr-api.";
    }

    @RequestMapping(value="/addSubscriber", method = RequestMethod.POST)
    public ResponseEntity postSubscriber(@RequestBody postSubscriber payload){
        try {
            Subscriber s = new Subscriber(sr.findHighestId().longValue() + 1, payload.getFacebook_id(), (payload.getAge_group()));
            sr.save(s);
            return new ResponseEntity(s,HttpStatus.CREATED);
        }
        catch (Exception e) {
            return ErrorController.ApiError(e);
        }
    }

    @RequestMapping(value="/deleteSubscriber", method = RequestMethod.DELETE)
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
