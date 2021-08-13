package org.com.Naogaste;

import org.com.Naogaste.model.Usuario;
import org.com.Naogaste.repository.UsuarioRepository;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class NaogasteApplication {

  @Autowired
  private UsuarioRepository usuarioRepository;

	public static void main(String[] args) {
		SpringApplication.run(NaogasteApplication.class, args);
	}

  @Bean
  InitializingBean sendDatabase() {
    return () -> {
      Usuario usuario =  new Usuario();
      usuario.setNome("Wellington");
      usuario.setSenha("12345678");
      usuario.setAtivo(true);
      usuario.setLogin("wellington123");
    usuarioRepository.save(usuario);
    };
  }
}


