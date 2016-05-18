package ru.ekonomov.service;

import org.springframework.stereotype.Service;
import ru.ekonomov.data.User;
import ru.ekonomov.data.UserRepository;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService
{
    @Resource
    UserRepository userRepository;

    @Override
    @Transactional
    public User create(User user)
    {
        return userRepository.save(user);
    }

    @Override
    @Transactional
    public User findById(int id)
    {
        return userRepository.findOne(id);
    }

    @Override
    @Transactional
    public User delete(int id)
    {
        User deletedUser = userRepository.findOne(id);
        userRepository.delete(deletedUser);
        return deletedUser;
    }

    @Override
    @Transactional
    public List<User> findAll()
    {
        return userRepository.findAll();
    }

    @Override
    @Transactional
    public User update(User user)
    {
        User oldUser = userRepository.getOne(user.getId());
        oldUser.setAge(user.getAge());
        oldUser.setCreatedDate(user.getCreatedDate());
        oldUser.setId(user.getId());
        oldUser.setIsAdmin(user.isAdmin());
        oldUser.setName(user.getName());
        return oldUser;
    }

    @Override
    @Transactional
    public List<User> search(String s)
    {
        return userRepository.findByName(s);
    }
}
