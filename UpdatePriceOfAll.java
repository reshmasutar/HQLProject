package demo;

import domain.Product;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;
import java.util.Scanner;

public class UpdatePriceOfAll {
    public static void main(String[] args) {

        Configuration cfg;
        SessionFactory factory;
        Session ses;
        Transaction tx;

        cfg = new Configuration();
        cfg = cfg.configure();
        cfg = cfg.addAnnotatedClass(Product.class);
        factory = cfg.buildSessionFactory();
        ses = factory.openSession();

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter category: ");
        String category = sc.next();
        System.out.println("Enter price: ");
        double price = sc.nextDouble();

        //HQL to display all the objects of product class
        tx=ses.beginTransaction();
        Query q = ses.createQuery("update Product p set p.productPrice='"+price+"' where p.productCategory='"+category+"'");
        int count = q.executeUpdate();//DML
        tx.commit();
        System.out.println(count+" PRODUCTS UPDATED");
    }
}

