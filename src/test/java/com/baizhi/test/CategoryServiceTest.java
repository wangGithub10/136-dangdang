package com.baizhi.test;

import com.baizhi.entity.Category;
import com.baizhi.entity.Product;
import com.baizhi.service.CategoryService;
import com.baizhi.util.PageBean;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class CategoryServiceTest extends BaseTest {
    @Autowired
    private CategoryService service;

    @Test
    public void primaryClassification() {
        // 查询所有类别
        List<Category> primaryClassification = service.primaryClassification(0);
        for (Category category : primaryClassification) {
            System.out.println(category);
        }
    }

    @Test
    public void secondaryClassification() {
        // 分类后的图书
        Integer totalRecord = service.totalRecord(1, 2);
        PageBean pageBean = new PageBean(1, 5, totalRecord);
        Category secondaryClassification = service.secondaryClassification(1, 2, pageBean);
        System.out.println(secondaryClassification);
        List<Category> categorys = secondaryClassification.getCategorys();
        for (Category category : categorys) {
            System.out.println("图书类别=" + category);
            List<Product> product = category.getProduct();
            for (Product product2 : product) {
                System.out.println("图书=" + product2);
            }
        }
    }
}
