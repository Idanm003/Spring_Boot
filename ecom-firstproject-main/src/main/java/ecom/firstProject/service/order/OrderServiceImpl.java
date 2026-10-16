package ecom.firstProject.service.order;

import ecom.firstProject.model.customer.Customer;
import ecom.firstProject.model.order.Order;
import ecom.firstProject.requests.order.OrderRequest;
import ecom.firstProject.responses.OrderResponse;
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
            throw new Exception("Customer with id " + selectedCustomer.getCustomerId() + " not found");
        }
        List<Order> orderListForResponse = orderRepository.getAllOrdersByCustomerId(customerForResponse.getCustomerId());
        OrderResponse orderResponse = orderRequest.getOrder().toOrderResponse(
                customerForResponse,
                orderListForResponse
        );
        return orderResponse;
    }

    @Override
    public OrderResponse updateOrder(Order order) throws Exception {
        Customer customerForResponse = null;
        if (order.getCustomerId() != null) {
            Order existingOrder = orderRepository.getOrderById(order.getCustomerId());
            if (existingOrder != null) {
                Integer updatedCustomerId = existingOrder.getCustomerId();
                Customer existingCustomer = customerService.getCustomerById(updatedCustomerId);
                if (existingCustomer != null) {
                    if (order.getCustomerId().equals(existingCustomer.getCustomerId())) {
                        orderRepository.updateOrder(order);
                        customerForResponse = existingCustomer;
                    } else {
                        throw new Exception("Order with id " + existingOrder.getCustomerId() + " belongs to another customer!");
                    }
                }
                else {
                    throw new Exception("Customer with id " + existingCustomer.getCustomerId() + " not found!");
                }
            } else {
                throw new Exception("There is no customer in the request");
            }
        }
        List<Order> orderListForResponse = orderRepository.getAllOrdersByCustomerId(customerForResponse.getCustomerId());

        OrderResponse orderResponse = customerForResponse.toOrderResponse(
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
