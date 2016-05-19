package ru.ekonomov.service;

import org.springframework.beans.support.PagedListHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.ekonomov.data.User;
import ru.ekonomov.data.UserRepository;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService
{
    @Resource
    public UserRepository userRepository;

    @Override
    public User create(User user)
    {
        return userRepository.save(user);
    }

    @Override
    public User findById(int id)
    {
        return userRepository.findOne(id);
    }

    @Override
    public User delete(int id)
    {
        User deletedUser = userRepository.findOne(id);
        userRepository.delete(deletedUser);
        return deletedUser;
    }

    @Override
    public PagedListHolder<User> pagedList(int page)
    {
        List<User> userList = userRepository.findAll();
        PagedListHolder<User> pagedUserList = new PagedListHolder<>(userList);
        pagedUserList.setPageSize(10);
        pagedUserList.setPage(page);
        return pagedUserList;

    }

    @Override
    public User update(User user)
    {
        User oldUser = userRepository.getOne(user.getId());
        oldUser.setAge(user.getAge());
        oldUser.setCreatedDate(user.getCreatedDate());
        oldUser.setId(user.getId());
        oldUser.setAdmin(user.isAdmin());
        oldUser.setName(user.getName());
        return oldUser;
    }
}
