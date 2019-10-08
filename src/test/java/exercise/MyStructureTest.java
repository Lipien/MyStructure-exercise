package exercise;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.nullValue;

public class MyStructureTest {

    private MyStructure myStructure = new MyStructure();
    private Node node1 = new Node("code1", "renderer1");
    private Node node2 = new Node("code2", "renderer2");
    private Node node3 = new Node("code3", "renderer3");

    private CompositeNode compositeNode1 = new CompositeNode("compCode1", "compRenderer1");
    private CompositeNode compositeNode2 = new CompositeNode("compCode2", "compRenderer2");
    private CompositeNode compositeNode3 = new CompositeNode("compCode3", "compRenderer3");

    @Before
    public void init() {
        myStructure.addNodeToList(node1);
        myStructure.addNodeToList(node2);
        myStructure.addNodeToList(node3);
        myStructure.addNodeToList(compositeNode1);
        myStructure.addNodeToList(compositeNode2);
        myStructure.addNodeToList(compositeNode3);
    }

    @Test
    public void shouldReturnNodeFoundByCode() {
        //Given&When
        INode codeTest = myStructure.findByCode("code3");

        //Then
        Assert.assertEquals(node3, codeTest);
    }

    @Test
    public void shouldReturnNodeFoundByCompositeCode() {
        //Given&When
        INode codeTest = myStructure.findByCode("compCode2");

        //Then
        Assert.assertEquals(compositeNode2, codeTest);
    }

    @Test
    public void shouldReturnNullWhenCodeNotFound() {
        //Given&When
        INode codeTest = myStructure.findByCode("NotExistingCode");

        //Then
        Assert.assertThat(codeTest, is(nullValue()));
    }

    @Test
    public void shouldReturnNodeFoundByRenderer() {
        //Given&When
        INode rendererTest = myStructure.findByRenderer("renderer3");

        //Then
        Assert.assertEquals(node3, rendererTest);
    }

    @Test
    public void shouldReturnNodeFoundByCompositeRenderer() {
        //Given&When
        INode rendererTest = myStructure.findByRenderer("compRenderer2");

        //Then
        Assert.assertEquals(compositeNode2, rendererTest);
    }

    @Test
    public void shouldReturnNullWhenRendererNotFound() {
        //Given&When
        INode rendererTest = myStructure.findByRenderer("NotExistingRenderer");

        //Then
        Assert.assertThat(rendererTest, is(nullValue()));
    }

    @Test
    public void shouldReturnNodecCount() {
        //Given@when
        int nodesTestCount = myStructure.count();

        //Then
        Assert.assertEquals(6, nodesTestCount);
    }
}