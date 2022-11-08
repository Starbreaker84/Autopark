package mycompany.autopark.models;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "vehicle")
public class Vehicle {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "year")
    @NotEmpty
    @Min(value = 1900, message = "Year should be greater than 1900!")
    private int year;
    @Column(name = "mileage")
    @NotEmpty
    private int mileage;
    @Column(name = "price")
    @NotEmpty
    @Min(value = 0, message = "Price should be greater than zero!")
    private int price;

    public Vehicle () {

    }

    public Vehicle(int year, int mileage, int price) {
        this.year = year;
        this.mileage = mileage;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMileage() {
        return mileage;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}