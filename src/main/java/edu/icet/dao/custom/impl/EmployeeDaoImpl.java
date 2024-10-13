package edu.icet.dao.custom.impl;

import edu.icet.dao.custom.EmployeeDao;
import edu.icet.entity.EmployeeEntity;
import edu.icet.util.HibernateUtil;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class EmployeeDaoImpl implements EmployeeDao {
    public static String getLatestId() {
        Session session = HibernateUtil.getSession();
        session.getTransaction().begin();

        Query query = session.createQuery("SELECT id FROM employee ORDER BY id DESC LIMIT 1");
        String id = (String) query.uniqueResult();
        session.close();
        return id;
    }

    @Override
    public EmployeeEntity search(String s) {
        return null;
    }

    @Override
    public ObservableList<EmployeeEntity> searchAll() {
        Session session = HibernateUtil.getSession();
        Transaction transaction = session.getTransaction();
        List<EmployeeEntity> userList = session.createQuery("FROM employee").list();
        ObservableList<EmployeeEntity> list= FXCollections.observableArrayList();
        session.close();
        userList.forEach(userEntity -> {
            list.add(userEntity);
        });
        return list;
    }

    @Override
    public boolean insert(EmployeeEntity employeeEntity) {
        Session session = HibernateUtil.getSession();
        session.getTransaction().begin();
        session.persist(employeeEntity);
        session.getTransaction().commit();
        session.close();
        return true;
    }

    @Override
    public boolean update(EmployeeEntity employeeEntity) {
        Session session = HibernateUtil.getSession();
        session.getTransaction().begin();
        Query query = session.createQuery("UPDATE employee SET name =:name,nic =:nic,email =:email ,mobile =:mobile WHERE id =:id");
        query.setParameter("name",employeeEntity.getName());
        query.setParameter("nic",employeeEntity.getNic());
        query.setParameter("email",employeeEntity.getEmail());
        query.setParameter("mobile",employeeEntity.getMobile());
        query.setParameter("id",employeeEntity.getId());

        int i = query.executeUpdate();
        session.getTransaction().commit();
        session.close();
        return i>0;
    }

    @Override
    public boolean delete(String id) {
        Session session = HibernateUtil.getSession();
        session.getTransaction().begin();
        Query query = session.createQuery("DELETE FROM employee WHERE id=:id");
        query.setParameter("id",id);
        int i = query.executeUpdate();
        session.getTransaction().commit();
        session.close();
        return i>0;
    }

    public EmployeeEntity searchByName(String name) {
        Session session = HibernateUtil.getSession();
        session.getTransaction();

        Query query = session.createQuery("FROM employee WHERE name=:name");
        query.setParameter("name",name);
        EmployeeEntity userEntity = (EmployeeEntity) query.uniqueResult();
        session.close();
        return userEntity;
    }
}
