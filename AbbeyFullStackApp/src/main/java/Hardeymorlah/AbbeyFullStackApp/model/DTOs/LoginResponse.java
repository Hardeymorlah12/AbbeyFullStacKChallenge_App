package Hardeymorlah.AbbeyFullStackApp.model.DTOs;

import Hardeymorlah.AbbeyFullStackApp.model.User;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LoginResponse {

    private User user;
    private String token;

}
