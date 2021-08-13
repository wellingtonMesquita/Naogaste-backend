package org.com.Naogaste.controller;

import org.com.Naogaste.model.Carteira;
import org.com.Naogaste.service.CarteiraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


@RestController
@Validated
public class CarteiraController {

    @Autowired
    private CarteiraService carteiraService;

    @CrossOrigin
    @GetMapping("/carteiras/max")
    Double findCarteira() { return carteiraService.getCarteira(1);}
    @CrossOrigin
    @PostMapping("/carteiras")
    public Carteira update(@RequestBody Carteira carteira){ return carteiraService.save(carteira,1); }
    @CrossOrigin
    @DeleteMapping("/carteiras/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") long id) { return this.carteiraService.delete(id); }

}
