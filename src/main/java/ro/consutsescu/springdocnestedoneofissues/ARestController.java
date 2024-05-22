package ro.consutsescu.springdocnestedoneofissues;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ro.consutsescu.springdocnestedoneofissues.apiobjects.*;

@RestController
public class ARestController {
    @PostMapping("/parent")
    public Response parentEndpoint(@RequestBody AbstractParent parent) {
        return null;
    }

    @PostMapping("/child")
    public Response childEndpoint(@RequestBody AbstractChild child) {
        return null;
    }
}
