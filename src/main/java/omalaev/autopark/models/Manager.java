package omalaev.autopark.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "manager")
public class Manager {
    @Id
    @Column(name = "manager_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int managerId;

    @Column(name = "manager_name")
    private String managerName;

    @Column(name = "manager_password")
    private String managerPassword;

    @ManyToMany
    @JoinTable(
            name = "manager_enterprise",
            joinColumns = @JoinColumn(name = "manager_id"),
            inverseJoinColumns = @JoinColumn(name = "enterprise_id"))
    private List<Enterprise> enterpriseList;

    public int getManagerId() {
        return managerId;
    }

    public void setManagerId(int managerId) {
        this.managerId = managerId;
    }

    public String getManagerName() {
        return managerName;
    }

    public void setManagerName(String managerName) {
        this.managerName = managerName;
    }

    public String getManagerPassword() {
        return managerPassword;
    }

    public void setManagerPassword(String managerPassword) {
        this.managerPassword = managerPassword;
    }

    public List<Enterprise> getEnterpriseList() {
        return enterpriseList;
    }

    public void setEnterpriseList(List<Enterprise> enterpriseList) {
        this.enterpriseList = enterpriseList;
    }

    public Manager() {
    }
}
