import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyStructureTest {

    private static final Node NODE_1 = new Node("code1","renderer1");
    private static final Node NODE_2 = new Node("code2","renderer2");
    private static final CompositeNode COMPOSITE_NODE_1 = new CompositeNode("composite node 1","composite renderer1");
    private static final CompositeNode COMPOSITE_NODE_2 = new CompositeNode("composite node 2","composite renderer2");

    private MyStructure myStructure;

    @BeforeEach
    void setUp(){
        myStructure = new MyStructure();

        myStructure.getNodes().add(NODE_1);
        myStructure.getNodes().add(NODE_2);
        myStructure.getNodes().add(COMPOSITE_NODE_1);
    }


    @Test
    void shouldReturnNodeFoundByCode() {
        assertEquals(NODE_1, myStructure.findByCode("code1"));
    }

    @Test
    void shouldReturnNodeFoundByRenderer() {
        assertEquals(NODE_2, myStructure.findByRenderer("renderer2"));
    }

    @Test
    void shouldCountAllThreeAddedNodes() {
        assertEquals(3, myStructure.count());
    }
}