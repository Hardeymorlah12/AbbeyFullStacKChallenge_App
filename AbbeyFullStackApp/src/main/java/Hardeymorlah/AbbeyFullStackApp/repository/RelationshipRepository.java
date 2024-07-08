package Hardeymorlah.AbbeyFullStackApp.repository;

import Hardeymorlah.AbbeyFullStackApp.model.Enum.RelationshipType;
import Hardeymorlah.AbbeyFullStackApp.model.Relationship;
import Hardeymorlah.AbbeyFullStackApp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RelationshipRepository extends JpaRepository<Relationship, Long> {
    List<Relationship> findByUser1AndRelationshipType(User user1, RelationshipType relationshipType);
    List<Relationship> findByUser2AndRelationshipType(User user2, RelationshipType relationshipType);
    List<Relationship> findByUser1AndUser2AndRelationshipType(User user1, User user2,RelationshipType relationshipType);

}
