package pl.camelsoftware.robotic_code_representation.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.camelsoftware.robotic_code_representation.repository.RcrStorage;
import pl.camelsoftware.robotic_code_representation.service.RcrProvider;

@Service
@AllArgsConstructor
public class RcrProviderImpl implements RcrProvider {
    private RcrStorage storage;

    @Override
    public String getRcr(String command) {
        return storage.getRcr(command);
    }
}
