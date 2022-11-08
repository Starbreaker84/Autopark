package mycompany.autopark.controllers;

import mycompany.autopark.services.VehiclesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class VehiclesController {

    private final VehiclesService vehiclesService;

    @Autowired
    public VehiclesController(VehiclesService vehiclesService) {
        this.vehiclesService = vehiclesService;
    }

    @GetMapping()
    public String index(Model page) {
        page.addAttribute("vehicles", vehiclesService.findAll());
        return "index";
    }
}
