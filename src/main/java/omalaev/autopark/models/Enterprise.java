package omalaev.autopark.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "enterprise")
public class Enterprise {
    @Id
    @Column(name = "enterprise_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int enterpriseId;

    @Column(name = "enterprise_name")
    private String enterpriseName;

    @Column(name = "city")
    private String city;

    @OneToMany(mappedBy = "enterprise")
    private List<Vehicle> vehicleList;

    @OneToMany(mappedBy = "enterprise")
    private List<Driver> driverList;

    @ManyToMany(mappedBy = "enterpriseList")
    private List<Manager> managerList;

    public int getEnterpriseId() {
        return enterpriseId;
    }

    public void setEnterpriseId(int enterpriseId) {
        this.enterpriseId = enterpriseId;
    }

    public String getEnterpriseName() {
        return enterpriseName;
    }

    public void setEnterpriseName(String enterpriseName) {
        this.enterpriseName = enterpriseName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public List<Vehicle> getVehicleList() {
        return vehicleList;
    }

    public void setVehicleList(List<Vehicle> vehicleList) {
        this.vehicleList = vehicleList;
    }

    public List<Driver> getDriverList() {
        return driverList;
    }

    public void setDriverList(List<Driver> driverList) {
        this.driverList = driverList;
    }

    public List<Manager> getManagerList() {
        return managerList;
    }

    public void setManagerList(List<Manager> managerList) {
        this.managerList = managerList;
    }

    public Enterprise() {

    }
}
