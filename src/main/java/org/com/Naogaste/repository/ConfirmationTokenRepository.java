package org.com.Naogaste.repository;

import org.com.Naogaste.config.ConfirmationToken;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public
interface ConfirmationTokenRepository extends CrudRepository<ConfirmationToken, Long> {

}
