package omalaev.autopark.repositories;

import omalaev.autopark.models.Enterprise;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnterpriseRepository extends JpaRepository<Enterprise, Integer> {
}
