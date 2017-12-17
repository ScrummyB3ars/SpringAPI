package api.theme_tips;

import api.error.ErrorController;
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

    @RequestMapping(value= "/theme_tips", method= RequestMethod.GET)
    public ResponseEntity getAllThemeTips() {
        return new ResponseEntity(ttr.findAll(),HttpStatus.OK);
    }

    @RequestMapping(value="/theme_tips/random", method = RequestMethod.GET)
    public ResponseEntity getRandomThemeTip(){
        try{
            Integer random = new Random().nextInt((int) ttr.count() +1);
            Theme_tip t = ttr.findOne(new Long(random));
            return new ResponseEntity(t, HttpStatus.OK);
        }
        catch(Exception e){
            return ErrorController.ApiError(e);
        }
    }

    @RequestMapping(value="/theme_tips/add", method = RequestMethod.POST)
    public int postThemeTip(@RequestBody Theme_tip tt){
        tt.setId(new Long(ttr.findHighestId())+1);
        return tt.getAge_group_id();
    }
}
