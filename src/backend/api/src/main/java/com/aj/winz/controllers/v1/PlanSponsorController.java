package com.aj.winz.controllers.v1;

import com.aj.winz.shared.persistence.entities.PlanSponsor;
import com.aj.winz.shared.persistence.repositories.PlanSponsorRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/sponsors")
public class PlanSponsorController {

    private final PlanSponsorRepository planSponsorRepository;
    public PlanSponsorController(PlanSponsorRepository planSponsorRepository) {
        this.planSponsorRepository = planSponsorRepository;
    }

    @GetMapping
    public ResponseEntity<Page<PlanSponsor>> getAllPlanSponsors(@RequestParam(required = false, defaultValue = "1")  int pageNo, @RequestParam(required = false, defaultValue = "10") int pageSize) {
        var page = PageRequest.of(pageNo, pageSize);
        var planSponsors = planSponsorRepository.findAll(page);
        if (planSponsors.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(planSponsors);
        }
    }
}
