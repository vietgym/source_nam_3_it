package hibernate;

import java.sql.Connection;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class patient_DAO {

	public static void main(String[] args) {
//      Connection myConn = jdbc.getConnection();
//      if (myConn != null) {
//          System.out.println("Connection successful!");
//      } else {
//          System.out.println("Connection failed!");
//      }
	

		insertPatient("Nguyen A", 1500000.0);
        insertPatient("Tran B", 2000000.0);
        insertPatient("Le C", 1200000.0);
        
//		Patient patient = getPatient(1);
//      System.out.println("Retrieved patient: " + patient);
        
        List<Patient> patients = getAllPatients();
        System.out.println("All patients:");
        for (Patient patient : patients) {
            System.out.println(patient);
        }

	}
	
	public static void insertPatient(String patientName, Double patientFee) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Patient.class)
                .buildSessionFactory();
        
        Session session = factory.getCurrentSession();
        
        try {
            System.out.println("Create new patient object");
            Patient tempFruit = new Patient(patientName, patientFee);
            
            session.beginTransaction();
            System.out.println("Saving..");
            session.save(tempFruit);
            session.getTransaction().commit();
            System.out.println("Done");
        } finally {
            factory.close();
        }
    }
	
	public static Patient getPatient(int patientId) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Patient.class)
                .buildSessionFactory();
        
        Session session = factory.getCurrentSession();
        
        try {
            session.beginTransaction();
            Patient patient = session.get(Patient.class, patientId);
            session.getTransaction().commit();

            return patient;
        } finally {
            factory.close();
        }
    }
	
	public static List<Patient> getAllPatients() {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Patient.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            session.beginTransaction();
            List<Patient> patients = session.createQuery("from Patient", Patient.class).getResultList();
            session.getTransaction().commit();
            return patients;
        } finally {
            factory.close();
        }
    }
}
