package br.unesp.rc.graphqlanalisesentimentos.resolver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import br.unesp.rc.graphqlanalisesentimentos.entity.Frase;
import br.unesp.rc.graphqlanalisesentimentos.repository.FraseRepository;
import br.unesp.rc.graphqlanalisesentimentos.repository.SentimentoRepository;


@Component
public class FraseMutationResolver implements GraphQLMutationResolver{
    
    @Autowired
    private FraseRepository fraseRepository;
    
    public Frase addFrase(String texto) {

        Frase frase = new Frase();
        frase.setTexto(texto);
        
        return fraseRepository.saveAndFlush(frase);
    }
}
