package pl.camelsoftware.robotic_code_representation.service.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RcrNode {
    String command;
    Integer frequency;
    RcrNode left;
    RcrNode right;

    public RcrNode(String command, Integer frequency) {
        this.command = command;
        this.frequency = frequency;
    }
}
