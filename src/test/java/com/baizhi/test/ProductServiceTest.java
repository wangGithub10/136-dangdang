package com.baizhi.test;

import com.baizhi.entity.Product;
import com.baizhi.service.ProductService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class ProductServiceTest extends BaseTest {
    @Autowired
    private ProductService service;

    @Test
    public void recommend() {
        // 编辑推荐
        List<Product> recommend = service.recommend();
        for (Product product : recommend) {
            System.out.println(product);
        }
    }

    @Test
    public void hotBook() {
        // 热销图书
        List<Product> hotBook = service.hotBook();
        for (Product product : hotBook) {
            System.out.println(product);
        }
    }

    @Test
    public void newBook() {
        // 新书上架
        List<Product> newBook = service.newBook();
        for (Product product : newBook) {
            System.out.println(product);
        }
    }

    @Test
    public void newHotBook() {
        // 新书热卖
        List<Product> newHotBook = service.newHotBook();
        for (Product product : newHotBook) {
            System.out.println(product);
        }
    }

    @Test
    public void queryProduct() {
        // 查询一本图书
        Product product = service.queryProduct(1);
        System.out.println(product);
    }

    @Test
    public void update() {
        // 修改商品的销量
        service.update(2, 3);
    }
}
