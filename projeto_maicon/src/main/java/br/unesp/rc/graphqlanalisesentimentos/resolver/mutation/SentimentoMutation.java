package br.unesp.rc.graphqlanalisesentimentos.resolver.mutation;

import br.unesp.rc.graphqlanalisesentimentos.entity.Sentimento;
import br.unesp.rc.graphqlanalisesentimentos.repository.SentimentoRepository;
import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import weka.core.Attribute;
import java.util.ArrayList;
import java.util.List;

@Component
public class SentimentoMutation implements GraphQLMutationResolver {

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
        sentimento.setId(id);
        sentimento.setNome(nome);
        sentimento.setEmoticon(emoticon);
        sentimento.setDescricao(descricao);

        return sentimentoRepository.saveAndFlush(sentimento);
    }

    public Boolean deleteSentimento(Integer id) {
        sentimentoRepository.deleteById(id);
        return true;
    }

    public ArrayList<Attribute> createAttributeList()
    {
        ArrayList<Attribute> attributeList = new ArrayList<Attribute>();
        ArrayList<String> classVal = (ArrayList<String>) sentimentoRepository.findAllSentimentos();

        Attribute frase = new Attribute("frase", (List<String>) null);
        Attribute classes = new Attribute("sentimento", classVal);

        attributeList.add(frase);
        attributeList.add(classes);

        return attributeList;
    }

}
