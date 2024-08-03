package com.tri.trispring.controller;

import com.tri.trispring.repository.EntityRepository;
import com.tri.trispring.service.EntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;



@Controller
public class MainController {
    @Autowired
    private EntityRepository entityRepository;
    @Autowired
    private EntityService entityService;

    @GetMapping(value = "/travels")
    public String Index() {
        return "index";
    }


    @PostMapping("/travels")
    public String getEntitiesByTravelNumber(@RequestParam String travelNumber, Model model) {
        model.addAttribute("entities", entityRepository.getDistinctByTravelNumber(travelNumber));
        return "travelRequests";

    }

    @PostMapping("/clipboard")
    public String copyEntityToClipboard(@RequestParam Integer id, Model model) {
        entityService.copyEntityToClipboard(entityRepository.getReferenceById(id));
        model.addAttribute("entity", entityRepository.getReferenceById(id));
        return "copiedTravel";

    }
}
