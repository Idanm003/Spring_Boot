package ecom.firstProject.model.customer;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Customer {
    @JsonProperty ("id")
    private Integer customerId;
    private String firstName;
    private String lastName;
    private String email;
    private CustomerStatus customerStatus;

    public Customer(Integer customerId, String firstName, String lastName, String email, CustomerStatus customerStatus) {
        this.customerId = customerId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.customerStatus = customerStatus;
    }

    public Customer(){}

    public Integer getCustomerId() {
        return customerId;
    }
    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public String getEmail() {
        return email;
    }
    public CustomerStatus getCustomerStatus() {
        return customerStatus;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setCustomerStatus(CustomerStatus customerStatus) {
        this.customerStatus = customerStatus;
    }

}