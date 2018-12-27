package com.baizhi.test;

import com.baizhi.dao.CategoryDao;
import com.baizhi.entity.Category;
import com.baizhi.entity.Product;
import com.baizhi.util.PageBean;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CategoryDaoTest extends BaseTest {
    @Autowired
    private CategoryDao dao;

    @Test
    public void primaryClassification() {
        // 查询所有类别
        List<Category> primaryClassification = dao.primaryClassification(0);
        for (Category category : primaryClassification) {
            System.out.println(category);
        }
    }

    @Test
    public void SecondaryClassification() {
        // 分类后的图书
        Integer totalRecord = dao.totalRecord(1, 2);
        PageBean pageBean = new PageBean(1, 5, totalRecord);
        Category secondaryClassification = dao.secondaryClassification(1, 2, pageBean);
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
