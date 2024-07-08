package Hardeymorlah.AbbeyFullStackApp.model;

import Hardeymorlah.AbbeyFullStackApp.model.Enum.Role;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "user_table")
@Getter
@AllArgsConstructor
@NoArgsConstructor

public class User implements UserDetails {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "user_id")
        private Long id;
        @NotNull
        @NotBlank(message = "Email or Username is mandatory")
        @Pattern(regexp = "[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}")
        @Email
        @Column (name = "email", unique = true)
        @Setter
        private String username;
        @NotNull
        @NotBlank(message = "Password must contain a minimum of 8 and a maximum of 13 characters")
//        @Size(min = 8, max = 13, message = "Password must contain a minimum of 8 and a maximum of 13 characters")
        @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@#$!%+=^*?&]).{8,}$")
        @Column(name = "password")
        @Setter
        private String password;
        @Setter
        @Enumerated(EnumType.STRING)
        private Role role;

        @Override
        public String toString() {
                return STR."User{id=\{id}, username='\{username}\{'\''}, password='\{password}\{'\''}, role=\{role}\{'}'}";
        }

        @Override
        public Collection<? extends GrantedAuthority> getAuthorities() {
                return List.of(new SimpleGrantedAuthority(this.role.name()));
        }

        @Override
        public boolean isAccountNonExpired() {
                return UserDetails.super.isAccountNonExpired();
        }

        @Override
        public boolean isAccountNonLocked() {
                return UserDetails.super.isAccountNonLocked();
        }

        @Override
        public boolean isCredentialsNonExpired() {
                return UserDetails.super.isCredentialsNonExpired();
        }

        @Override
        public boolean isEnabled() {
                return UserDetails.super.isEnabled();
        }
}

