package pl.camelsoftware.robotic_code_representation.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.camelsoftware.robotic_code_representation.repository.RcrStorage;
import pl.camelsoftware.robotic_code_representation.service.CommandService;
import pl.camelsoftware.robotic_code_representation.service.RcrTreeService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@AllArgsConstructor
public class CommandsServiceImpl implements CommandService {
    private final RcrTreeService rcrTreeService;
    private final RcrStorage rcrStorage;

    @Override
    public void computeCommands(List<String> commands) {
        Map<String, Integer> frequencies = new HashMap<>();
        commands.forEach(command ->{
            frequencies.put(command, frequencies.getOrDefault(command, 0) + 1);
        });

        Map<String, String> rcrsGenerated = rcrTreeService.generateRcrs(frequencies);
        rcrStorage.save(rcrsGenerated);
    }
}
