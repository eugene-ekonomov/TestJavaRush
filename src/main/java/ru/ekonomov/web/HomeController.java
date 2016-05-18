package ru.ekonomov.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ru.ekonomov.data.User;
import ru.ekonomov.data.UserRepository;
import ru.ekonomov.service.UserService;

import javax.annotation.Resource;

@Controller
public class HomeController
{
    @Resource(name = "userServiceImpl")
    private UserService userService;

    @RequestMapping(value = "/", method= RequestMethod.GET)
    public String home()
    {
        return "home";
    }

    @RequestMapping(value = "/users", method= RequestMethod.GET)
    public String getUsers(@RequestParam(value="max", defaultValue =  "9223372036854775807") long max,
                        @RequestParam(value="count", defaultValue = "20") int count,
                        Model model)
    {
        model.addAttribute("userList", userService.findAll());
        return "userspage";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public String getEdit(@RequestParam(value="id", required=true) Integer id, Model model)
    {
        model.addAttribute("userAttribute", userService.findById(id));
        return "editpage";
    }

    @RequestMapping(value = "edit", method = RequestMethod.POST)
    public String saveEdit(@ModelAttribute("userAttribute") User user,
                           @RequestParam(value="id", required=true) Integer id,
                           Model model)
    {
        // Delegate to PersonService for editing
        userService.update(user);

        // Add id reference to Model
        model.addAttribute("id", id);

        // This will resolve to /WEB-INF/jsp/editedpage.jsp
        return "editedpage";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String getAdd(Model model)
    {
        model.addAttribute("userAttribute", new User());
        return "addpage";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String add(@ModelAttribute("userAttribute") User user)
    {
        userService.create(user);
        return "addedpage";
    }
}
