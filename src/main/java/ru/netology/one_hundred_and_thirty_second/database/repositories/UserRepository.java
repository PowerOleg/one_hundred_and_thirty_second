package ru.netology.one_hundred_and_thirty_second.database.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.netology.one_hundred_and_thirty_second.models.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
