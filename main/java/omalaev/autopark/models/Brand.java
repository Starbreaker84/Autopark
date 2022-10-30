package omalaev.autopark.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "brand")
public class Brand {

    @Id
    @Column(name = "brand_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int brand_id;
    @Column(name = "brand_name")
    private String brandName;
    @Column(name = "vehicle_type")
    private String vehicleType;
    @Column(name = "gas_tank")
    private int gasTank;
    @Column(name = "load_capacity")
    private int loadCapacity;

    @Column(name = "capacity")
    private int capacity;

    @OneToMany(mappedBy = "brand")
    private List<Vehicle> vehicles;

    public int getBrand_id() {
        return brand_id;
    }

    public void setBrand_id(int brand_id) {
        this.brand_id = brand_id;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public int getGasTank() {
        return gasTank;
    }

    public void setGasTank(int gas_tank) {
        this.gasTank = gas_tank;
    }

    public int getLoadCapacity() {
        return loadCapacity;
    }

    public void setLoadCapacity(int loadCapacity) {
        this.loadCapacity = loadCapacity;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public List<Vehicle> getVehicles() {
        return vehicles;
    }

    public void setVehicles(List<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }
    public Brand() {

    }

    public Brand(String brandName, String vehicleType, int gasTank, int loadCapacity, int capacity) {
        this.brandName = brandName;
        this.vehicleType = vehicleType;
        this.gasTank = gasTank;
        this.loadCapacity = loadCapacity;
        this.capacity = capacity;
    }

}
