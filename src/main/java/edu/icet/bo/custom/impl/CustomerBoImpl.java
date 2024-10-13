package edu.icet.bo.custom.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.icet.bo.custom.CustomerBo;
import edu.icet.dao.DaoFactory;
import edu.icet.dao.custom.impl.CustomerDaoImpl;
import edu.icet.dao.custom.impl.EmployeeDaoImpl;
import edu.icet.entity.CustomerEntity;
import edu.icet.entity.EmployeeEntity;
import edu.icet.model.Customer;
import edu.icet.model.Employee;
import edu.icet.util.DaoType;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class CustomerBoImpl implements CustomerBo {

    CustomerDaoImpl customerDaoImpl= DaoFactory.getInstance().getDao(DaoType.CUSTOMER);
    public String generateCustomerId() {
        String lastCustomerId = CustomerDaoImpl.getLatestId();
        if (lastCustomerId==null){
            return "C0001";
        }
        int number = Integer.parseInt(lastCustomerId.split("C")[1]);
        number++;
        return String.format("C%04d", number);
    }

    public String passwordEncrypt(String password) {
        return new String(Base64.getEncoder().encode(password.getBytes(StandardCharsets.UTF_8)));
    }

    public boolean isValidEmail(String email) {
        String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
        return email.matches(regex);
    }

    public boolean insertUser(Customer customer) {
        CustomerEntity userEntity = new ObjectMapper().convertValue(customer, CustomerEntity.class);
        return customerDaoImpl.insert(userEntity);
    }

    public ObservableList getAllUsers() {

        ObservableList<CustomerEntity> list = customerDaoImpl.searchAll();
        ObservableList<Customer> userList = FXCollections.observableArrayList();

        list.forEach(userEntity -> {
            userList.add(new ObjectMapper().convertValue(userEntity,Customer.class));
        });
        return userList;
    }

    public boolean updateUser(Customer customer) {
        CustomerEntity userEntity = new ObjectMapper().convertValue(customer, CustomerEntity.class);
        return customerDaoImpl.update(userEntity);
    }

    public boolean deleteUserById(String text) {
        return customerDaoImpl.delete(text);
    }


    public Customer searchUserByName(String name) {
        CustomerEntity customerEntity = customerDaoImpl.searchByName(name);
        return new ObjectMapper().convertValue(customerEntity,Customer.class);
    }
}
