package org.com.Naogaste.repository;


import org.com.Naogaste.model.Grupo;
import org.com.Naogaste.model.Permissao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PermissaoRepository extends JpaRepository<Permissao, Long> {
	
	List<Permissao> findByGruposIn(List<Grupo> grupo);

}
