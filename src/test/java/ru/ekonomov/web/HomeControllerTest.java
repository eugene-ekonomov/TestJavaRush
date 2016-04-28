package ru.ekonomov.web;

import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.servlet.view.InternalResourceView;
import ru.ekonomov.data.User;
import ru.ekonomov.data.UserRepository;
import ru.ekonomov.web.HomeController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.hamcrest.core.IsCollectionContaining.hasItems;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;


public class HomeControllerTest
{
    @Test
    public void testHomePage() throws Exception
    {
        HomeController homeController = new HomeController();
        MockMvc mockMvc = standaloneSetup(homeController).build();
        mockMvc.perform(get("/")).andExpect(view().name("home"));
    }
    @Test
    public void shouldShowUsers() throws Exception
    {
        List<User> lu = createUserList(20);
        UserRepository mockRepository = mock(UserRepository.class);
        when(mockRepository.findUsers(Long.MAX_VALUE, 20)).thenReturn(lu);

        UserController controller = new UserController(mockRepository);

        MockMvc mockMvc = standaloneSetup(controller).setSingleView(new InternalResourceView("/WEB-INF/views/users.jsp")).build();
        mockMvc.perform(get("/users"))
                .andExpect(view().name("users"))
                .andExpect(model().attributeExists("userList"))
                .andExpect(model().attribute("userList", hasItems(lu.toArray())));
    }
    @Test
    public void shouldShowPagedUsers() throws Exception
    {
        List<User> lu = createUserList(50);
        UserRepository mockRepository = mock(UserRepository.class);
        when(mockRepository.findUsers(23890, 50)).thenReturn(lu);

        UserController controller = new UserController(mockRepository);

        MockMvc mockMvc = standaloneSetup(controller).setSingleView(new InternalResourceView("/WEB-INF/views/users.jsp")).build();
        mockMvc.perform(get("/users?max=23890&count=50"))
                .andExpect(view().name("users"))
                .andExpect(model().attributeExists("userList"))
                .andExpect(model().attribute("userList", hasItems(lu.toArray())));
    }
    private List<User> createUserList(int count)
    {
        List<User> lu = new ArrayList<>();
        for(int i = 0; i < count; i++)
        {
            lu.add(new User("User " + i, new Date()));
        }
        return lu;
    }
}
