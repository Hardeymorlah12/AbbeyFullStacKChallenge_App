package Hardeymorlah.AbbeyFullStackApp.model;

import Hardeymorlah.AbbeyFullStackApp.model.Enum.RelationshipType;
import Hardeymorlah.AbbeyFullStackApp.model.Enum.Role;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
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
        @NotNull
        @ManyToOne
        @JoinColumn(name = "user_id", referencedColumnName = "user_id")
        private User user1;

        @Setter
        @NotNull
        @ManyToOne
        @JoinColumn(name = "related_user_id", referencedColumnName = "user_id")
        private User user2;

        @Setter
        @Enumerated(EnumType.STRING)
        @Column(name = "relationship_type", unique = true)
        private RelationshipType relationshipType;

        @Override
        public String toString() {
                return STR."Relationship{id=\{id}, user1=\{user1}, user2=\{user2}, relationshipType=\{relationshipType}\{'}'}";
        }
}

