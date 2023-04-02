package demo;

import domain.Product;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;

;import java.util.Iterator;
import java.util.List;

public class HCQLDemo {
    public static void main(String[] args) {
        Configuration cfg;
        SessionFactory factory;
        Session ses;

        cfg = new Configuration();
        cfg = cfg.configure();
        cfg = cfg.addAnnotatedClass(Product.class);
        factory = cfg.buildSessionFactory();
        ses = factory.openSession();
        //Fetching details from all the columns
        //create criteria
        Criteria crt = ses.createCriteria(Product.class);
        //Execute criteria
        List<Product> productList = crt.list();
        for (Product p : productList) {
            System.out.println(p);
        }
        System.out.println("===================================================");
        //fetching details from specific columns
        //Create criteria
        Criteria crt2 = ses.createCriteria(Product.class);
        //ADD REQUIREMENT DETAILS
        crt2.setProjection(Projections.property("productName"));
        //execute Criteria
        List<String> names=crt2.list();
        for (String s:names) {
            System.out.println(s);
        }

        System.out.println("===================================================");
        //fetching details from name and price columns
        //Create criteria
        Criteria crt3 = ses.createCriteria(Product.class);
        //ADD REQUIREMENT DETAILS
        ProjectionList pList = Projections.projectionList();
        pList.add(Projections.property("productName"));
        pList.add(Projections.property("productPrice"));
        crt3.setProjection(pList);

        //execute Criteria
        List data = crt3.list();
        Iterator itr = data.iterator();
        while (itr.hasNext()){
            Object[] arr = (Object[]) itr.next();
            System.out.println(arr[0]+"\t\t"+arr[1]);
        }

    }
}
