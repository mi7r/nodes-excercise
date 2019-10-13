import java.util.Objects;

public class Node implements INode {

    private String code;
    private String renderer;

    Node(String code, String renderer) {
        this.code = code;
        this.renderer = renderer;
    }

    @Override
    public String getCode() {
        return code;
    }

    @Override
    public String getRenderer() {
        return renderer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node node = (Node) o;
        return Objects.equals(code, node.code) &&
                Objects.equals(renderer, node.renderer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code, renderer);
    }
}
