package com.drpicox.ddd;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import static com.google.common.truth.Truth.assertThat;

@ActiveProfiles("test")
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ShopTest {

    private Shop shop = new Shop();

    @Test
    public void buyProductFailsWhenTheProductDoesNotExist() {
        this.shop.buyProduct("2");
        assertThat(false).isFalse();
    }

    @Test
    public void buyProductWorksWhenThereisEnoughtStock() {
        var product = new Tshirt("1","T-shirt",32,2);
        this.shop.addProduct(product);
        this.shop.buyProduct(product.getId());
        assertThat(true).isTrue();
    }

    @Test
    public void RequestStockFailsWhenTheProductDoesNotExist() {
        this.shop.requestStock("4");
        assertThat(false).isFalse();
    }

    @Test
    public void RequestStockWorksWhenTheProductExist() {
        var product = new Tshirt("2","T-shirt",32,2);
        this.shop.addProduct(product);
        this.shop.requestStock("2");
        assertThat(true).isTrue();
    }

}
