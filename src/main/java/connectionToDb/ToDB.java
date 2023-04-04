package connectionToDb;

import entity.Customer;
import entity.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class ToDB {
    public SessionFactory configuration() {
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");
        configuration.addAnnotatedClass(Customer.class);
        configuration.addAnnotatedClass(Product.class);

        SessionFactory sessionFactory = configuration.buildSessionFactory();
        return sessionFactory;
    }

    public void setProductInfo(Product product) {
        SessionFactory sessionFactory = this.configuration();
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.save(product);
            transaction.commit();
        } catch (Exception e) {
            System.err.println("Error Details ::" + e.getMessage());
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public void seCustomerInfo(Customer customer) {
        SessionFactory sessionFactory = this.configuration();
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.save(customer);
            transaction.commit();
        } catch (Exception e) {
            System.err.println("Error Details ::" + e.getMessage());
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public Product fetchProduct(int id) {
        Product prod = new Product();
       SessionFactory sessionFactory = configuration();
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            prod = session.get(Product.class, id);
        } catch (Exception e) {
            System.err.println("Error Details ::" + e.getMessage());
            tx.rollback();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return prod;
    }
}
