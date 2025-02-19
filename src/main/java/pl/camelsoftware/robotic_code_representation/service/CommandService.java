package pl.camelsoftware.robotic_code_representation.service;

import pl.camelsoftware.robotic_code_representation.dto.ComputeCommandsListRequest;

import java.util.List;
import java.util.Map;

public interface CommandService {
    void computeCommands(ComputeCommandsListRequest computeCommandsListRequest);
}
