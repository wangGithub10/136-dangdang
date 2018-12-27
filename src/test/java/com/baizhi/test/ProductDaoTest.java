package com.baizhi.test;

import com.baizhi.dao.ProductDao;
import com.baizhi.entity.Product;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ProductDaoTest extends BaseTest {
    @Autowired
    private ProductDao dao;

    @Test
    public void recommend() {
        // 编辑推荐
        List<Product> recommend = dao.recommend();
        for (Product product : recommend) {
            System.out.println(product);
        }
    }

    @Test
    public void hotBook() {
        // 热销图书
        List<Product> hotBook = dao.hotBook();
        for (Product product : hotBook) {
            System.out.println(product);
        }
    }

    @Test
    public void newBook() {
        // 新书上架
        List<Product> newBook = dao.newBook();
        for (Product product : newBook) {
            System.out.println(product);
        }
    }

    @Test
    public void newHotBook() {
        // 新书热卖
        List<Product> newHotBook = dao.newHotBook();
        for (Product product : newHotBook) {
            System.out.println(product);
        }
    }

    @Test
    public void queryProduct() {
        // 查询一本图书
        Product product = dao.queryProduct(1);
        System.out.println(product);
    }

    @Test
    public void update() {
        // 修改商品的销量
        dao.update(1, 2);
    }
}
