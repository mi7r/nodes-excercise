import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class MyStructure implements IMyStructure {

    private List<INode> nodes = new ArrayList<>();

    List<INode> getNodes() {
        return nodes;
    }

    @Override
    public INode findByCode(String code) {
        if (code == null) {
            throw new IllegalArgumentException("Passed parameter can not be null.");
        }
        return filterByPredicate(node -> code.equals(node.getCode()));
    }

    @Override
    public INode findByRenderer(String renderer) {
        if (renderer == null) {
            throw new IllegalArgumentException("Passed parameter can not be null.");
        }
        return filterByPredicate(node -> renderer.equals(node.getRenderer()));
    }

    @Override
    public int count() {
        return nodes.size();
    }

    private INode filterByPredicate(Predicate<INode> predicate) {
        return nodes.stream()
                .filter(predicate)
                .findFirst()
                .orElse(null);
    }
}
