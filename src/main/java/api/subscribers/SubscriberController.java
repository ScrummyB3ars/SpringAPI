package api.subscribers;

import api.subscribers.Subscriber;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.concurrent.atomic.AtomicLong;

@RestController
public class SubscriberController {
    @Autowired
    private SubscriberRepository sr;
    private static final String template = "Hello from hello.subscribers, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping(value= "/subscribers", method= RequestMethod.GET)
    public Iterable<Subscriber> getSubscribers() {
        return sr.findAll();
    }

    @RequestMapping(value= "/sub", method= RequestMethod.GET)
    public Subscriber getSubscriber() {
        Long l = new Long(1);
        return new Subscriber(l,258, 1);
    }

    @RequestMapping(value= "/test", method= RequestMethod.GET)
    public String test() {
        return "test success";
    }

    @RequestMapping(value="**",method = RequestMethod.GET)
    public String getAnythingelse(){
        return "test success";
    }
}
