package br.com.estudos.dankicode.pizzariadankicode.service;

import br.com.estudos.dankicode.pizzariadankicode.config.CriptografiaSenha;
import br.com.estudos.dankicode.pizzariadankicode.domain.Usuario;
import br.com.estudos.dankicode.pizzariadankicode.domain.dto.UsuarioRequest;
import br.com.estudos.dankicode.pizzariadankicode.domain.dto.UsuarioResponse;
import br.com.estudos.dankicode.pizzariadankicode.repository.UserRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {

    private final UserRepository repository;
    private final ModelMapper mapper;

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        return repository.findByLogin(login);
    }

    public UsuarioResponse criar(@Valid UsuarioRequest request) {
        request.setPassword(CriptografiaSenha.encode(request.getPassword()));
        var usuario = mapper.map(request, Usuario.class);
        repository.save(usuario);
        return mapper.map(usuario, UsuarioResponse.class);
    }

    public Page<UsuarioResponse> listar(Pageable paginacao) {
        return repository.findAll(paginacao).map(u -> mapper.map(u, UsuarioResponse.class));
    }
}
