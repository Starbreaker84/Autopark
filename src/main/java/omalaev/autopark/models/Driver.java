package omalaev.autopark.models;

import javax.persistence.*;

@Entity
@Table (name = "driver")
public class Driver {
    @Id
    @Column(name = "driver_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int driverId;

    @Column(name = "driver_name")
    private String driverName;

    @Column(name = "salary")
    private int salary;

    @ManyToOne
    @JoinColumn(name = "enterprise", referencedColumnName = "enterprise_id")
    private Enterprise enterprise;

    @ManyToOne
    @JoinColumn(name = "vehicle", referencedColumnName = "id")
    private Vehicle vehicle;

    @Column(name = "is_active")
    private boolean isActive;

    public int getDriverId() {
        return driverId;
    }

    public void setDriverId(int driverId) {
        this.driverId = driverId;
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public Enterprise getEnterprise() {
        return enterprise;
    }

    public void setEnterprise(Enterprise enterprise) {
        this.enterprise = enterprise;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public Driver() {
    }
}
