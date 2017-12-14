package api.Users;

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
public class UserController {
    @Autowired
    private UserRepository ur;

    @RequestMapping(value= "/users", method= RequestMethod.GET)
    public Iterable<User> getUsers() {
        return ur.findAll();
    }

    @RequestMapping(value="/addSubscriber", method = RequestMethod.POST)
    public ResponseEntity postSubscriber(@RequestBody postUser payload){
        try {
            //todo save user
            return new ResponseEntity(HttpStatus.CREATED);
        }
        catch (Exception e) {
            return ErrorController.ApiError(e);
        }
    }

    @RequestMapping(value="/deleteSubscriber", method = RequestMethod.DELETE)
    public ResponseEntity deleteSubscriber(@RequestBody String body) throws IOException {

        /*try{
            String s = (new ObjectMapper().readTree(body).findValue("facebook_id")+"").replace('"', ' ').trim();
            sr.deleteWithFacebook_id(s);
            return new ResponseEntity(HttpStatus.ACCEPTED);
        }
        catch (Exception e) {
            return ErrorController.ApiError(e);
        }*/
        return new ResponseEntity(HttpStatus.OK);
    }



}
