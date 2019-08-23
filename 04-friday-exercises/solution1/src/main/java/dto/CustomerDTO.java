package dto;

import entities.BankCustomer;

/**
 *
 */
public class CustomerDTO {

    int customerID;
    String fullName;
    String accountNumber;
    double balance;

    public CustomerDTO(BankCustomer b) {
        this.customerID = b.getId();
        this.fullName = b.getFirstName() + " " + b.getLastName();
        this.accountNumber = b.getAccountNumber();
        this.balance = b.getBalance();
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
    
}
