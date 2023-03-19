package com.aj.winz.controllers.v1;

import com.aj.winz.shared.persistence.entities.PlanSponsor;
import com.aj.winz.shared.persistence.entities.RelationshipTreeNode;
import com.aj.winz.shared.persistence.repositories.PlanSponsorRepository;
import com.aj.winz.shared.persistence.repositories.RelationShipTreeNodeRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/sponsors")
public class PlanSponsorController {

    private final PlanSponsorRepository planSponsorRepository;
    private final RelationShipTreeNodeRepository relationShipTreeNodeRepository;
    public PlanSponsorController(PlanSponsorRepository planSponsorRepository,
                                 RelationShipTreeNodeRepository relationShipTreeNodeRepository) {
        this.planSponsorRepository = planSponsorRepository;
        this.relationShipTreeNodeRepository = relationShipTreeNodeRepository;
    }

    @GetMapping
    public ResponseEntity<List<PlanSponsor>> getAllPlanSponsors(@RequestParam(required = false, defaultValue = "1")  int pageNo, @RequestParam(required = false, defaultValue = "10") int pageSize) {
        var page = PageRequest.of(pageNo, pageSize);
        var planSponsors = planSponsorRepository.findAll();
        if (planSponsors.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(planSponsors);
        }
    }

    @GetMapping("relationShipTreeNode")
    public ResponseEntity<List<RelationshipTreeNode>> getAllRelationshipTreeNodes(@RequestParam(required = false, defaultValue = "1")  int pageNo, @RequestParam(required = false, defaultValue = "10") int pageSize) {
        var page = PageRequest.of(pageNo, pageSize);
        var treeNodes = relationShipTreeNodeRepository.findAll();
        if (treeNodes.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(treeNodes);
        }
    }
}
