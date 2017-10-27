package com.kodilla.hibernate.invoice.dao;

import com.kodilla.hibernate.invoice.Invoice;
import com.kodilla.hibernate.invoice.Item;
import com.kodilla.hibernate.invoice.Product;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

@RunWith(SpringRunner.class)
@SpringBootTest
public class InvoiceDaoTestSuite {
    @Autowired
    ProductDao productDao;

    @Autowired
    ItemDao itemDao;

    @Autowired
    InvoiceDao invoiceDao;

    @Test
    public void testInvoiceDaoSave() {
        //Given
        Product product1 = new Product("Love");
        Product product2 = new Product("Health");
        Product product3 = new Product("Happiness");
        productDao.save(product1);
        productDao.save(product2);
        productDao.save(product3);

        Invoice invoice1 = new Invoice("512102017");
        Invoice invoice2 = new Invoice("647102017");
        invoiceDao.save(invoice1);
        invoiceDao.save(invoice2);

        Item item1 = new Item(product1, BigDecimal.valueOf(100.99), 13, invoice1);
        Item item2 = new Item(product3, BigDecimal.valueOf(700.25), 99, invoice1);
        Item item3 = new Item(product1, BigDecimal.valueOf(1250.0), 2, invoice2);
        Item item4 = new Item(product2, BigDecimal.valueOf(5000.80), 35, invoice2);
        Item item5 = new Item(product1, BigDecimal.valueOf(9999.99), 1, invoice1);
        itemDao.save(item1);
        itemDao.save(item2);
        itemDao.save(item3);
        itemDao.save(item4);
        itemDao.save(item5);

        //When
        int invoiceOneId = invoice1.getId();
        int invoiceTwoId = invoice2.getId();
        int numberOfItemsOnInvoiceOne = itemDao.countByInvoice_Id(invoice1.getId());
        int numberOfItemsOnInvoiceTwo = itemDao.countByInvoice_Id(invoice2.getId());

        //Then
        Assert.assertNotEquals(0, invoiceOneId);
        Assert.assertNotEquals(0, invoiceTwoId);
        Assert.assertEquals(3, numberOfItemsOnInvoiceOne);
        Assert.assertEquals(2, numberOfItemsOnInvoiceTwo);

        //CleanUp
        try {
            invoiceDao.delete(invoiceOneId);
            invoiceDao.delete(invoiceTwoId);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
