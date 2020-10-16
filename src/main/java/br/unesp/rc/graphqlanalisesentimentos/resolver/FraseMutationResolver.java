package br.unesp.rc.graphqlanalisesentimentos.resolver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import br.unesp.rc.graphqlanalisesentimentos.entity.Frase;
import br.unesp.rc.graphqlanalisesentimentos.entity.Sentimento;
import br.unesp.rc.graphqlanalisesentimentos.repository.FraseRepository;
import br.unesp.rc.graphqlanalisesentimentos.repository.SentimentoRepository;
import java.util.Date;


@Component
public class FraseMutationResolver implements GraphQLMutationResolver{
    
    @Autowired
    private FraseRepository fraseRepository;
    
    @Autowired
    private SentimentoRepository sentimentoRepository;
    
    public Frase addFrase(String texto) {

        Frase frase = new Frase();
        frase.setTexto(texto);
        
        return fraseRepository.saveAndFlush(frase);
    }
    
    public Frase updateFrase(Integer id, String texto, Integer sentimento_id){
        Sentimento sentimento = sentimentoRepository.findById(sentimento_id).orElseGet(null);
        
        Frase frase = new Frase();
        frase.setId(id);
        frase.setTexto(texto);
        frase.setSentimento(sentimento);

        return fraseRepository.saveAndFlush(frase);
    }     
    public Boolean deleteFrase(Integer id) {
            fraseRepository.deleteById(id);
            return true;
    }
}
