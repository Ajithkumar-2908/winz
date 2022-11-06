package com.aj.winz.shared.persistence.entities;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Data
public class PlanSponsor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String location;

    @CreationTimestamp
    @Column(updatable = false, nullable = false)
    private Timestamp createdDate;

    @UpdateTimestamp
    @Column(updatable = true, nullable = false)
    private Timestamp updatedDate;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name= "planSponsorId")
    private RelationshipTreeNode relationshipTreeNode;

}
