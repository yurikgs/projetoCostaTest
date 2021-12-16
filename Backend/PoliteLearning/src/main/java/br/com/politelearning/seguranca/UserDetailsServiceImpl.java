package br.com.politelearning.seguranca;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.politelearning.model.UsuarioModel;
import br.com.politelearning.repository.UsuarioRepository;

@Service // @Service: informa ao Spring que se trata de uma classe de serviço que irá
			// implementar as regras de negócio
public class UserDetailsServiceImpl implements UserDetailsService {
	// Essa classe irá ser responsável por recuperar os dados do usario dentro dos
	// bancos de dados e converter em objetos de details

	// irá pegar todas as informações de dentro do repositorio de usuário, fazendo
	// uma injeção
	@Autowired
	private UsuarioRepository userRepository;

	// ele irá fazer uma varredura dentro do banco de dados procurando o usuário pelo "userName/email",
	//caso este usuário  não esteja dentro do banco  de dados irá retornar um "not found/não encontrado"
	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		Optional<UsuarioModel> user = userRepository.findByUsuario(userName);
		user.orElseThrow(() -> new UsernameNotFoundException(userName + " not found."));
		return user.map(UserDetailsImpl::new).get();
	}
}
