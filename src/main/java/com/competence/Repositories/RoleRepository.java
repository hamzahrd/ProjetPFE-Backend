package com.competence.Repositories;

import com.competence.Entities.ERole;
import com.competence.Entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
  Role findByName(ERole name);
}
