package ru.inedtest.dbtools.repositories;

import org.springframework.data.repository.CrudRepository;
import ru.inedtest.dbtools.domains.user.Role;

public interface RoleRepo extends CrudRepository<Role, Long> {
}
