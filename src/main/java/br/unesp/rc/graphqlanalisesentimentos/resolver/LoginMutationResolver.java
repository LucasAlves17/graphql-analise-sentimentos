package br.unesp.rc.graphqlanalisesentimentos.resolver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import br.unesp.rc.graphqlanalisesentimentos.entity.Usuario;
import br.unesp.rc.graphqlanalisesentimentos.entity.Login;
import br.unesp.rc.graphqlanalisesentimentos.repository.UsuarioRepository;
import br.unesp.rc.graphqlanalisesentimentos.repository.LoginRepository;

@Component
public class LoginMutationResolver implements GraphQLMutationResolver{
       
    @Autowired
    private UsuarioRepository usuarioRepository;
    
    @Autowired
    private LoginRepository loginRepository;
    
    public Login addLogin(String nomeUsuario, String senha, Integer usuario_id) {
        Usuario usuario = usuarioRepository.findById(usuario_id).orElseGet(null);
        
        Login login = new Login();
        login.setNomeUsuario(nomeUsuario);
        login.setSenha(senha);
        login.setUsuario(usuario);

        return loginRepository.saveAndFlush(login);
    }
}