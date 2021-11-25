import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class InstockTest {
    private Product product;
    private Product testProduct;
    private ProductStock inStock;


    @Before
    public void setUp() {
        product = new Product("product_label", 9.99, 4);
        testProduct = new Product("test_label_1", 4.32, 3);
        inStock = new Instock();
    }


    @Test
    public void testAddMethodShouldAddTheProductInStock() {
        assertFalse(inStock.contains(product));
        inStock.add(product);
        assertTrue(inStock.contains(product));
    }

    @Test
    public void testAddMethodShouldNotAddTheProductIfThereIsAProductWithTheSameLabel() {
        inStock.add(product);
        assertEquals(1, inStock.getCount());
        inStock.add(testProduct);
        assertEquals(1, inStock.getCount());
    }

    @Test
    public void testGetCountReturnsTheCorrectCountOfProductsInStock() {
        inStock.add(product);
        assertEquals(1, inStock.getCount());
        inStock.add(testProduct);
        assertEquals(2, inStock.getCount());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testFindMethodShouldThrowIfTheIndexIsBiggerThanTheCount() {
        inStock.add(product);
        inStock.add(testProduct);
        inStock.find(2);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testFindMethodShouldThrowIfTheIndexSmallerThanZero() {
        inStock.find(-1);
    }

    @Test
    public void testFindMethodReturnTheCorrectProductOnTheIndicatedIndex() {
        inStock.add(product);
        inStock.add(testProduct);

        Product expectedProduct = inStock.find(1);
        assertEquals(expectedProduct, testProduct);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testChangeQuantityMethodShouldThrowIfTheProductIsNotInStock() {
        inStock.changeQuantity("test", 7);
    }

    @Test
    public void testChangeQuantityMethodShouldSetTheProductQuantityCorrect() {
        inStock.add(product);
        inStock.changeQuantity(product.getLabel(), 12);
        assertEquals(12, product.getQuantity());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFindByLabelShouldThrowIfThereIsNoSuchProductInStock() {
        inStock.findByLabel(product.getLabel());
    }

    @Test
    public void testFindByLabelShouldReturnTheCorrectProduct() {
        inStock.add(product);
        Product expectedProduct = inStock.findByLabel(product.getLabel());

        assertEquals(expectedProduct, product);
    }

    @Test
    public void testFindFirstByAlphabeticalOrderShouldReturnEmptyCollectionIfTheArgumentIsOutOfRange() {
        inStock.add(product);
        Iterable<Product> iterable = inStock.findFirstByAlphabeticalOrder(2);
        assertNotNull(iterable);
        List<Product> products = createListFromIterable(iterable);
        assertEquals(0, products.size());

    }

    @Test
    public void testFindFirstByAlphabeticalOrderShouldReturnTheCorrectCollection() {
        inStock.add(testProduct);
        inStock.add(product);

        List<Product> expectedList = new ArrayList<>();
        expectedList.add(product);
        expectedList.add(testProduct);

        Iterable<Product> iterable = inStock.findFirstByAlphabeticalOrder(2);
        assertNotNull(iterable);
        List<Product> products = createListFromIterable(iterable);

        for (int i = 0; i < expectedList.size(); i++) {
            assertEquals(expectedList.get(i), products.get(i));
        }
    }


    private List<Product> createListFromIterable(Iterable<Product> iterable) {
        List<Product> products = new ArrayList<>();
        iterable.forEach(products::add);
        return products;
    }


}