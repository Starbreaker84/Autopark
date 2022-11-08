package omalaev.autopark.models;

import javax.persistence.*;
import javax.validation.constraints.Min;
import java.util.List;

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

    @ManyToOne
    @JoinColumn(name = "enterprise", referencedColumnName = "enterprise_id")
    private Enterprise enterprise;

    @OneToMany(mappedBy = "vehicle")
    private List<Driver> driverList;

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

    public Enterprise getEnterprise() {
        return enterprise;
    }

    public void setEnterprise(Enterprise enterprise) {
        this.enterprise = enterprise;
    }

    public Vehicle () {

    }
}
