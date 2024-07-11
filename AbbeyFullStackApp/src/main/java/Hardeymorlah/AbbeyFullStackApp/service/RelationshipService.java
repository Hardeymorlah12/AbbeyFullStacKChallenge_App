package Hardeymorlah.AbbeyFullStackApp.service;

import Hardeymorlah.AbbeyFullStackApp.model.Enum.RelationshipType;
import Hardeymorlah.AbbeyFullStackApp.model.Relationship;
import Hardeymorlah.AbbeyFullStackApp.model.User;
import Hardeymorlah.AbbeyFullStackApp.repository.RelationshipRepository;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Data
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

    public ResponseEntity<Relationship> updateRelationship(long id, Relationship updatedRelationship) {
        Relationship existingRelationship = relationshipRepository.findRelationById(id);
        existingRelationship.setUser1(updatedRelationship.getUser1());
        existingRelationship.setUser2(updatedRelationship.getUser2());
        existingRelationship.setRelationshipType(updatedRelationship.getRelationshipType());
        return new ResponseEntity<>(relationshipRepository.save(existingRelationship), HttpStatus.ACCEPTED);
    }

    public ResponseEntity<List<Relationship>> getRelationshipByUserAndRelationshipType(User user, RelationshipType relationshipType) {
        return new ResponseEntity<>(relationshipRepository.findByUserAndRelationshipType(user, relationshipType), HttpStatus.OK);
    }
    public ResponseEntity<Relationship> getRelationshipById(long id) {
        return new ResponseEntity<>(relationshipRepository.findRelationById(id), HttpStatus.OK);
    }
    public ResponseEntity<Relationship> deleteRelationship(long id) {
        Relationship deletedRelationship = relationshipRepository.findRelationById(id);
        relationshipRepository.deleteById(id);
        return new ResponseEntity<>(deletedRelationship, HttpStatus.OK);
    }

}
