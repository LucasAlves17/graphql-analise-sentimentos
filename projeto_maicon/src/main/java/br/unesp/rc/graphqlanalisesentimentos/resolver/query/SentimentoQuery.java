package br.unesp.rc.graphqlanalisesentimentos.resolver.query;

import br.unesp.rc.graphqlanalisesentimentos.entity.Sentimento;
import br.unesp.rc.graphqlanalisesentimentos.repository.SentimentoRepository;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SentimentoQuery implements GraphQLQueryResolver {

    @Autowired
    private SentimentoRepository sentimentoRepository;

//    public List<Integer> allSentimentosIds(){
//        System.out.println("A");
//        return sentimentoRepository.find();
//    }

    public List<Sentimento> allSentimentos(){
        return sentimentoRepository.findAll();
    }

    public Sentimento sentimento(Integer id){
        return sentimentoRepository.findById(id).orElseGet(null);
    }
}
