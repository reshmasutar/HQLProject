package demo;

import domain.Product;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import java.util.List;
import java.util.Map;

public class HCQLDemo2 {
    public static void main(String[] args) {
        Configuration cfg;
        SessionFactory factory;
        Session ses;

        cfg = new Configuration();
        cfg = cfg.configure();
        cfg = cfg.addAnnotatedClass(Product.class);
        factory = cfg.buildSessionFactory();
        ses = factory.openSession();

        //fetch first 3 records from database table
        Criteria crt1 = ses.createCriteria(Product.class);
        crt1.setMaxResults(3);
        List<Product> productList = crt1.list();
        for (Product p:productList) {
            System.out.println(p);
        }

        System.out.println("========================================================================");

        //exclude first 3 records
        Criteria crt2 = ses.createCriteria(Product.class);
        crt2.setFirstResult(3);
        List<Product> productList1 = crt2.list();
        for(Product p:productList1){
            System.out.println(p);
        }

        System.out.println("============================================================================");
        //display product names of first 2 products
        Criteria crt3 = ses.createCriteria(Product.class);
        crt3.setMaxResults(2);
        crt3.setProjection(Projections.property("productName"));
        //execute Criteria
        List<String> names=crt3.list();
        for (String s:names) {
            System.out.println(s);
        }
        System.out.println("============================================================================");

        //display product details having price less than 30000
        Criteria crt4 = ses.createCriteria(Product.class);
        crt4.add(Restrictions.lt("productPrice", 30000.0));
        List<Product> productList2 = crt4.list();
        for (Product p:productList2) {
            System.out.println(p);
        }
        System.out.println("============================================================================");

        System.out.println("//display product details having price between 1000 and 5000");
        //display product details having price between 1000 and 5000
        Criteria crt5 = ses.createCriteria(Product.class);
        crt5.add(Restrictions.between("productPrice", 1000.0, 5000.0));
        List<Product> productList3 = crt5.list();
        for (Product p:productList3) {
            System.out.println(p);
        }
        System.out.println("============================================================================");
        //display all products from electronics category
        System.out.println("//display all products from electronics category");
        Criteria crt6 = ses.createCriteria(Product.class);
        crt6.add(Restrictions.eq("productCategory", "electronics"));
        List<Product> productList4 = crt6.list();
        for (Product p:productList4) {
            System.out.println(p);
        }

        System.out.println("============================================================================");
        System.out.println("display all products whose name start with L");
        Criteria crt7 = ses.createCriteria(Product.class);
        crt7.add(Restrictions.like("productName", "L%"));
        List<Product> productList6 = crt7.list();
        for (Product p:productList6) {
            System.out.println(p);
        }

        System.out.println("============================================================================");
        System.out.println("display all products from gadgets category having price greater than 10000");
        Criteria crt8 = ses.createCriteria(Product.class);
        crt8.add(Restrictions.eq("productCategory","gadgets"));
        crt8.add(Restrictions.gt("productPrice",10000.0));
        List<Product> productList8 = crt8.list();
        for (Product p:productList8) {
            System.out.println(p);
        }

        System.out.println("============================================================================");
        System.out.println("display all products in ascending order according to their price");
        Criteria crt9 = ses.createCriteria(Product.class);
        crt9.addOrder(Order.asc("productPrice"));
        List<Product> productList9 = crt9.list();
        for (Product p:productList9) {
            System.out.println(p);
        }

    }
}
