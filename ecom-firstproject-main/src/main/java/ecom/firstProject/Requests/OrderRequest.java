package ecom.firstProject.Requests;

import ecom.firstProject.model.Customer.Customer;
import ecom.firstProject.model.Order.Order;

public class OrderRequest {
    private Customer customer;
    private Order order;

    public OrderRequest(Customer customer, Order order) {
        this.customer = customer;
        this.order = order;
    }

    public Customer getCustomer() {
        return this.customer;
    }
    public Order getOrder() {
        return this.order;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
    public void setOrder(Order order) {
        this.order = order;
    }
}
