package omalaev.autopark.services;

import omalaev.autopark.models.Manager;
import omalaev.autopark.repositories.ManagerRepository;
import omalaev.autopark.security.ManagerDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ManagerDetailsService implements UserDetailsService {
    private final ManagerRepository managerRepository;

    @Autowired
    public ManagerDetailsService(ManagerRepository managerRepository) {
        this.managerRepository = managerRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Manager> manager = managerRepository.findByManagerName(username);

        if (manager.isEmpty())
            throw new UsernameNotFoundException("User not found!");

        return new ManagerDetails(manager.get());
    }
}
