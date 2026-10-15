package ecom.firstProject.service.order;

import ecom.firstProject.model.order.Order;
import ecom.firstProject.repository.order.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tools.jackson.databind.ObjectMapper;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public Order getOrderById(Integer id) {
        return orderRepository.getOrderById(id);
    }

    @Override
    public List<Order> getAllOrders() {
        return orderRepository.getAllOrders();
    }

    @Override
    public List<Integer> getAllIdsByFullName(String fullName) {
        return orderRepository.getAllIdsByFullName(fullName);
    }

    @Override
    public void createOrder(Order order) {
        orderRepository.createOrder(order);
    }

    @Override
    public void updateOrder(Order order) {
        orderRepository.updateOrder(order);
    }

    @Override
    public void deleteOrderById(Integer id) {
        orderRepository.deleteOrderById(id);
    }
}
