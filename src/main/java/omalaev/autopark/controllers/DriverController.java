package omalaev.autopark.controllers;

import omalaev.autopark.dto.DriverDTO;
import omalaev.autopark.models.Driver;
import omalaev.autopark.services.DriverService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/driver")
public class DriverController {
    private final DriverService driverService;
    private final ModelMapper modelMapper;

    public DriverController(DriverService driverService, ModelMapper modelMapper) {
        this.driverService = driverService;
        this.modelMapper = modelMapper;
    }

    @ResponseBody
    @GetMapping("/list")
    public List<DriverDTO> getDrivers() {
        return driverService.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    private DriverDTO convertToDTO(Driver driver) {
        DriverDTO convertedDriver = modelMapper.map(driver, DriverDTO.class);
        if (driver.getEnterprise() != null) {
            convertedDriver.setEnterpriseId(driver.getEnterprise().getEnterpriseId());
        } else {
            convertedDriver.setEnterpriseId(null);
        }

        if (driver.getVehicle() != null) {
            convertedDriver.setVehicleId(driver.getVehicle().getId());
        } else {
            convertedDriver.setVehicleId(null);
        }

        return convertedDriver;
    }
}
