package Hardeymorlah.AbbeyFullStackApp.model;

import Hardeymorlah.AbbeyFullStackApp.model.Enum.RelationshipType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "relationships")
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Relationship {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "relationship_id")
        private Long id;

        @Setter
        @ManyToOne
        @JoinColumn(name = "user_id", referencedColumnName = "user_id")
        private User user1;

        @Setter
        @ManyToOne
        @JoinColumn(name = "related_user_id", referencedColumnName = "user_id")
        private User user2;

        @Setter
        @Enumerated(EnumType.STRING)
        @Column(name = "relationship_type")
        private RelationshipType relationshipType;

        @Override
        public String toString() {
                return STR."Relationship{id=\{id}, follower=\{user1}, following=\{user2}, relationshipType=\{relationshipType}\{'}'}";
        }
}
