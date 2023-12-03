package main;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import entity.Fruit;

public class getall {
    public static List<Fruit> getAllFruits() {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Fruit.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            session.beginTransaction();
            Query<Fruit> query = session.createQuery("from Fruit", Fruit.class);
            List<Fruit> fruits = query.getResultList();
            session.getTransaction().commit();
            return fruits;
        } finally {
            factory.close();
        }
    }
}
