package Hardeymorlah.AbbeyFullStackApp.config;
import Hardeymorlah.AbbeyFullStackApp.model.Enum.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    private AbbeyAppFilter bankApplicationFilter;

    @Autowired
    private AuthenticationProvider authenticationProvider;
    @Autowired
    private AbbeyAppFilter abbeyAppFilter;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception{

        httpSecurity.csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers("/api/v1/user/register", "/api/v1/user/login").permitAll()
                        .requestMatchers("/api/v1/user/**").hasAnyAuthority(Role.USER.name())
                        .requestMatchers("/api/v1/account/**").hasAnyAuthority(Role.USER.name())
                        .requestMatchers("/api/v1/relationships/**").hasAnyAuthority(Role.USER.name())
                        .anyRequest().authenticated())
                .sessionManagement(s -> s.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authenticationProvider(authenticationProvider)
                .addFilterBefore(abbeyAppFilter, UsernamePasswordAuthenticationFilter.class)
                .httpBasic(Customizer.withDefaults());

        return httpSecurity.build();

    }

}