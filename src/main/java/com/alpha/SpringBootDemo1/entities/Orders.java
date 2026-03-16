package com.alpha.SpringBootDemo1.entities;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToMany
    private List<Product> purchaselist;

    // MANY orders → ONE customer
    @ManyToOne
    private Customer customer;

    //MANY orders → ONE carrier
    @ManyToOne
    private Carrier carrier;

    private String orderStatus = "pending";

    // MANY orders → SAME address allowed
    @ManyToOne
    private Address pickupLocation;

    @ManyToOne
    private Address deliveryLocation;

    private LocalDate date;
    private int otp;
    private LocalDate expectedDelivaryDate;
    private double totalPrice;

   

    public Orders() {
        super();
    }

    public Orders(int id, List<Product> purchaselist, Customer customer, Carrier carrier,
                  String orderStatus, Address pickupLocation, LocalDate date, int otp,
                  Address deliveryLocation, LocalDate expectedDelivaryDate, double totalPrice) {
        this.id = id;
        this.purchaselist = purchaselist;
        this.customer = customer;
        this.carrier = carrier;
        this.orderStatus = orderStatus;
        this.pickupLocation = pickupLocation;
        this.date = date;
        this.otp = otp;
        this.deliveryLocation = deliveryLocation;
        this.expectedDelivaryDate = expectedDelivaryDate;
        this.totalPrice = totalPrice;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Product> getPurchaselist() {
        return purchaselist;
    }

    public void setPurchaselist(List<Product> purchaselist) {
        this.purchaselist = purchaselist;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void setCust(Customer cust) {
        this.customer = cust;
    }

    public Carrier getCarrier() {
        return carrier;
    }

    public void setCarrier(Carrier carrier) {
        this.carrier = carrier;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Address getPickupLocation() {
        return pickupLocation;
    }

    public void setPickupLocation(Address pickupLocation) {
        this.pickupLocation = pickupLocation;
    }

    public Address getDeliveryLocation() {
        return deliveryLocation;
    }

    public void setDeliveryLocation(Address deliveryLocation) {
        this.deliveryLocation = deliveryLocation;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public int getOtp() {
        return otp;
    }

    public void setOtp(int otp) {
        this.otp = otp;
    }

    public LocalDate getExpectedDelivaryDate() {
        return expectedDelivaryDate;
    }

    public void setExpectedDelivaryDate(LocalDate expectedDelivaryDate) {
        this.expectedDelivaryDate = expectedDelivaryDate;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    @Override
    public String toString() {
        return "Orders [id=" + id + ", purchaselist=" + purchaselist + ", customer=" + customer +
                ", carrier=" + carrier + ", orderStatus=" + orderStatus +
                ", pickupLocation=" + pickupLocation + ", date=" + date +
                ", otp=" + otp + ", deliveryLocation=" + deliveryLocation +
                ", expectedDelivaryDate=" + expectedDelivaryDate +
                ", totalPrice=" + totalPrice + "]";
    }
}

	
