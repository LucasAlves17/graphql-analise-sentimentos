package br.unesp.rc.graphqlanalisesentimentos.resolver;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import br.unesp.rc.graphqlanalisesentimentos.entity.Frase;
import br.unesp.rc.graphqlanalisesentimentos.repository.FraseRepository;

@Component
public class FraseQueryResolver implements GraphQLQueryResolver{
    
    @Autowired
    private FraseRepository fraseRepository;
    
    public List<Frase> allSentimentos(){
        return fraseRepository.findAll();
    }
    
    public Frase frase(Integer id){
        return fraseRepository.findById(id).orElseGet(null);
    }
    
}
