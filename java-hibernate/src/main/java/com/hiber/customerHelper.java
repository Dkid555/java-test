package com.hiber;

import com.hiber.entity.customers;
import jakarta.persistence.Query;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class customerHelper {
    private SessionFactory sessionFactory;

    public customerHelper() {
        sessionFactory = HibernateUtil.getSessionFactory();
    }

    public List<customers> getCustomersList() {
        Session session = sessionFactory.openSession(); // entrance to session
        // preparation
        session.get(customers.class, 1L);

        // Query construct
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery cq = cb.createQuery(customers.class);

        Root<customers> root = cq.from(customers.class);

        cq.select(root);


        // Query insertion
        Query query = session.createQuery(cq);

        List<customers> customersList = query.getResultList();

        session.close();

        return customersList;
    }

    public List<customers> getCustomersHQL() {
        try {
            Session session = sessionFactory.openSession();
            Query query = session.createQuery("FROM customers", customers.class);
            List<customers> customersList = query.getResultList();
            session.close();
            return customersList;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    public void addCustomer(String name, String address) {
        customers newOne = new customers(name, address);
        try (Session session = sessionFactory.openSession();) {
            session.beginTransaction();
            session.persist(newOne);
            session.getTransaction().commit();
            System.out.println("Data is added");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void addListCustomers(List<customers> newOnes) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            for (customers customer : newOnes
            ) {
                session.persist(customer); //save
            }
            session.getTransaction().commit();
            System.out.println("List of new customers added");
        } catch (Exception e) {
            System.out.println("Excepton:" + e);
        }
    }

    public void deleteByName(String name) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();

//            customers todel = new customers(name);
//            todel = session.find(customers.class, todel.getId());
//            session.remove(todel);
            String hql = "delete customers where name= :name";
            Query query = session.createQuery(hql).setParameter("name", name);
            int res = query.executeUpdate();
            if (res == 1) {
                System.out.println("Your delete successful");
            } else System.out.println("not succesful");
            session.getTransaction().commit();

        } catch (Exception e) {
            System.out.println(e);
        }
    }

//    public void addCustomer(customers customer){
//        Session session = sessionFactory.openSession();
//        //session.get(customers.class, 1L);
//
//    }

}
