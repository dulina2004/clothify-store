package edu.icet.bo.custom.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.icet.bo.custom.EmployeeBo;
import edu.icet.dao.DaoFactory;
import edu.icet.dao.custom.impl.EmployeeDaoImpl;
import edu.icet.entity.EmployeeEntity;
import edu.icet.model.Employee;
import edu.icet.util.DaoType;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class EmployeeBoImpl implements EmployeeBo {

    EmployeeDaoImpl employeeDaoImpl= DaoFactory.getInstance().getDao(DaoType.EMPLOYEE);
    public String generateEmployeeId() {
        String lastEmployeeId = EmployeeDaoImpl.getLatestId();
        if (lastEmployeeId==null){
            return "E0001";
        }
        int number = Integer.parseInt(lastEmployeeId.split("E")[1]);
        number++;
        return String.format("E%04d", number);
    }

    public String passwordEncrypt(String password) {
        return new String(Base64.getEncoder().encode(password.getBytes(StandardCharsets.UTF_8)));
    }

    public boolean isValidEmail(String email) {
        String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
        return email.matches(regex);
    }

    public boolean insertUser(Employee employee) {
        EmployeeEntity userEntity = new ObjectMapper().convertValue(employee, EmployeeEntity.class);
        return employeeDaoImpl.insert(userEntity);
    }

    public ObservableList getAllUsers() {

        ObservableList<EmployeeEntity> list = employeeDaoImpl.searchAll();
        ObservableList<Employee> userList = FXCollections.observableArrayList();

        list.forEach(userEntity -> {
            userList.add(new ObjectMapper().convertValue(userEntity,Employee.class));
        });
        return userList;
    }

    public boolean updateUser(Employee employee) {
        EmployeeEntity userEntity = new ObjectMapper().convertValue(employee, EmployeeEntity.class);
        return employeeDaoImpl.update(userEntity);
    }

    public boolean deleteUserById(String text) {
        return employeeDaoImpl.delete(text);
    }
}
