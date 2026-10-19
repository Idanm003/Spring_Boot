package ecom.firstProject.service.order;

import ecom.firstProject.model.customer.Customer;
import ecom.firstProject.model.order.Order;
import ecom.firstProject.requests.order.OrderRequest;
import ecom.firstProject.responses.order.OrderResponse;
import ecom.firstProject.service.customer.CustomerService;
import ecom.firstProject.repository.order.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private CustomerService customerService;

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
    public OrderResponse createOrder(OrderRequest orderRequest) throws Exception {
        Customer selectedCustomer = orderRequest.getCustomer();
        Customer customerForResponse = null;

        if (selectedCustomer != null) {
            if (selectedCustomer.getCustomerId() != null) {
                Customer existingCustomer = customerService.getCustomerById(selectedCustomer.getCustomerId());
                if (existingCustomer != null) {
                    orderRepository.createOrder(orderRequest.toOrder());
                    customerForResponse = existingCustomer;
                } else {
                    throw new Exception("Customer with id " + selectedCustomer.getCustomerId() + " not found");
                }
            } else {
                Integer createdCustomerId = customerService.createCustomer(selectedCustomer);
                Order orderToCreate = orderRequest.toOrder();
                orderToCreate.setCustomerId(createdCustomerId);
                orderRepository.createOrder(orderToCreate);
                customerForResponse = customerService.getCustomerById(createdCustomerId);
            }
        } else {
            throw new Exception("Customer is missing in the request");
        }
        List<Order> orderListForResponse = orderRepository.getAllOrdersByCustomerId(customerForResponse.getCustomerId());
        return orderRequest.getOrder().toOrderResponse(
                customerForResponse,
                orderListForResponse
        );
    }

    @Override
    public OrderResponse updateOrder(Order order) throws Exception {
        if (order.getCustomerId() == null) {
            throw new Exception("There is no customer in the request");
        }
        Order existingOrder = orderRepository.getOrderById(order.getOrderId());
        if (existingOrder == null) {
            throw new Exception("Order with id " + order.getOrderId() + " not found!");
        }
        if (!order.getCustomerId().equals(existingOrder.getCustomerId())) {
            throw new Exception("Order with id " + existingOrder.getOrderId() + " belongs to another customer!");
        }
        Customer customerForResponse = customerService.getCustomerById(existingOrder.getCustomerId());
        if (customerForResponse == null) {
            throw new Exception("Customer with id " + existingOrder.getCustomerId() + " not found!");
        }
        orderRepository.updateOrder(order);
        List<Order> orderListForResponse = orderRepository.getAllOrdersByCustomerId(customerForResponse.getCustomerId());

        OrderResponse orderResponse = order.toOrderResponse(
                customerForResponse,
                orderListForResponse
        );
        return orderResponse;
    }

    @Override
    public void deleteOrderById(Integer id) throws Exception {
        orderRepository.deleteOrderById(id);
    }
}
