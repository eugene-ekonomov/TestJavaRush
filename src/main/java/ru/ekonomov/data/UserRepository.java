package ru.ekonomov.data;
import java.util.List;

public interface UserRepository
{
    List<User> findUsers(long max, int count);
}
