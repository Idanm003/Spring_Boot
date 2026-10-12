package ecom.firstProject.Service.Order;

import ecom.firstProject.model.Order.Order;

import java.util.List;

public interface OrderService {
    Order getOrderById(Integer id);
    List<Order> getAllOrders();
    List<Integer> getAllIdsByFullName(String fullName);
    void createOrder(Order order);
    void updateOrder(Order order);
    void deleteOrderById(Integer id);
}
