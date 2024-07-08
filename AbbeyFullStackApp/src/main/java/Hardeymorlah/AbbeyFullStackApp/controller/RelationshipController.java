package Hardeymorlah.AbbeyFullStackApp.controller;

import Hardeymorlah.AbbeyFullStackApp.model.Enum.RelationshipType;
import Hardeymorlah.AbbeyFullStackApp.model.Relationship;
import Hardeymorlah.AbbeyFullStackApp.model.User;
import Hardeymorlah.AbbeyFullStackApp.service.RelationshipService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/relationships")
public class RelationshipController {
    private final RelationshipService relationshipService;

    public RelationshipController(RelationshipService relationshipService) {
        this.relationshipService = relationshipService;
    }
    @PostMapping("/create_relationship")
    public ResponseEntity<Relationship> createRelationship(@RequestBody Relationship relationship) {
        return relationshipService.createRelationship(relationship);
    }
    @GetMapping("/get_relationships/{user}/{relationshipType}")
    public ResponseEntity<List<Relationship>> getRelationships(@PathVariable User user, RelationshipType relationshipType) {
        return relationshipService.getRelationships(user,relationshipType);
    }
    @GetMapping("/get_relationship/{user}/{relationshipType}")
    public ResponseEntity<List<Relationship>> getRelatedTo(@PathVariable User user, RelationshipType relationshipType) {
        return relationshipService.getRelatedTo(user, relationshipType);
    }
@GetMapping("/delete_relationship/{user1}/{user2}/{relationshipType}")
    public ResponseEntity<Relationship> deleteRelationships(@PathVariable User user1, User user2, RelationshipType relationshipType) {
        return relationshipService.deleteRelationship(user1,user2, relationshipType);
        }
    }

