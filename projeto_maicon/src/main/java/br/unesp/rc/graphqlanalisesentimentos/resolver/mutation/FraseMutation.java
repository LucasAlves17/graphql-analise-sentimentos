package br.unesp.rc.graphqlanalisesentimentos.resolver.mutation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import br.unesp.rc.graphqlanalisesentimentos.entity.Frase;
import br.unesp.rc.graphqlanalisesentimentos.entity.Sentimento;
import br.unesp.rc.graphqlanalisesentimentos.repository.FraseRepository;
import br.unesp.rc.graphqlanalisesentimentos.repository.SentimentoRepository;
import java.util.Date;


@Component
public class FraseMutation implements GraphQLMutationResolver{

    @Autowired
    private FraseRepository fraseRepository;

//    @Autowired
//    private SentimentoRepository sentimentoRepository;

    public Frase addFrase(String texto) {

        Frase frase = new Frase();
        frase.setFrase(texto);

        return fraseRepository.saveAndFlush(frase);
    }

    public Frase updateFrase(Integer id, String texto){

        Frase frase = new Frase();
        frase.setId(id);
        frase.setFrase(texto);

        return fraseRepository.saveAndFlush(frase);
    }

    public Boolean deleteFrase(Integer id) {
        fraseRepository.deleteById(id);
        return true;
    }
}