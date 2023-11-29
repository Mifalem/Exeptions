

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ShopRepositoryTest {

    @Test
    public void shouldRemoveThanProductExist() {
        ShopRepository repo = new ShopRepository();

        Product product1 = new Product(1, "смартфон", 30_000);
        Product product2 = new Product(7, "нетбук", 40_000);
        Product product3 = new Product(12, "процессор", 20_000);

        repo.add(product1);
        repo.add(product2);
        repo.add(product3);

        repo.remove(12);
        Product[] actual = repo.findAll();
        Product[] expected = {product1, product2};

        Assertions.assertArrayEquals(expected, actual);
    }
//    @Test
//    public void shouldNotRemoveThanProductNotExist() {
//        ShopRepository repo = new ShopRepository();
//
//        Product product1 = new Product(1, "смартфон", 30_000);
//        Product product2 = new Product(7, "нетбук", 40_000);
//        Product product3 = new Product(12, "процессор", 20_000);
//
//        repo.add(product1);
//        repo.add(product2);
//        repo.add(product3);
//
//        repo.remove(8);
//        Product[] actual = repo.findAll();
//        Product[] expected = {product1, product2, product3};
//
//        Assertions.assertArrayEquals(expected, actual);
//    }

    @Test
    public void shouldTrackingThanNotRemoveThanProductNotExist() {
        ShopRepository repo = new ShopRepository();

        Product product1 = new Product(1, "смартфон", 30_000);
        Product product2 = new Product(7, "нетбук", 40_000);
        Product product3 = new Product(12, "процессор", 20_000);

        repo.add(product1);
        repo.add(product2);
        repo.add(product3);

        Assertions.assertThrows(NotFoundException.class, () -> repo.remove(8));
    }
}
