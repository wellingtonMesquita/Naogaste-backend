package org.com.Naogaste.repository;


import org.com.Naogaste.model.Grupo;
import org.com.Naogaste.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GrupoRepository extends JpaRepository<Grupo, Long> {
	
	List<Grupo> findByUsuariosIn(List<Usuario> usuario);

}
