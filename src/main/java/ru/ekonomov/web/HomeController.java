package ru.ekonomov.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class HomeController
{
    @RequestMapping(method= RequestMethod.GET)
    public String home()
    {
        return "home";
    }

    @RequestMapping(value= "/nohome", method= RequestMethod.GET)
    public String nohome()
    {
        return "nohome";
    }


}
