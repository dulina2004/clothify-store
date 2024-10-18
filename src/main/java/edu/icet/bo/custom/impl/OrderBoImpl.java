package edu.icet.bo.custom.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.icet.bo.custom.OrderBo;
import edu.icet.dao.DaoFactory;
import edu.icet.dao.custom.OrderDao;
import edu.icet.entity.CustomerEntity;
import edu.icet.entity.ItemEntity;
import edu.icet.entity.OrderEntity;
import edu.icet.model.Item;
import edu.icet.model.Order;
import edu.icet.util.DaoType;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.modelmapper.ModelMapper;

public class OrderBoImpl implements OrderBo {
    OrderDao orderDao= DaoFactory.getInstance().getDao(DaoType.ORDER);
    @Override
    public String generateOrderId() {
        String lastItemId = orderDao.getLatestId();
        if (lastItemId==null){
            return "OR0001";
        }
        int number = Integer.parseInt(lastItemId.split("OR")[1]);
        number++;
        return String.format("OR%04d", number);
    }

    @Override
    public boolean insertOrder(Order order) {
        System.out.println(order);
        CustomerEntity customer=new ObjectMapper().convertValue(order.getCustomer(),CustomerEntity.class);
        OrderEntity orderEntity=new OrderEntity(order.getId(),customer,order.getDate(),order.getNetTotal());
        System.out.println(orderEntity);
        return orderDao.save(orderEntity);
    }

    @Override
    public ObservableList getAllOrders() {
        ObservableList<OrderEntity> list = orderDao.getAll();
        ObservableList<Order> orderList = FXCollections.observableArrayList();

        list.forEach(itemEntity -> {
            orderList.add(new ObjectMapper().convertValue(itemEntity,Order.class));
        });
        return orderList;
    }

    @Override
    public boolean deleteOrderById(String text) {
        return orderDao.delete(text);
    }

    @Override
    public Order searchOrderByID(String id) {
        OrderEntity orderEntity = orderDao.search(id);
        return new ObjectMapper().convertValue(orderEntity,Order.class);
    }
}
