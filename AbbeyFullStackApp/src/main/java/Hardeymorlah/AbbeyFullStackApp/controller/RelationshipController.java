package Hardeymorlah.AbbeyFullStackApp.controller;

import Hardeymorlah.AbbeyFullStackApp.model.Enum.RelationshipType;
import Hardeymorlah.AbbeyFullStackApp.model.Relationship;
import Hardeymorlah.AbbeyFullStackApp.model.User;
import Hardeymorlah.AbbeyFullStackApp.service.RelationshipService;
import jakarta.validation.Valid;
import lombok.Data;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/relationships")
@Data
public class RelationshipController {
    private final RelationshipService relationshipService;

    public RelationshipController(RelationshipService relationshipService) {
        this.relationshipService = relationshipService;
    }

    @PostMapping("/create_relationship")
    public ResponseEntity<Relationship> createRelationship(@RequestBody Relationship relationship) {
        return relationshipService.createRelationship(relationship);
    }

    @PutMapping("/update_relationship/{id}")
    public ResponseEntity<Relationship> getRelationshipById(@Valid @PathVariable long id, @RequestBody Relationship updatedRelationship) {
        return relationshipService.updateRelationship(id, updatedRelationship);
    }

    @GetMapping("/get_relationship/{relationshipType}")
    public ResponseEntity<List<Relationship>> getRelationships(@PathVariable RelationshipType relationshipType) {
        return relationshipService.getRelationshipByRelationshipType(relationshipType);
    }
    @GetMapping("/get_relationship_by_id/{id}")
    public ResponseEntity<Relationship> getRelationshipById(@PathVariable long id) {
        return relationshipService.getRelationshipById(id);
    }
    @DeleteMapping("/delete_relationship/{id}")
    public ResponseEntity<Relationship> deleteRelationships(@PathVariable long id) {
        return relationshipService.deleteRelationship(id);
        }
    }

