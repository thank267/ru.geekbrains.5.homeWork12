package ru.geekbrains.homework12.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.geekbrains.homework12.entities.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
}
