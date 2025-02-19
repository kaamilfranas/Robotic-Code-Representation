package pl.camelsoftware.robotic_code_representation.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import pl.camelsoftware.robotic_code_representation.service.RcrProvider;

@RestController
@AllArgsConstructor
public class RcrController {
    private final RcrProvider rcrProvider;
    @GetMapping("/rcrs/{command}")
    public String getRcr(@PathVariable String command) {
        return rcrProvider.getRcr(command);
    }

}
