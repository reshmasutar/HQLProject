package demo;

import java.util.*;
import domain.Product;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DisplayAllProducts {
    public static void main(String[] args) {
        Configuration cfg;
        SessionFactory factory;
        Session ses;

        cfg=new Configuration();
        cfg=cfg.configure();
        cfg=cfg.addAnnotatedClass(Product.class);
        factory= cfg.buildSessionFactory();
        ses= factory.openSession();

        //HQL to display all the objects of product class
        Query q = ses.createQuery("select p from Product p");
        List<Product> productList=q.list();
        for (Product p:productList) {
            System.out.println(p);
        }
    }
}
