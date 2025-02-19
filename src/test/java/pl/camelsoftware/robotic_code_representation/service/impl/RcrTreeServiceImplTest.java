package pl.camelsoftware.robotic_code_representation.service.impl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pl.camelsoftware.robotic_code_representation.service.RcrTreeService;

import java.util.Map;

class RcrTreeServiceImplTest {

    @Test
    public void testExampleFromRequirements() {
        Map<String, String> expected = Map
                .of(
                        "GRAB", "00",
                        "BACK", "01",
                        "LEFT", "1"
                );

        RcrTreeService rcrTreeService = new RcrTreeServiceImpl();
        Map<String, Integer> commandsOccurenceMap = Map.of(
                "LEFT", 4,
                "GRAB", 1,
                "BACK", 2
        );

        Map<String, String> actual = rcrTreeService.generateRcrs(commandsOccurenceMap);

        expected.forEach(
                (key, value) -> {
                    Assertions.assertEquals(value, actual.get(key));
                }
        );
    }
}