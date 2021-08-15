package org.com.Naogaste;

import org.com.Naogaste.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class NaogasteApplication {

  @Autowired
  private UsuarioRepository usuarioRepository;

	public static void main(String[] args) {
		SpringApplication.run(NaogasteApplication.class, args);
	}


}


