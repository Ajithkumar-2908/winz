package com.aj.winz.shared.persistence.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.UUID;

@Entity
@Data
public class RelationshipTreeNode {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private String hierarchyId;

    @Column(insertable = false, updatable = false)
    private int level;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "planSponsorId")
    @JsonBackReference
    private PlanSponsor planSponsor;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "planId")
    @JsonBackReference
    private Plan plan;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonBackReference
    @JoinColumn(name = "productId")
    private Product product;

}
