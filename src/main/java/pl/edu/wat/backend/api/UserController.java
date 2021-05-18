package pl.edu.wat.backend.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import pl.edu.wat.backend.services.UserService;

@Controller
public class UserController {
    @Autowired
    private UserService userService;
}
