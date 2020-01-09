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

    @Autowired Shop shop;

    @Test
    public void buyProductFailsWhenTheProductDoesNotExist() {
        assertThat(this.shop.buyProduct("2")).isFalse();
    }

    @Test
    public void buyProductWorksWhenThereisEnoughtStock() {
        var product = new Tshirt("1","T-shirt",32,2);
        this.shop.addProduct(product);
        assertThat(this.shop.buyProduct(product.getId())).isTrue();
    }

    @Test
    public void RequestStockFailsWhenTheProductDoesNotExist() {
        assertThat(this.shop.requestStock("4")).isFalse();
    }

    @Test
    public void RequestStockWorksWhenTheProductExist() {
        var product = new Tshirt("2","T-shirt",32,2);
        this.shop.addProduct(product);
        assertThat(this.shop.requestStock("2")).isTrue();
    }

}
