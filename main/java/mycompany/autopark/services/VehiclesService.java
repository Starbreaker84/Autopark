package mycompany.autopark.services;

import mycompany.autopark.models.Vehicle;
import mycompany.autopark.repositories.VehiclesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class VehiclesService {
    private final VehiclesRepository vehiclesRepository;

    @Autowired
    public VehiclesService(VehiclesRepository vehiclesRepository) {
        this.vehiclesRepository = vehiclesRepository;
    }

    public List<Vehicle> findAll() {
        return vehiclesRepository.findAll();
    }


}
