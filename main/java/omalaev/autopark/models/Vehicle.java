package omalaev.autopark.models;

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
    @Min(value = 1900, message = "Year should be greater than 1900!")
    private int year;
    @Column(name = "mileage")
    private int mileage;
    @Column(name = "price")
    @Min(value = 0, message = "Price should be greater than zero!")
    private int price;

    @ManyToOne
    @JoinColumn(name = "brand", referencedColumnName = "brand_id")
    private Brand brand;

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

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public Vehicle () {

    }

    public Vehicle(int year, int mileage, int price, Brand brand) {
        this.year = year;
        this.mileage = mileage;
        this.price = price;
        this.brand = brand;
    }
}
