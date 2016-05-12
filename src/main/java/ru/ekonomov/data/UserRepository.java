package ru.ekonomov.data;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID>
{
}
