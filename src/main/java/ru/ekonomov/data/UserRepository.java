package ru.ekonomov.data;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface UserRepository extends JpaRepository<User, Integer>
{
    List<User> findByName(String name);
}
