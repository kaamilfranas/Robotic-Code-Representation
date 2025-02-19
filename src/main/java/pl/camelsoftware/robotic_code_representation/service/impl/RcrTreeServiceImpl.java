package pl.camelsoftware.robotic_code_representation.service.impl;

import org.springframework.stereotype.Service;
import pl.camelsoftware.robotic_code_representation.service.RcrTreeService;
import pl.camelsoftware.robotic_code_representation.service.model.RcrNode;

import java.util.*;

@Service
public class RcrTreeServiceImpl implements RcrTreeService {
    @Override
    public Map<String, String> generateRcrs(Map<String, Integer> commandsOccurenceMap) {
        PriorityQueue<RcrNode> minHeap = new PriorityQueue<>(Comparator.comparingInt(RcrNode::getFrequency));

        for (Map.Entry<String, Integer> entry : commandsOccurenceMap.entrySet()) {
            minHeap.add(new RcrNode(entry.getKey(), entry.getValue()));
        }

        while (minHeap.size() > 1) {
            RcrNode left = minHeap.poll();
            RcrNode right = minHeap.poll();

            RcrNode merged = new RcrNode(null, left.getFrequency() + right.getFrequency());
            merged.setLeft(left);
            merged.setRight(right);

            minHeap.add(merged);
        }

        RcrNode root = minHeap.poll();

        return generateCodes(root);
    }

    private Map<String, String> generateCodes(RcrNode root) {
        if (root == null) return null;
        Map<String, String> rcrCodes = new HashMap<>();


        Stack<Map.Entry<RcrNode, String>> stack = new Stack<>();
        stack.push(new AbstractMap.SimpleEntry<>(root, ""));

        while (!stack.isEmpty()) {
            Map.Entry<RcrNode, String> entry = stack.pop();
            RcrNode node = entry.getKey();
            String code = entry.getValue();

            if (node.getCommand() != null) {
                rcrCodes.put(node.getCommand(), code);
            }

            if (node.getRight() != null) {
                stack.push(new AbstractMap.SimpleEntry<>(node.getRight(), code + "1"));
            }
            if (node.getLeft() != null) {
                stack.push(new AbstractMap.SimpleEntry<>(node.getLeft(), code + "0"));
            }
        }
        return rcrCodes;
    }
}
