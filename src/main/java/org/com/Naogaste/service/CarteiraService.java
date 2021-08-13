package org.com.Naogaste.service;

import org.com.Naogaste.model.Carteira;
import org.com.Naogaste.repository.CarteiraRepository;
import org.com.Naogaste.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Component

public class CarteiraService {
    @Autowired
    private CarteiraRepository carteiras;

    @Autowired
    private UsuarioRepository usuarioRepository;



    public Double getCarteira(long idUser){
      Carteira carteiraAux = new Carteira();
      carteiraAux.setValor(0.0);
      carteiraAux.setData(new Date());
      carteiraAux.setUser(usuarioRepository.getById(idUser));
      Double carteira = carteiras.findValorByUserId(idUser) == null ? carteiras.save(carteiraAux).getValor() : carteiras.findValorByUserId(idUser);

        return carteira;

    }

      public Carteira save(Carteira carteira,long idUser ){
        Carteira carteiraAux;
        List<Carteira> carteiraList = carteiras.findByUserId(idUser);
        carteiraAux =  carteiraList.get(0);
        carteiraAux.setValor(carteira.getValor());
        carteiraAux.setData(new Date());

        return this.carteiras.save(carteiraAux);

      }

      public Carteira update(long id, Carteira carteira){

               List<Carteira> carteiraAux  = this.carteiras.findByUserId(id);
          if(carteiraAux.size()>0){
              Carteira carteira1 = carteiraAux.get(0);
              carteira1.setValor(carteira.getValor());
              carteira1.setData(carteira.getData());
              return this.carteiras.save(carteira1);
          }else{
              return this.carteiras.save(carteira);
          }
      }

      public ResponseEntity<Object> delete(long id){
          return this.carteiras.findById(id)
                  .map(record -> {
                      this.carteiras.deleteById(id);
                      return ResponseEntity.ok().build();
                  }).orElse(ResponseEntity.notFound().build());
      }

}
