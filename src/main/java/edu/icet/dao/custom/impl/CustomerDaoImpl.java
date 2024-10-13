package edu.icet.dao.custom.impl;

import edu.icet.dao.custom.CustomerDao;
import edu.icet.entity.CustomerEntity;
import edu.icet.entity.EmployeeEntity;
import edu.icet.util.HibernateUtil;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class CustomerDaoImpl implements CustomerDao {
    @Override
    public CustomerEntity search(String s) {
        return null;
    }

    @Override
    public ObservableList<CustomerEntity> searchAll() {
        Session session = HibernateUtil.getSession();
        Transaction transaction = session.getTransaction();
        List<CustomerEntity> userList = session.createQuery("FROM customer").list();
        ObservableList<CustomerEntity> list= FXCollections.observableArrayList();
        session.close();
        userList.forEach(userEntity -> {
            list.add(userEntity);
        });
        return list;
    }

    @Override
    public boolean insert(CustomerEntity customerEntity) {
        Session session = HibernateUtil.getSession();
        session.getTransaction().begin();
        session.persist(customerEntity);
        session.getTransaction().commit();
        session.close();
        return true;
    }

    @Override
    public boolean update(CustomerEntity customerEntity) {
        Session session = HibernateUtil.getSession();
        session.getTransaction().begin();
        Query query = session.createQuery("UPDATE customer SET name =:name,email =:email ,address =:address WHERE id =:id");
        query.setParameter("name",customerEntity.getName());
        query.setParameter("email",customerEntity.getEmail());
        query.setParameter("address",customerEntity.getAddress());
        query.setParameter("id",customerEntity.getId());

        int i = query.executeUpdate();
        session.getTransaction().commit();
        session.close();
        return i>0;
    }

    @Override
    public boolean delete(String id) {
        Session session = HibernateUtil.getSession();
        session.getTransaction().begin();
        Query query = session.createQuery("DELETE FROM customer WHERE id=:id");
        query.setParameter("id",id);
        int i = query.executeUpdate();
        session.getTransaction().commit();
        session.close();
        return i>0;
    }

    public CustomerEntity searchByName(String name) {
        Session session = HibernateUtil.getSession();
        session.getTransaction();

        Query query = session.createQuery("FROM customer WHERE name=:name");
        query.setParameter("name",name);
        CustomerEntity userEntity = (CustomerEntity) query.uniqueResult();
        session.close();
        return userEntity;
    }

    public static String getLatestId() {
        Session session = HibernateUtil.getSession();
        session.getTransaction().begin();

        Query query = session.createQuery("SELECT id FROM customer ORDER BY id DESC LIMIT 1");
        String id = (String) query.uniqueResult();
        session.close();
        return id;
    }
}
