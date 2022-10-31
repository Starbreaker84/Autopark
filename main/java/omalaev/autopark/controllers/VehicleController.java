package omalaev.autopark.controllers;

import omalaev.autopark.models.Vehicle;
import omalaev.autopark.services.BrandService;
import omalaev.autopark.services.VehiclesService;
import omalaev.autopark.utils.VehicleErrorResponse;
import omalaev.autopark.utils.VehicleNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @ResponseBody
    @GetMapping("/list")
    public List<Vehicle> getVehicles() {
        return vehiclesService.findAll();
    }

    @ResponseBody
    @GetMapping("/list/{id}")
    public Vehicle getVehicles(@PathVariable("id") int id) {
        return vehiclesService.findOne(id);
    }

    @ExceptionHandler
    private ResponseEntity <VehicleErrorResponse> handlerException(VehicleNotFoundException e) {
        VehicleErrorResponse response = new VehicleErrorResponse(
                "Vehicle with this ID not found!"
        );
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
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

    @GetMapping("/{id}/edit")
    public String edit(Model page, @PathVariable("id") int id) {
        page.addAttribute("vehicle", vehiclesService.findOne(id));
        page.addAttribute("brands", brandService.findAll());
        return "vehicles/edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("vehicle") Vehicle vehicle,
                         @PathVariable("id") int id) {
        vehiclesService.update(id, vehicle);
        return "redirect:/vehicles";
    }
}
