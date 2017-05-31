package ru.kpfu.itis.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import ru.kpfu.itis.model.Role;
import ru.kpfu.itis.model.enums.RoleEnumeration;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName(RoleEnumeration name);
}
