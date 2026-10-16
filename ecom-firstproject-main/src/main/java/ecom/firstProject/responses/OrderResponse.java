package ecom.firstProject.responses;

import ecom.firstProject.model.customer.Customer;
import ecom.firstProject.model.order.Order;

import java.util.List;

public class OrderResponse {
    private Customer customer;
    private List<Order> orders;

    public OrderResponse(Customer customer, List<Order> orders) {
        this.customer = customer;
        this.orders = orders;
    }

    public Customer getCustomer() {
        return customer;
    }
    public List<Order> getOrders() {
        return orders;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }
}
