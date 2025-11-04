package org.anudip.model;
import jakarta.persistence.*;

@Entity
@Table(name = "vehicle")
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int vehicle_id;

    private String vehicle_name;
    private String type;
    private double rent_per_day;
    private String status;

    // Constructors
    public Vehicle() {}
    public Vehicle(String vehicle_name, String type, double rent_per_day, String status) {
        this.vehicle_name = vehicle_name;
        this.type = type;
        this.rent_per_day = rent_per_day;
        this.status = status;
    }

    // Getters and Setters
    public int getVehicle_id() { return vehicle_id; }
    public void setVehicle_id(int vehicle_id) { this.vehicle_id = vehicle_id; }

    public String getVehicle_name() { return vehicle_name; }
    public void setVehicle_name(String vehicle_name) { this.vehicle_name = vehicle_name; }

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    public double getRent_per_day() { return rent_per_day; }
    public void setRent_per_day(double rent_per_day) { this.rent_per_day = rent_per_day; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    @Override
    public String toString() {
        return vehicle_id + " | " + vehicle_name + " | " + type + " | " + rent_per_day + " | " + status;
    }
}
