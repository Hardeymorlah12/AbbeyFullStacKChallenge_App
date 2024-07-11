package Hardeymorlah.AbbeyFullStackApp.repository;

import Hardeymorlah.AbbeyFullStackApp.model.Enum.RelationshipType;
import Hardeymorlah.AbbeyFullStackApp.model.Relationship;
import Hardeymorlah.AbbeyFullStackApp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RelationshipRepository extends JpaRepository<Relationship, Long> {
    Relationship findRelationById(long id);
    List<Relationship> findByUserAndRelationshipType(User user, RelationshipType relationshipType);
}
