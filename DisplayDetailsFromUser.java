package demo;

import domain.Product;
import org.hibernate.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.*;
import java.util.Scanner;

public class DisplayDetailsFromUser {
    public static void main(String[] args) {

            Configuration cfg;
            SessionFactory factory;
            Session ses;

            cfg=new Configuration();
            cfg=cfg.configure();
            cfg=cfg.addAnnotatedClass(Product.class);
            factory= cfg.buildSessionFactory();
            ses= factory.openSession();

            Scanner sc= new Scanner(System.in);
            System.out.println("Enter category: ");
            String category = sc.next();

            //HQL to display all the objects of product class
            Query q = ses.createQuery("select p from Product p where p.productCategory= '"+category+"'");
            List<Product> productList = q.list();//for dql statement
            for (Product p : productList) {
                System.out.println(p);
            }
    }

}
