package org.com.Naogaste.service;

import org.com.Naogaste.model.Gasto;
import org.com.Naogaste.repository.GastoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import org.springframework.data.domain.Pageable;
import java.util.List;
import java.util.Optional;

@Component
public class GastoService {

    @Autowired
    private GastoRepository gastos;


    public List<Gasto> findAll() {
        return this.gastos.findAll();
    }

    public Page<Gasto> findByUserId(Long id, Pageable pageRequest){return this.gastos.findByUserId(id,pageRequest);}

    public Gasto save(Gasto gasto){return this.gastos.save(gasto);}

    public Optional<Gasto> update(long id, Gasto gasto){
        return this.gastos.findById(id)
                .map(record -> {
                    record.setNome(gasto.getNome());
                    record.setData(gasto.getData());
                    record.setValor(gasto.getValor());
                    record.setStatus(gasto.getStatus());
                    return this.gastos.save(record);});
    }

    public ResponseEntity<Object> delete(long id){
        return this.gastos.findById(id)
                .map(record -> {
                    this.gastos.deleteById(id);
                    return ResponseEntity.ok().build();
                }).orElse(ResponseEntity.notFound().build());
    }
    public List<Gasto> findLimit(int limit){return this.gastos.findOrderedBySeatDataLimitedTo(limit);};

    public float findGasto(int id){return this.gastos.getGasto(id);}
}
