package pradeepshah.SpringProject.demo.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;

@RestController
@RequestMapping("/v1")
public class demoController {
    private static final Logger log = Logger.getLogger(demoController.class.getName());
    @GetMapping("/getId")
    public String getId(){
        log.info("in get call...");
        return "hello";
    }
}
