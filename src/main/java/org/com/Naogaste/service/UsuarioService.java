package org.com.Naogaste.service;

import org.com.Naogaste.config.ConfirmationToken;
import org.com.Naogaste.model.Usuario;
import org.com.Naogaste.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.text.MessageFormat;
import java.util.Optional;

@Component
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;
    private ConfirmationTokenService confirmationTokenService;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public Usuario loadUserByUsername(String login) throws UsernameNotFoundException {

        final Optional<Usuario> optionalUser = Optional.ofNullable(usuarioRepository.findByLogin(login));

        if (optionalUser.isPresent()) {
            return optionalUser.get();
        } else {
            throw new UsernameNotFoundException(MessageFormat.format("User with email {0} cannot be found.", login));
        }
    }

    public Usuario getById(long id){
      return this.usuarioRepository.getById(id);
    }
    void signUpUser(Usuario usuario) {

        final String encryptedPassword = bCryptPasswordEncoder.encode(usuario.getSenha());

        usuario.setSenha(encryptedPassword);

        final Usuario createdUser = usuarioRepository.save(usuario);

        final ConfirmationToken confirmationToken = new ConfirmationToken(usuario);

        confirmationTokenService.saveConfirmationToken(confirmationToken);

    }
}
