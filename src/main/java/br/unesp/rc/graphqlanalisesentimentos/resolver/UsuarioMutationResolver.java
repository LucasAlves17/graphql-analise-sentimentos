package br.unesp.rc.graphqlanalisesentimentos.resolver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import br.unesp.rc.graphqlanalisesentimentos.entity.Usuario;
import br.unesp.rc.graphqlanalisesentimentos.repository.UsuarioRepository;


@Component
public class UsuarioMutationResolver implements GraphQLMutationResolver{
    
    @Autowired
    private UsuarioRepository usuarioRepository;
    
    public Usuario addUsuario(String nome, String sobrenome) {

        Usuario usuario = new Usuario();
        usuario.setNome(nome);
        usuario.setSobrenome(sobrenome);

        return usuarioRepository.saveAndFlush(usuario);
    }
}
