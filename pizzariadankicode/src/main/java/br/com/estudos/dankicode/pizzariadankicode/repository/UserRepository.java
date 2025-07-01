package br.com.estudos.dankicode.pizzariadankicode.repository;

import br.com.estudos.dankicode.pizzariadankicode.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface UserRepository extends JpaRepository<Usuario, Long> {
    UserDetails findByLogin(String login);
}
