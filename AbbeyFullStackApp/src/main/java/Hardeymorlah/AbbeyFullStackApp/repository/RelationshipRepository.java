package Hardeymorlah.AbbeyFullStackApp.repository;

import Hardeymorlah.AbbeyFullStackApp.model.Enum.RelationshipType;
import Hardeymorlah.AbbeyFullStackApp.model.Relationship;
import Hardeymorlah.AbbeyFullStackApp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RelationshipRepository extends JpaRepository<Relationship, Long> {
    List<Relationship> findByUser(User user);
    List<Relationship> findByRelatedUser(User relatedUser);
    List<Relationship> findByRelationshipType(RelationshipType relationshipType);
    List<Relationship> findByUserAndRelationshipType(User user, RelationshipType relationshipType);

}
