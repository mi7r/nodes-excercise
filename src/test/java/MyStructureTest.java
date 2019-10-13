import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyStructureTest {

    private static final Node NODE_1 = new Node("code1","renderer1");
    private static final Node NODE_2 = new Node("code2","renderer2");
    private static final CompositeNode COMPOSITE_NODE_1 = new CompositeNode("composite code 1","composite renderer 1");

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
    void shouldReturnNullWhenNotFoundByCode(){
        assertNull(myStructure.findByCode("code3000"));
    }

    @Test
    void shouldThrowExceptionWhenPassedCodeIsNull(){
        assertThrows(IllegalArgumentException.class,() -> myStructure.findByCode(null));
    }

    @Test
    void shouldReturnNodeFoundByRenderer() {
        assertEquals(NODE_2, myStructure.findByRenderer("renderer2"));
    }

    @Test
    void shouldReturnNullWhenNotFoundByRenderer(){
        assertNull(myStructure.findByRenderer("renderer4000"));
    }

    @Test
    void shouldThrowExceptionWhenPassedRendererIsNull(){
        assertThrows(IllegalArgumentException.class, ()-> myStructure.findByRenderer(null));
    }

    @Test
    void shouldReturnCompositeNodeFoundByRenderer(){
        assertEquals(COMPOSITE_NODE_1, myStructure.findByRenderer("composite renderer 1"));
    }

    @Test
    void shouldReturnCompositeNodeFoundByCode(){
        assertEquals(COMPOSITE_NODE_1, myStructure.findByCode("composite code 1"));
    }

    @Test
    void shouldCountAllThreeAddedNodes() {
        assertEquals(3, myStructure.count());
    }

    @Test
    void shouldReturnZeroWhenThereIsNoNodes(){
        myStructure.getNodes().clear();

        assertEquals(0, myStructure.count());
    }

    @Test
    void shouldBeAbleToInstantiateClass(){
        assertNotNull(myStructure);
    }
}