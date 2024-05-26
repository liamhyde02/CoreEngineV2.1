package helloworld.GraphBuilder;

import org.json.JSONObject;

import java.util.Objects;

public class Node {
    private final String name;
    private final String type;
    private final double size;
    private double instability;
    private double abstractness;

    public Node(String name, String type, double size) {
        this.name = name;
        this.type = type;
        this.size = size;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public double getSize() {
        return size;
    }

    public void setInstability(double instability) {
        this.instability = instability;
    }

    public void setAbstractness(double abstractness) {
        this.abstractness = abstractness;
    }

    public double getInstability() {
        return instability;
    }

    public double getAbstractness() {
        return abstractness;
    }

    public JSONObject toJsonObject() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name", this.name);
        jsonObject.put("type", this.type);
        jsonObject.put("size", this.size);
        jsonObject.put("instability", this.instability);
        jsonObject.put("abstractness", this.abstractness);
        return jsonObject;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node node = (Node) o;
        return name.equals(node.name) && type.equals(node.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, type);
    }

}