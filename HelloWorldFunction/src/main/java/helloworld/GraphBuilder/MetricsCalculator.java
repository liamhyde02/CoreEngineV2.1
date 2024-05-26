package helloworld.GraphBuilder;

import java.util.List;

public class MetricsCalculator {

    public static void calculateMetrics(List<Node> nodes, List<Edge> edges) {
        for (Node node : nodes) {
            double outs = countOuts(node.getName(), edges);
            double ins = countIns(node.getName(), edges);
            double total = outs + ins;

            double instability = total == 0 ? 0 : outs / total;
            double abstractness = calculateAbstractness(node.getType());

            node.setInstability(instability);
            node.setAbstractness(abstractness);
        }
    }

    private static double countOuts(String nodeName, List<Edge> edges) {
        return edges.stream()
                .filter(edge -> (edge.getFrom().equals(nodeName) && !edge.getType().equals("composition")) ||
                        ("composition".equals(edge.getType()) && edge.getTo().equals(nodeName)))
                .count();
    }

    private static double countIns(String nodeName, List<Edge> edges) {
        return edges.stream()
                .filter(edge -> (edge.getTo().equals(nodeName) && !edge.getType().equals("composition")) ||
                        ("composition".equals(edge.getType()) && edge.getFrom().equals(nodeName)))
                .count();
    }

    private static double calculateAbstractness(String nodeType) {
        if ("aclass".equals(nodeType) || "iface".equals(nodeType)) {
            return 1.0;
        } else {
            return 0.0;
        }
    }
}
