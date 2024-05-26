package helloworld.GraphBuilder;

import org.json.JSONObject;

import java.util.Objects;

public class Edge {
    private final String from;
    private final String to;
    private final String type;

    public Edge(String from, String to, String type) {
        this.from = from;
        this.to = to;
        this.type = type;
    }

    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }

    public String getType() {
        return type;
    }

    public JSONObject toJsonObject() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("from", this.from);
        jsonObject.put("to", this.to);
        jsonObject.put("type", this.type);
        return jsonObject;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Edge edge = (Edge) o;
        return from.equals(edge.from) && to.equals(edge.to) && type.equals(edge.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(from, to, type);
    }

}
