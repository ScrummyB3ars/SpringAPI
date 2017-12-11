package api.age_groups;

import api.age_groups.Age_group;
import org.apache.coyote.Request;
import org.apache.coyote.Response;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

@RestController
public class Age_groupController {
    @Autowired
    private Age_groupRepository agr;

    @RequestMapping(value="/age_groups", method = RequestMethod.GET)
    public Iterable<Age_group> getAllAge_Groups(){
        return agr.findAll();
    }
}
