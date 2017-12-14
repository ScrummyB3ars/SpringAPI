package api.age_groups;

import api.age_groups.Age_group;
import org.apache.coyote.Request;
import org.apache.coyote.Response;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import api.Error.ErrorController;
import java.util.List;
import java.util.Map;

@RestController
public class Age_groupController {
    @Autowired
    private Age_groupRepository agr;

    @RequestMapping(value="/age_groups", method = RequestMethod.GET)
    public ResponseEntity getAllAge_Groups(){
        try {
            return new ResponseEntity(agr.findAll(), HttpStatus.OK);
        }
        catch (Exception e){
           return  ErrorController.ApiError(e);
        }
    }
}
