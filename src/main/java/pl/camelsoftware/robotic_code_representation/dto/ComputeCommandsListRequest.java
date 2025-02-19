package pl.camelsoftware.robotic_code_representation.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

@Getter
@AllArgsConstructor
public class ComputeCommandsListRequest implements Serializable {
    @Serial
    private static final long serialVersionUID = -4234346486403051982L;
    String[] commands;
}
