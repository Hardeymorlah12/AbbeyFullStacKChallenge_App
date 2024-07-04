package Hardeymorlah.AbbeyFullStackApp.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
@Entity
@Table(name = "user_table")
@Getter
@AllArgsConstructor
@NoArgsConstructor

public class User {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "user_id")
        private Long id;
        @Setter
        @NotBlank(message = "Name is mandatory")
        @Null
        @Size(min = 2, max = 100, message = "Name must be more than 2, and less than 100 characters")
        @Column(name = "name")

        private String name;
        @NotNull
        @NotBlank(message = "Email or Username is mandatory")
        @Pattern(regexp = "[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}")
        @Email
        @Column (name = "email", unique = true)
        @Setter
        private String username;
        @NotNull
        @NotBlank(message = "Password must contain a minimum of 8 and a maximum of 13 characters")
        @Size(min = 8, max = 13, message = "Password must contain a minimum of 8 and a maximum of 13 characters")
        @Pattern(regexp ="(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,13}",
                message = "Password must contain at least one lowercase, one uppercase, one digit, one special character, and be between 8 and 13 characters long")
        @Column(name = "password")
        @Setter
        private String password;

        @OneToOne(mappedBy = "user")
        private Account account;


        @Override
        public String toString() {
                return STR."User{id=\{id}, name='\{name}\{'\''}, username='\{username}\{'\''}, password='\{password}\{'\''}, account=\{account}\{'}'}";
        }
}

