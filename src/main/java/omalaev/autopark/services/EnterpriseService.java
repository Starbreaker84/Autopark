package omalaev.autopark.services;

import omalaev.autopark.dto.EnterpriseDTO;
import omalaev.autopark.models.Driver;
import omalaev.autopark.models.Enterprise;
import omalaev.autopark.models.Manager;
import omalaev.autopark.models.Vehicle;
import omalaev.autopark.repositories.EnterpriseRepository;
import omalaev.autopark.repositories.ManagerRepository;
import omalaev.autopark.security.ManagerDetails;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
public class EnterpriseService {
    private final EnterpriseRepository enterpriseRepository;
    private final ManagerService managerService;
    private final ModelMapper modelMapper;

    @Autowired
    public EnterpriseService(EnterpriseRepository enterpriseRepository, ManagerService managerService, ModelMapper modelMapper) {
        this.enterpriseRepository = enterpriseRepository;
        this.managerService = managerService;
        this.modelMapper = modelMapper;
    }

    public List<EnterpriseDTO> findAll() {
        return enterpriseRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public List<EnterpriseDTO> findAllByManager(int id) {
        Manager manager = managerService.finById(id);
        return manager.getEnterpriseList().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    private EnterpriseDTO convertToDTO(Enterprise enterprise) {
        EnterpriseDTO convertedEnterprise = modelMapper.map(enterprise, EnterpriseDTO.class);
        List<Integer> drivers = enterprise.getDriverList().stream()
                .map(Driver::getDriverId)
                .collect(Collectors.toList());
        convertedEnterprise.setDrivers(drivers);
        List<Integer> cars = enterprise.getVehicleList().stream()
                .map(Vehicle::getId)
                .collect(Collectors.toList());
        convertedEnterprise.setVehicles(cars);
        return convertedEnterprise;
    }
}
