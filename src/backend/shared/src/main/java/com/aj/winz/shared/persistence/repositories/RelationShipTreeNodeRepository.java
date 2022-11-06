package com.aj.winz.shared.persistence.repositories;

import com.aj.winz.shared.persistence.entities.RelationshipTreeNode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface RelationShipTreeNodeRepository extends JpaRepository<RelationshipTreeNode, UUID> {
}
