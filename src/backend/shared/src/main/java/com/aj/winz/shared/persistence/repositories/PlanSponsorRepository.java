package com.aj.winz.shared.persistence.repositories;

import com.aj.winz.shared.persistence.entities.PlanSponsor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlanSponsorRepository extends JpaRepository<PlanSponsor, Long> {
}
