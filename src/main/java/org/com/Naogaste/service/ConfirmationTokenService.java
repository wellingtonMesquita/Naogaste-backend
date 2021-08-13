package org.com.Naogaste.service;

import lombok.AllArgsConstructor;
import org.com.Naogaste.config.ConfirmationToken;
import org.com.Naogaste.repository.ConfirmationTokenRepository;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ConfirmationTokenService {



        private final ConfirmationTokenRepository confirmationTokenRepository;

        void saveConfirmationToken(ConfirmationToken confirmationToken) {

            confirmationTokenRepository.save(confirmationToken);
        }
}
