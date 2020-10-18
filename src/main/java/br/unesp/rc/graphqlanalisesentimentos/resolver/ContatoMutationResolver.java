package br.unesp.rc.graphqlanalisesentimentos.resolver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import br.unesp.rc.graphqlanalisesentimentos.entity.Usuario;
import br.unesp.rc.graphqlanalisesentimentos.entity.Contato;
import br.unesp.rc.graphqlanalisesentimentos.repository.UsuarioRepository;
import br.unesp.rc.graphqlanalisesentimentos.repository.ContatoRepository;

@Component
public class ContatoMutationResolver implements GraphQLMutationResolver{
       
    @Autowired
    private UsuarioRepository usuarioRepository;
    
    @Autowired
    private ContatoRepository contatoRepository;
    
    public Contato addContato(String email, String celular, Integer usuario_id) {
        Usuario usuario = usuarioRepository.findById(usuario_id).orElseGet(null);
        
        Contato contato = new Contato();
        contato.setEmail(email);
        contato.setCelular(celular);
        contato.setUsuario(usuario);

        return contatoRepository.saveAndFlush(contato);
    }
}
