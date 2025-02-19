package pl.camelsoftware.robotic_code_representation.repository;

import java.util.Map;

public interface RcrStorage {
    void save(Map<String, String> rcrs);
    String getRcr(String command);
}
