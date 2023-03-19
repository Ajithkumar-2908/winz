package com.aj.winz.shared.persistence.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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

    @OneToOne(mappedBy = "planSponsor", fetch = FetchType.LAZY)
    @JsonManagedReference
    @JsonIgnore
    private RelationshipTreeNode relationshipTreeNode;

}
