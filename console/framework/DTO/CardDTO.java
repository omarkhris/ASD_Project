package edu.mum.cs.cs525.labs.exercises.project.console.framework.DTO;


import edu.mum.cs.cs525.labs.exercises.project.console.framework.model.Address;

public class CardDTO {
    String clientName, street, city, zip, state, accountType, expdate, ccnumber,email;

    double creditCardLimit;

    Address address;

    public CardDTO(String clientName, Address address, double creditCardLimit ,String accountType, String expdate, String ccnumber, String email) {
        this.clientName = clientName;
        this.address = address;
        this.creditCardLimit = creditCardLimit;
        this.accountType = accountType;
        this.expdate = expdate;
        this.ccnumber = ccnumber;
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public Address getAddress() {
        return new Address(street, city, state, zip);
    }

    public String getClientName() {
        return clientName;
    }

    public String getAccountType() {
        return accountType;
    }


    public String getExpdate() {
        return expdate;
    }

    public String getCcnumber() {
        return ccnumber;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public void setExpdate(String expdate) {
        this.expdate = expdate;
    }

    public void setCcnumber(String ccnumber) {
        this.ccnumber = ccnumber;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getCreditCardLimit() {
        return creditCardLimit;
    }

    public void setCreditCardLimit(double creditCardLimit) {
        this.creditCardLimit = creditCardLimit;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
