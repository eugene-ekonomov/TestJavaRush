package ru.ekonomov.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.ekonomov.data.User;
import ru.ekonomov.data.UserRepository;
import ru.ekonomov.service.UserService;

import javax.annotation.Resource;
import java.util.List;
import java.util.logging.Logger;

@Controller
public class HomeController
{
    @Resource(name = "userServiceImpl")
    public UserService userService;

    @RequestMapping(value = "/", method= RequestMethod.GET)
    public String home()
    {
        return "home";
    }

    @RequestMapping(value = "/users/{page}", method= RequestMethod.GET)
    public String getUsers( @PathVariable("page") int page, Model model)
    {
        model.addAttribute("userList", userService.pagedList(page-1));
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
        userService.update(user);
        model.addAttribute("id", id);
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

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String delete(@RequestParam(value="id", required=true) Integer id, Model model)
    {
        userService.delete(id);
        model.addAttribute("id", id);
        return "deletedpage";
    }

    @RequestMapping(value = "/finduserbyid", method = RequestMethod.GET)
    public String findUserById(@RequestParam(value="id", required=true) Integer id, Model model)
    {
        User user = userService.findById(id);
        if(user!=null)
        {
            model.addAttribute("user", user);
        }
        return "finduserbyid";

    }
}
