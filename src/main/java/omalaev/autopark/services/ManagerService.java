package omalaev.autopark.services;

import omalaev.autopark.models.Manager;
import omalaev.autopark.repositories.ManagerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class ManagerService {
    private final ManagerRepository managerRepository;

    @Autowired
    public ManagerService(ManagerRepository managerRepository) {
        this.managerRepository = managerRepository;
    }

    public Manager finById(int id) {
        Optional<Manager> findManager = managerRepository.findById(id);
        return findManager.orElse(null);
    }
}
