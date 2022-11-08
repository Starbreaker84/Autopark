package omalaev.autopark.dto;

import java.util.List;

public class EnterpriseDTO {
    private int id;
    private String name;
    private String city;
    private List<Integer> vehicles;
    private List<Integer> drivers;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public List<Integer> getVehicles() {
        return vehicles;
    }

    public void setVehicles(List<Integer> vehicles) {
        this.vehicles = vehicles;
    }

    public List<Integer> getDrivers() {
        return drivers;
    }

    public void setDrivers(List<Integer> drivers) {
        this.drivers = drivers;
    }

    public EnterpriseDTO() {
    }
}
