package Hardeymorlah.AbbeyFullStackApp.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "account_table")
@Getter

@AllArgsConstructor
@NoArgsConstructor

public class Account {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "account_id")
        private Long id;
        @Setter
        @NotNull
        @Column(name = "profile_picture")
        private String profilePicture;

        @Setter
        @NotNull
        @Column(name = "bio")
        private String bio;

        @Setter
        @NotNull
        @Column(name = "location")
        private String location;

        @Setter
        @NotNull
        @Column(name = "interests")
        private String interests;

        @Setter
        @Column(name = "account_type")
        private String accountType;

        @Setter
        @Column(name = "account_balance")
        private Double accountBalance;

        @Setter
        @OneToOne(mappedBy = "account")
        private User user;


    @Override
    public String toString() {
        return STR."Account{id=\{id}, profilePicture='\{profilePicture}\{'\''}, bio='\{bio}\{'\''}, location='\{location}\{'\''}, interests='\{interests}\{'\''}, accountType='\{accountType}\{'\''}, accountBalance=\{accountBalance}, user=\{user}\{'}'}";
    }
}
