package com.aj.winz.shared.persistence.entities;

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

    @OneToOne
    @JoinColumn(name = "id")
    private PlanSponsor planSponsor;

    @ManyToOne
    @JoinColumn(name = "id")
    private Plan plan;

    @ManyToOne
    @JoinColumn(name = "id")
    private Product product;

}
