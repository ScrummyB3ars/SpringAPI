package api.users;

import api.error.ErrorController;
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

    @RequestMapping(value = "/users/{id}")
    public ResponseEntity getSingleUserById (@PathVariable("id") int id) {
        return new ResponseEntity(ur.findUserById(id), HttpStatus.OK );
    }

    @RequestMapping(value="/users/add", method = RequestMethod.POST)
    public ResponseEntity postUser(@RequestBody postUser payload){
        try {
            User u = new User();
            u.setEmail(payload.getEmail());
            u.setRole_id(0);
            u.setPassword(null);
            u.setZip_code(payload.getZip_code());
            u.setUsername(payload.getUsername());
            u.setId(new Long(ur.findHighestId())+1);
            ur.save(u);
            return  new ResponseEntity(u, HttpStatus.CREATED);
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
