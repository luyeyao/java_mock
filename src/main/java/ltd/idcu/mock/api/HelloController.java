package ltd.idcu.mock.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @RequestMapping("/hello")
    public String hello(String name){
        return "hello " + (null == name ? "lyy" : name);
    }
}