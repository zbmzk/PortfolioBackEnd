package com.portfoliorep.backend.Security.Repository;

import com.portfoliorep.backend.Security.Entity.Rol;
import com.portfoliorep.backend.Security.Enums.RolNombre;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRolRepository extends JpaRepository<Rol, Integer>{
    Optional<Rol> findByRolNombre(RolNombre rolNombre);
}
