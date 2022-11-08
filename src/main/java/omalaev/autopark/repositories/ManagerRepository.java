package omalaev.autopark.repositories;

import omalaev.autopark.models.Manager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ManagerRepository extends JpaRepository <Manager, Integer> {
    Optional<Manager> findByManagerName(String managerName);
}
