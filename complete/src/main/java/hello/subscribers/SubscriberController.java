package hello.subscribers;

import hello.greeting.Greeting;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class SubscriberController {

    private static final String template = "Hello from hello.subscribers, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping(value= "/subscribers", method= RequestMethod.GET)
    public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
        return new Greeting(counter.incrementAndGet(),
                            String.format(template, name));
    }
}
