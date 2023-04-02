package demo;

import domain.Product;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class UpdatePrice {
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
        tx = ses.beginTransaction();
        Query q = ses.createQuery("update Product p set p.productPrice=20000");
        int count = q.executeUpdate();//DML
        tx.commit();
        System.out.println(count+" PRODUCTS UPDATED");
    }
}
