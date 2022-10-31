package omalaev.autopark.services;

import omalaev.autopark.models.Vehicle;

import omalaev.autopark.repositories.VehiclesRepository;
import omalaev.autopark.utils.VehicleNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

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

    public Vehicle findOne(int id) {
        Optional<Vehicle> findVehicle = vehiclesRepository.findById(id);
        return findVehicle.orElseThrow(VehicleNotFoundException::new);
    }

    @Transactional
    public void delete(int id) {
        vehiclesRepository.deleteById(id);
    }

    @Transactional
    public void save(Vehicle vehicle) {
        vehiclesRepository.save(vehicle);
    }

    @Transactional
    public void update(int id, Vehicle updatedVehicle) {
        updatedVehicle.setId(id);
        vehiclesRepository.save(updatedVehicle);
    }


}
