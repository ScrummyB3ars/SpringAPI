package api.theme_tips;

import api.theme_tips.Theme_tip;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ResponseBody;

@RestController
public class Theme_tipController {
    @Autowired
    private Theme_tipRepository ttr;

    @RequestMapping(value= "/tips", method= RequestMethod.GET)
    public Iterable<Theme_tip> getAllTips() {
        return ttr.findAll();
    }
}
