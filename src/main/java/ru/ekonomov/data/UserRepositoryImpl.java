package ru.ekonomov.data;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class UserRepositoryImpl implements UserRepository
{
    List<User> lu;

    public UserRepositoryImpl() {
        lu = new ArrayList<>();
        lu.add(new User(25, new Date(), 1, true, "Ivanov"));
        lu.add(new User(35, new Date(), 2, false, "Ivanchenko"));
        lu.add(new User(21, new Date(), 3, false, "Petrov"));
        lu.add(new User(27, new Date(), 4, true, "Petrenko"));
        lu.add(new User(22, new Date(), 5, true, "Sidorov"));
        lu.add(new User(45, new Date(), 6, false, "Sidorenko"));
        lu.add(new User(15, new Date(), 7, true, "Kocheryzhkin"));
        lu.add(new User(65, new Date(), 8, true, "Mannsky"));
        lu.add(new User(32, new Date(), 9, false, "Shvili"));
        lu.add(new User(12, new Date(), 10, true, "Vili"));
    }

    @Override
    public List<User> findUsers(long max, int count) {
        return lu;
    }
}
