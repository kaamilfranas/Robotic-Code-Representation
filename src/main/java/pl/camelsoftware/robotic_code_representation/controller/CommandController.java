package pl.camelsoftware.robotic_code_representation.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import pl.camelsoftware.robotic_code_representation.dto.ComputeCommandsListRequest;
import pl.camelsoftware.robotic_code_representation.service.CommandService;

import java.util.List;

@RestController
@AllArgsConstructor
public class CommandController {
    private CommandService commandService;

    @PostMapping(path = "/commands")
    public void computeCommands(@RequestBody ComputeCommandsListRequest request) {
        commandService.computeCommands(request);
    }
}
