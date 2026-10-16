package ecom.firstProject.requests.order;

import ecom.firstProject.model.customer.Customer;
import ecom.firstProject.model.order.Order;

import java.util.List;

public class OrderResponse {
    private Customer customer;
    private List<Order> orderList;

    public OrderResponse(Customer customer, List<Order> orderList) {
        this.customer = customer;
        this.orderList = orderList;
    }

    public Customer getCustomer() {
        return this.customer;
    }
    public List<Order> getOrders() {
        return this.orderList;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
    public void setOrders(List<Order> orderList) {
        this.orderList = orderList;
    }
}