package pl.camelsoftware.robotic_code_representation.repository;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Component
public class InMemoryStorage implements RcrStorage {
    private Map<String, String> storage = new HashMap<>();

    @Override
    public void save(Map<String, String> rcrs) {
        storage.putAll(rcrs);
    }

    @Override
    public String getRcr(String command) {
        return Optional.ofNullable(command)
                .map(key -> storage.get(key))
                .orElse(null);
    }
}
