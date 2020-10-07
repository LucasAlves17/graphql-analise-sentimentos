package br.unesp.rc.graphqlanalisesentimentos.resolver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import br.unesp.rc.graphqlanalisesentimentos.entity.Sentimento;
import br.unesp.rc.graphqlanalisesentimentos.repository.SentimentoRepository;


@Component
public class MutationResolver implements GraphQLMutationResolver{
    
    @Autowired
    private SentimentoRepository sentimentoRepository;
    
    public Sentimento addSentimento(String nome, String emoticon, String descricao) {

        Sentimento sentimento = new Sentimento();
        sentimento.setNome(nome);
        sentimento.setEmoticon(emoticon);
        sentimento.setDescricao(descricao);

        return sentimentoRepository.saveAndFlush(sentimento);
    }
    
    public Sentimento updateSentimento(Integer id, String nome, String emoticon, String descricao){
        Sentimento sentimento = new Sentimento();
        sentimento.setIdSentimento(id);
        sentimento.setNome(nome);
        sentimento.setEmoticon(emoticon);
        sentimento.setDescricao(descricao);

        return sentimentoRepository.saveAndFlush(sentimento);
    }     
    public Boolean deleteSentimento(Integer id) {
            sentimentoRepository.deleteById(id);
            return true;
    }
}
