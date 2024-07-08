package Hardeymorlah.AbbeyFullStackApp.controller;


import Hardeymorlah.AbbeyFullStackApp.model.User;
import Hardeymorlah.AbbeyFullStackApp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ThymeleafController {
    @Autowired
    private UserService userService;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/register")
    public ModelAndView showRegistrationForm() {
        return new ModelAndView("register");
    }

    @PostMapping("/register")
    public ModelAndView registerUser(
            @RequestParam("username") String username,
            @RequestParam("password") String password
    ) {
        User user = new User();
        user.setUsername(username);
        user.setPassword(passwordEncoder.encode(password)); // Make sure to hash the password in the service layer
        userService.createNewUser(user);

        return new ModelAndView("redirect:/login");
    }

}
