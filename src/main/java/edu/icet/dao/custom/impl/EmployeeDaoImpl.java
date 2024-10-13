package edu.icet.dao.custom.impl;

import edu.icet.dao.custom.EmployeeDao;
import edu.icet.entity.EmployeeEntity;
import edu.icet.util.HibernateUtil;
import javafx.collections.ObservableList;
import org.hibernate.Session;
import org.hibernate.query.Query;

public class EmployeeDaoImpl implements EmployeeDao {
    public static String getLatestId() {
        Session session = HibernateUtil.getSession();
        session.getTransaction().begin();

        Query query = session.createQuery("SELECT id FROM user ORDER BY id DESC LIMIT 1");
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
        return null;
    }

    @Override
    public boolean insert(EmployeeEntity employeeEntity) {
        System.out.println("asdada");
        Session session = HibernateUtil.getSession();
        session.getTransaction().begin();
        session.persist(employeeEntity);
        session.getTransaction().commit();
        session.close();
        return true;
    }

    @Override
    public boolean update(EmployeeEntity employeeEntity) {
        return false;
    }

    @Override
    public boolean delete(String s) {
        return false;
    }
}
