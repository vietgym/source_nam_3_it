package main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import entity.Fruit;

public class creat {
    public static void insertFruit(String fruitName) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Fruit.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            System.out.println("Create new fruit object");
            Fruit tempFruit = new Fruit(fruitName);
            
            session.beginTransaction();
            System.out.println("Saving..");
            session.save(tempFruit);
            session.getTransaction().commit();
            System.out.println("Done");
        } finally {
            factory.close();
        }
    }
}
