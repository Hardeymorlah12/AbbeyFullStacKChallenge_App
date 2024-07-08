package Hardeymorlah.AbbeyFullStackApp.model;

import Hardeymorlah.AbbeyFullStackApp.model.Enum.AccountType;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import java.util.Arrays;

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
//        @NotNull
        @Lob
        private byte[] profilePicture;
        @Setter
        @NotNull
        @Column(name = "bio")
        private String bio;
        @Setter
        @NotNull
        @Column(name = "location")
        private String location;

        @Setter
        @NotBlank(message = "Name is mandatory")
        @NotNull
        @Size(min = 2, max = 100, message = "Name must be more than 2, and less than 100 characters")
        @Column(name = "name")
        private String name;

        @Setter
        @NotNull
        @Column(name = "interests")
        private String interests;

        @Setter
        @Enumerated(EnumType.STRING)
        private AccountType accountType;

        @OneToOne
        @Setter
        @JoinColumn(name = "user_id")
        private User user;
        @Setter
        @NotNull
        @Column(name = "date_of_birth")
        private  String dob;

        @Override
        public String toString() {
                return STR."Account{id=\{id}, profilePicture=\{Arrays.toString(profilePicture)}, bio='\{bio}\{'\''}, location='\{location}\{'\''}, name='\{name}\{'\''}, interests='\{interests}\{'\''}, accountType=\{accountType}, user=\{user}, dob='\{dob}\{'\''}\{'}'}";
        }
}
