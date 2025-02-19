package pl.camelsoftware.robotic_code_representation.service;

import java.util.Map;

public interface RcrTreeService {
    Map<String, String> generateRcrs(Map<String, Integer> commandsOccurenceMap);
}
