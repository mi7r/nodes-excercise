import java.util.List;

public class MyStructure implements IMyStructure {

    private List<INode> nodes;

    @Override
    public INode findByCode(String code) {
        return nodes.stream()
                .filter(n-> n.getCode().equals(code))
                .findFirst()
                .orElse(null);
    }

    @Override
    public INode findByRenderer(String renderer) {
        return nodes.stream()
                .filter(n->n.getRenderer().equals(renderer))
                .findFirst()
                .orElse(null);
    }

    @Override
    public int count() {
        return nodes.size();
    }
}
