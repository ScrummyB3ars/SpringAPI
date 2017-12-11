package api.subscribers;

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
    private SubscriberRepository sr;

    @RequestMapping(value= "/subscribers", method= RequestMethod.GET)
    public Iterable<Subscriber> getSubscribers() {
        return sr.findAll();
    }

    @RequestMapping(value= "/sub", method= RequestMethod.GET)
    public Subscriber getSubscriber() {
        Long l = new Long(1);
        return new Subscriber(l,"258", 1);
    }

    @RequestMapping(value= "/test", method= RequestMethod.GET)
    public String test() {
        return "test success";
    }

    @RequestMapping(value="**",method = RequestMethod.GET)
    public String getAnythingelse(){
        return "Welcome to the toddlr-api.";
    }

    @RequestMapping(value="/addSubscriber", method = RequestMethod.POST)
    public ResponseEntity postSubscriber(@RequestBody postSubscriber payload){
        Subscriber s = new Subscriber(sr.findHighestId().longValue() + 1, payload.getFacebook_id(), Integer.parseInt(payload.getAge_group()));
        sr.save(s);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @RequestMapping(value="/deleteSubscriber", method = RequestMethod.DELETE)
    public ResponseEntity deleteSubscriber(@RequestBody String body) throws IOException {
        String s = (new ObjectMapper().readTree(body).findValue("facebook_id")+"").replace('"', ' ').trim();
        sr.deleteWithFacebook_id(s);
        return new ResponseEntity(HttpStatus.ACCEPTED);

    }



}
