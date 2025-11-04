package org.anudip.model;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "booking")
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int booking_id;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "vehicle_id")
    private Vehicle vehicle;

    @Temporal(TemporalType.DATE)
    private Date start_date;

    @Temporal(TemporalType.DATE)
    private Date end_date;

    private double total_amount;
    private String status;

    public Booking() {}

    public Booking(Customer customer, Vehicle vehicle, Date start_date, Date end_date, double total_amount, String status) {
        this.customer = customer;
        this.vehicle = vehicle;
        this.start_date = start_date;
        this.end_date = end_date;
        this.total_amount = total_amount;
        this.status = status;
    }

    // Getters and Setters
    public int getBooking_id() { return booking_id; }
    public void setBooking_id(int booking_id) { this.booking_id = booking_id; }

    public Customer getCustomer() { return customer; }
    public void setCustomer(Customer customer) { this.customer = customer; }

    public Vehicle getVehicle() { return vehicle; }
    public void setVehicle(Vehicle vehicle) { this.vehicle = vehicle; }

    public Date getStart_date() { return start_date; }
    public void setStart_date(Date start_date) { this.start_date = start_date; }

    public Date getEnd_date() { return end_date; }
    public void setEnd_date(Date end_date) { this.end_date = end_date; }

    public double getTotal_amount() { return total_amount; }
    public void setTotal_amount(double total_amount) { this.total_amount = total_amount; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    @Override
    public String toString() {
        return booking_id + " | " + customer.getName() + " | " + vehicle.getVehicle_name() + " | " + total_amount + " | " + status;
    }
}

