package exercise;

import java.util.LinkedList;
import java.util.List;

public class CompositeNode extends Node implements ICompositeNode {

    private List <INode> nodes = new LinkedList <>();

    public CompositeNode(String code, String renderer) {
        super(code, renderer);
    }

    @Override
    public List <INode> getNodes() {
        return nodes;
    }

    public void addNode(INode node) {
        nodes.add(node);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        CompositeNode that = (CompositeNode) o;

        return getNodes().equals(that.getNodes());
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + getNodes().hashCode();
        return result;
    }
}

