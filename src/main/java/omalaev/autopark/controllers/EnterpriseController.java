package omalaev.autopark.controllers;

import omalaev.autopark.dto.EnterpriseDTO;
import omalaev.autopark.models.Manager;
import omalaev.autopark.security.ManagerDetails;
import omalaev.autopark.services.EnterpriseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/enterprise")
public class EnterpriseController {
    private final EnterpriseService enterpriseService;

    @Autowired
    public EnterpriseController(EnterpriseService enterpriseService) {
        this.enterpriseService = enterpriseService;
    }

    @ResponseBody
    @GetMapping("/list")
    public List<EnterpriseDTO> getEnterprises(@AuthenticationPrincipal ManagerDetails managerDetails) {
        return enterpriseService.findAllByManager(managerDetails.getManager().getManagerId());
    }
}
