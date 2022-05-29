package services;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;
import java.util.Properties;

import model.Car;
import model.Customer;

public class DBHandler implements Storage {
	private static StandardServiceRegistry registry;
    private static SessionFactory factory;
	
	public DBHandler() {
		//super();
		// TODO Auto-generated constructor stub
		if (factory == null) {
            try {
            
            	Configuration configuration = new Configuration();
            	
            	Properties settings = new Properties();
				settings.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
				settings.put(Environment.URL, "jdbc:mysql://localhost:3306/crms_db?useSSL=false");
				settings.put(Environment.USER, "root");
				settings.put(Environment.PASS, "ehacker321");
				settings.put(Environment.DIALECT, "org.hibernate.dialect.MySQL5Dialect");
	
				settings.put(Environment.SHOW_SQL, "true");
	
				settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
	
				//settings.put(Environment.HBM2DDL_AUTO, "create-drop");
	
				configuration.setProperties(settings);
				
				//configuration.addAnnotatedClass(Customer.class);
				configuration.addAnnotatedClass(Car.class);
				//configuration.addAnnotatedClass(Course.class);
				//configuration.addAnnotatedClass(InstructorDetail.class);
	
	
				ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
						.applySettings(configuration.getProperties()).build();
				
				factory = configuration.buildSessionFactory(serviceRegistry);


            } catch (Exception e) {
                e.printStackTrace();
                if (registry != null) {
                    StandardServiceRegistryBuilder.destroy(registry);
                }
            }
        } else {
        	System.out.println("Session factory not null!");
        }
	}
	
	public static void shutdown() {
        if (registry != null) {
            StandardServiceRegistryBuilder.destroy(registry);
        }
    }

	public static SessionFactory getSessionFactory() {
        return factory;
	}
	
    @Override
    public void AddNewCar (Car c) {
        Boolean isAdded = null;
        Session session = DBHandler.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        try {
            session.save(c);
//            session.save(newDonor.getContactInfo());
//            session.save(newDonor);
            tx.commit();
            isAdded = true;
        } catch (Exception e){
           System.out.println("Phone number is used by another donor");
            isAdded = false;
        }
        session.close();
    }
//
//   
//    @Override
//    public Donor getDonor(String donorId) {
//        Session session = FactoryProvider.getFactory().openSession();
//        Transaction tx = session.beginTransaction();
//        Donor donor = (Donor)session.get(Donor.class, donorId);
//        tx.commit();
//        session.close();
//        return donor;
//    }
//
//    @Override
//    public List<Available_Slot> getAllAvailableSlots() {
//        Session session = FactoryProvider.getFactory().openSession();
//        CriteriaBuilder cb = session.getCriteriaBuilder();
//        CriteriaQuery<Available_Slot> cq = cb.createQuery(Available_Slot.class);
//        Root<Available_Slot> rootEntry = cq.from(Available_Slot.class);
//        CriteriaQuery<Available_Slot> all = cq.select(rootEntry);
//        TypedQuery<Available_Slot> allQuery = session.createQuery(all);
//        return allQuery.getResultList();
//    }
//
//    @Override
//    public void insertAvailableSlot(Available_Slot slot) {
//        Session session = FactoryProvider.getFactory().openSession();
//        Transaction tx = session.beginTransaction();
//        session.save(slot);
//        tx.commit();
//        session.close();
//    }
//
//    @Override
//    public Boolean saveDonation(Donation donation) {
//        Boolean isAdded = null;
//        Session session = FactoryProvider.getFactory().openSession();
//        Transaction tx = session.beginTransaction();
//        for (Item item : donation.getItems()) {
//                if (item instanceof Book){
//                    session.save(((Book) item).getTitle());
//                }
//                if (item instanceof DonatedMoney){
//                    session.save(((DonatedMoney) item).getPayment());
//                }
//                session.save(item);
//        }
//        isAdded = false;
//        session.save(donation);
//        tx.commit();
//        session.close();
//        return isAdded;
//    }


   


}
