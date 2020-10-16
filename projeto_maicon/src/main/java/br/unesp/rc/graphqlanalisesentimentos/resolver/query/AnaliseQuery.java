package br.unesp.rc.graphqlanalisesentimentos.resolver.query;

import br.unesp.rc.graphqlanalisesentimentos.entity.Analise;
import br.unesp.rc.graphqlanalisesentimentos.repository.AnaliseRepository;
import br.unesp.rc.graphqlanalisesentimentos.repository.UsuarioRepository;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AnaliseQuery implements GraphQLQueryResolver {

    private AnaliseRepository analiseRepository;
    private UsuarioRepository usuarioRepository;

    public List<Analise> getAnalises(Integer id_usuario)
    {
        return analiseRepository.findByUsuario(usuarioRepository.findById(id_usuario).orElseGet(null));
    }
}
