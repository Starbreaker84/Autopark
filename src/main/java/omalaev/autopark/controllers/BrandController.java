package omalaev.autopark.controllers;

import omalaev.autopark.models.Brand;
import omalaev.autopark.services.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/brands")
public class BrandController {
    private final BrandService brandService;

    @Autowired
    public BrandController(BrandService brandService) {
        this.brandService = brandService;
    }

    @GetMapping()
    public String getBrands(Model page) {
        page.addAttribute("brands", brandService.findAll());
        return "brands/index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        model.addAttribute("brand", brandService.findOne(id));
        return "brands/show";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) {
        brandService.delete(id);
        return "redirect:/vehicles";
    }

    @GetMapping("/new")
    public String newVehicle(@ModelAttribute("brand") Brand brand) {
        return "brands/new";
    }

    @PostMapping()
    public String create(@ModelAttribute("brand") Brand brand) {
        brandService.save(brand);
        return "redirect:/brands";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model page, @PathVariable("id") int id) {
        page.addAttribute("brand", brandService.findOne(id));
        return "brands/edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("brand") Brand brand,
                         @PathVariable("id") int id) {
        brandService.update(id, brand);
        return "redirect:/brands";
    }

}
