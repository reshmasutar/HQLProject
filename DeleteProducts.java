package demo;

import domain.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.Query;

public class DeleteProducts {
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
        Query q = ses.createQuery("delete from Product p");
        int count = q.executeUpdate();//DML
        tx.commit();
        System.out.println(count+" PRODUCTS DELETED");
    }
}
