package br.unesp.rc.graphqlanalisesentimentos.resolver;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import br.unesp.rc.graphqlanalisesentimentos.entity.Sentimento;
import br.unesp.rc.graphqlanalisesentimentos.entity.Usuario;
import br.unesp.rc.graphqlanalisesentimentos.repository.SentimentoRepository;
import br.unesp.rc.graphqlanalisesentimentos.repository.UsuarioRepository;

@Component
public class QueryResolver implements GraphQLQueryResolver{
    
    @Autowired
    private SentimentoRepository sentimentoRepository;
    
    @Autowired
    private UsuarioRepository usuarioRepository;
    
    public List<Sentimento> allSentimentos(){
        return sentimentoRepository.findAll();
    }
    
    public List<Usuario> allUsuarios(){
        return usuarioRepository.findAll();
    }
    
    public Sentimento sentimento(Integer id){
        return sentimentoRepository.findById(id).orElseGet(null);
    }
    
}
