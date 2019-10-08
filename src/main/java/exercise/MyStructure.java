package exercise;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class MyStructure implements IMyStructure {

    private final List <INode> nodes = new LinkedList <>();

    @Override
    public INode findByCode(String code) {
        return nodes.stream()
                .filter(n -> Objects.equals(n.getCode(), code))
                .findAny()
                .orElse(null);
    }

    @Override
    public INode findByRenderer(String renderer) {
        return nodes.stream()
                .filter(n -> Objects.equals(n.getRenderer(), renderer))
                .findAny()
                .orElse(null);
    }

    @Override
    public int count() {
        return (int) nodes.stream().count();
    }

    public void addNodeToList(Node node) {
        nodes.add(node);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MyStructure that = (MyStructure) o;

        return nodes.equals(that.nodes);
    }

    @Override
    public int hashCode() {
        return nodes.hashCode();
    }
}
