package org.com.Naogaste.controller;


import org.com.Naogaste.model.Gasto;
import org.com.Naogaste.service.GastoService;
import org.com.Naogaste.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

;

@RestController
@Validated
public class GastoController {

    @Autowired
    private GastoService gastoService;
    @Autowired
    private UsuarioService usuarioService;

    @CrossOrigin
    @GetMapping("/gastos")
    Object findAll( @RequestParam(value = "pag", defaultValue = "0") int pag, @RequestParam(value = "size", defaultValue = "10") int size) {
      Pageable pageable =  PageRequest.of((pag),size);
        return gastoService.findByUserId(1L,pageable);
    }
    @CrossOrigin
    @GetMapping("/gasto")
    Object find() { return gastoService.findGasto(1); }
    @CrossOrigin
    @GetMapping("/gastos/limit")
    Object findGastoLimit() {
        return gastoService.findLimit(10);
    }
    @CrossOrigin
    @PostMapping("/gastos")
    public Gasto create(@RequestBody Gasto gasto){
      gasto.setUser(this.usuarioService.getById(1));
        return gastoService.save(gasto);
    }
    @CrossOrigin
    @PutMapping("/gastos/{id}")
    public Gasto update(@PathVariable("id") long id, @RequestBody Gasto gasto){ return gastoService.save(gasto); }
    @CrossOrigin
    @DeleteMapping("/gastos/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") long id) { return this.gastoService.delete(id); }




}
