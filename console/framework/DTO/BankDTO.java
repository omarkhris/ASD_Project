package edu.mum.cs.cs525.labs.exercises.project.console.framework.DTO;

import edu.mum.cs.cs525.labs.exercises.project.console.framework.model.Address;

public class BankDTO {
    String accountnr, clientName, street, city, zip, state, accountType, email, clientType, birthDate, numberOfMember;
    double currentBalance;

    Address address;

    public BankDTO(String accountnr, String clientName, Address address, String accountType, String email, String clientType, double currentBalance,String birthDate,String numberOfMember) {
        this.accountnr = accountnr;
        this.clientName = clientName;
        this.address = address;
        this.accountType = accountType;
        this.email = email;
        this.clientType = clientType;
        this.currentBalance = currentBalance;
        this.birthDate = birthDate;
        this.numberOfMember = numberOfMember;
    }

    public String getNumberOfMember() {
        return numberOfMember;
    }

    public double getCurrentBalance() {
        return currentBalance;
    }

    public void setCurrentBalance(double currentBalance) {
        this.currentBalance = currentBalance;
    }

    public String getAccountnr() {
        return accountnr;
    }

    public void setAccountnr(String accountnr) {
        this.accountnr = accountnr;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getClientType() {
        return clientType;
    }

    public void setClientType(String clientType) {
        this.clientType = clientType;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public Address getAddress() {
        return new Address(street, city, zip, state);
    }
}



