 package com.entrenamientospring.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;
import com.entrenamientospring.models.Usuario;

public interface UsuarioInterface extends JpaRepository<Usuario, Integer> {

}
