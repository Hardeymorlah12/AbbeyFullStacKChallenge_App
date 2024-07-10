package Hardeymorlah.AbbeyFullStackApp.service;

import Hardeymorlah.AbbeyFullStackApp.model.Enum.RelationshipType;
import Hardeymorlah.AbbeyFullStackApp.model.Enum.Role;
import Hardeymorlah.AbbeyFullStackApp.model.Relationship;
import Hardeymorlah.AbbeyFullStackApp.model.User;
import Hardeymorlah.AbbeyFullStackApp.repository.RelationshipRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class RelationshipService {
    private final RelationshipRepository relationshipRepository;

    public RelationshipService(RelationshipRepository relationshipRepository) {
        this.relationshipRepository = relationshipRepository;
    }

    public ResponseEntity<Relationship> createRelationship(Relationship relationship) {
        relationship.setUser1(relationship.getUser1());
        relationship.setUser2(relationship.getUser2());
        relationship.setRelationshipType(RelationshipType.FOLLOWER);
       return new ResponseEntity<>(relationshipRepository.save(relationship), HttpStatus.CREATED);
    }
    public ResponseEntity<List<Relationship>> getRelationships(User user, RelationshipType relationshipType) {
        return new ResponseEntity<>(relationshipRepository.findByUser1AndRelationshipType(user, relationshipType), HttpStatus.OK);
    }

    public ResponseEntity<List<Relationship>> getRelatedTo(User user, RelationshipType relationshipType) {
        return new ResponseEntity<>(relationshipRepository.findByUser2AndRelationshipType(user, relationshipType), HttpStatus.OK);
    }
    public ResponseEntity<Relationship> deleteRelationship(User user1, User user2, RelationshipType relationshipType) {
        Relationship relationship = (Relationship) relationshipRepository.findByUser1AndUser2AndRelationshipType(user1, user2 ,relationshipType);
      relationshipRepository.delete(relationship);
      return new ResponseEntity<>(relationship, HttpStatus.ACCEPTED);
    }
}
