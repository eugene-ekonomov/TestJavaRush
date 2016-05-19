package ru.ekonomov.web;

import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.servlet.view.InternalResourceView;
import ru.ekonomov.data.User;
import ru.ekonomov.data.UserRepository;
import ru.ekonomov.service.UserService;
import ru.ekonomov.service.UserServiceImpl;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.hasItems;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;


public class HomeControllerTest
{

    @Test
    public void testHomePage() throws Exception
    {
        HomeController homeController = new HomeController();
        MockMvc mockMvc = standaloneSetup(homeController).build();
        mockMvc.perform(get("/")).andExpect(view().name("home"));
    }


    /*@Test
    public void testService() throws Exception {
        List<User> expectedUsers = createUsersList(20);
        UserRepository mockRepository =
                mock(UserRepository.class);
        when(mockRepository.findByName("Vasya1"))
                .thenReturn(expectedUsers);

        UserServiceImpl service = new UserServiceImpl();
        service.userRepository = mockRepository;

        HomeController controller = new HomeController();
        controller.userService = service;

        MockMvc mockMvc = standaloneSetup(controller)
                .setSingleView(
                        new InternalResourceView("/WEB-INF/views/finduserbyid.jsp"))
                .build();
        mockMvc.perform(post("/finduserbyid","id=0"))
                .andExpect(view().name("finduserbyid"))
                .andExpect(model().attributeExists("user"))
                .andExpect(model().attribute("user",
                        hasItems(expectedUsers.toArray())));
    }
    private List<User> createUsersList(int count)
    {
        List<User> users = new ArrayList<User>();
        for (int i=0; i < count; i++)
        {
            User user = new User();
            user.setName("Vasya" + i);
            user.setAge(i);
            users.add(user);
        }
        return users;
    }*/
}
