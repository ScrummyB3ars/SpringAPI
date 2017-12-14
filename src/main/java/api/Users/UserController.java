package api.Users;

import api.Error.ErrorController;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;

@RestController
public class UserController {
    @Autowired
    private UserRepository ur;

    @RequestMapping(value= "/users", method= RequestMethod.GET)
    public Iterable<User> getUsers() {
        return ur.findAll();
    }

    @RequestMapping(value="/users/post", method = RequestMethod.POST)
    public ResponseEntity postUser(@RequestBody postUser payload){
        try {
            //todo save user
            return new ResponseEntity(HttpStatus.CREATED);
        }
        catch (Exception e) {
            return ErrorController.ApiError(e);
        }
    }

    @RequestMapping(value="/users/delete", method = RequestMethod.DELETE)
    public ResponseEntity deleteUser(@RequestBody String body) throws IOException {

        try{
            String s = (new ObjectMapper().readTree(body).findValue("email")+"").replace('"', ' ').trim();
            ur.deleteWithEmail(s);
            return new ResponseEntity(HttpStatus.ACCEPTED);
        }
        catch (Exception e) {
            return ErrorController.ApiError(e);
        }
    }
}
