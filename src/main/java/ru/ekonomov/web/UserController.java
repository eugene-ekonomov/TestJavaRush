package ru.ekonomov.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ru.ekonomov.data.UserRepository;

@Controller
@RequestMapping("/users")
public class UserController
{

    private UserRepository userRepository;

    @Autowired
    public UserController(UserRepository userRepository)
    {
        this.userRepository = userRepository;
    }
    @RequestMapping(method= RequestMethod.GET)
    public String users(@RequestParam(value="max", defaultValue =  "9223372036854775807") long max,
                        @RequestParam(value="count", defaultValue = "20") int count,
                        Model model)
    {
        model.addAttribute("userList", userRepository.findUsers(max, count));
        return "users";
    }
}
