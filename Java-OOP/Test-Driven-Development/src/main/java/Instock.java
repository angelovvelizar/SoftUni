import jdk.jshell.spi.ExecutionControl;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class Instock implements ProductStock {
    private List<Product> products;


    public Instock() {
        this.products = new ArrayList<>();
    }

    @Override
    public int getCount() {
        return this.products.size();
    }

    @Override
    public boolean contains(Product product) {
        return products.stream().anyMatch(p -> p.getLabel().equals(product.getLabel()));
    }

    @Override
    public void add(Product product) {
        if(products.contains(product)){
            return;
        }

        products.add(product);
    }

    @Override
    public void changeQuantity(String product, int quantity) {
        for (Product currentProduct : products) {
            if(currentProduct.getLabel().equals(product)){
                currentProduct.setQuantity(quantity);
                return;
            }
        }
        throw new IllegalArgumentException();

    }

    @Override
    public Product find(int index) {
        if(index < 0 || index > products.size() - 1){
            throw new IndexOutOfBoundsException();
        }
        return products.get(index);
    }

    @Override
    public Product findByLabel(String label) {
        for (Product product : products) {
            if(product.getLabel().equals(label)){
                return product;
            }
        }

        throw new IllegalArgumentException();
    }

    @Override
    public Iterable<Product> findFirstByAlphabeticalOrder(int count) {
        if(count > products.size() || count < 0){
            return new ArrayList<>();
        }
        return  products.stream().sorted(Comparator.comparing(Product::getLabel)).limit(count).collect(Collectors.toList());

    }

    @Override
    public Iterable<Product> findAllInRange(double lo, double hi) {
        return null;
    }

    @Override
    public Iterable<Product> findAllByPrice(double price) {
        return null;
    }

    @Override
    public Iterable<Product> findFirstMostExpensiveProducts(int count) {
        return null;
    }

    @Override
    public Iterable<Product> findAllByQuantity(int quantity) {
        return null;
    }

    @Override
    public Iterator<Product> iterator() {
        return null;
    }
}
