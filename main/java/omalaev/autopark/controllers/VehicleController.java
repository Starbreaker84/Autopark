package omalaev.autopark.controllers;

import omalaev.autopark.models.Vehicle;
import omalaev.autopark.services.BrandService;
import omalaev.autopark.services.VehiclesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/vehicles")
public class VehicleController {

    private final VehiclesService vehiclesService;
    private final BrandService brandService;

    @Autowired
    public VehicleController(VehiclesService vehiclesService, BrandService brandService) {
        this.vehiclesService = vehiclesService;
        this.brandService = brandService;
    }

    @GetMapping()
    public String index(Model page) {
        page.addAttribute("vehicles", vehiclesService.findAll());
        return "vehicles/index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        model.addAttribute("vehicle", vehiclesService.findOne(id));
        return "vehicles/show";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) {
        vehiclesService.delete(id);
        return "redirect:/vehicles";
    }

    @GetMapping("/new")
    public String newVehicle(@ModelAttribute("vehicle") Vehicle vehicle,
                             Model page) {
        page.addAttribute("brands", brandService.findAll());
        return "vehicles/new";
    }

    @PostMapping()
    public String create(@ModelAttribute("vehicle") Vehicle vehicle) {
        vehiclesService.save(vehicle);
        return "redirect:/vehicles";
    }
}
