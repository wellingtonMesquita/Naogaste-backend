package org.com.Naogaste.repository;


import org.com.Naogaste.model.Carteira;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CarteiraRepository  extends JpaRepository<Carteira, Long> {

    @Query("select c.valor from Carteira c inner join c.user u where u.id = :id")
    Double findValorByUserId(@Param("id") Long id);

    @Query("select c from Carteira c inner join c.user u where u.id = :id")
    List<Carteira> findByUserId(@Param("id") Long id);
}
