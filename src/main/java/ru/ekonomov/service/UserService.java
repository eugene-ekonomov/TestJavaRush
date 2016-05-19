package ru.ekonomov.service;

import org.springframework.beans.support.PagedListHolder;
import ru.ekonomov.data.User;

public interface UserService
{

    public User create(User user);
    public User delete(int id);
    public PagedListHolder<User> pagedList(int page);
    public User update(User user);
    public User findById(int id);

}