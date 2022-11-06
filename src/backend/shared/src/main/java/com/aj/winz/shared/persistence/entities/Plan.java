package com.aj.winz.shared.persistence.entities;

import com.aj.winz.shared.enums.TaxType;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Data
public class Plan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Enumerated(EnumType.STRING)
    private TaxType taxType;

    @CreationTimestamp
    @Column(updatable = false, nullable = false)
    private Timestamp createdDate;

    @UpdateTimestamp
    @Column(updatable = true, nullable = false)
    private Timestamp updatedDate;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name= "planId")
    private List<RelationshipTreeNode> relationshipTreeNodeList;


}
