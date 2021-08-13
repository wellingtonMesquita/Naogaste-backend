package org.com.Naogaste.repository;

import org.com.Naogaste.model.Gasto;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import org.springframework.data.domain.Pageable;
import java.util.List;

public interface GastoRepository extends JpaRepository<Gasto, Long> {
    Page<Gasto> findByUserId(@Param("user_id") Long user_id, Pageable pageable);

    float  getGasto(int id);

    List<Gasto>findOrderedBySeatDataLimitedTo(int limit);


}
