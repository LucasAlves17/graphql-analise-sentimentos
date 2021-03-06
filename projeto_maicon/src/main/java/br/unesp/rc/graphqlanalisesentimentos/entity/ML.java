package br.unesp.rc.graphqlanalisesentimentos.entity;

import br.unesp.rc.graphqlanalisesentimentos.repository.SentimentoRepository;
import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import weka.classifiers.bayes.NaiveBayes;
import weka.core.Attribute;
import weka.core.DenseInstance;
import weka.core.Instances;
import weka.core.SerializationHelper;
import weka.experiment.InstanceQuery;
import br.unesp.rc.graphqlanalisesentimentos.resolver.mutation.SentimentoMutation;

import java.util.ArrayList;
import java.util.List;

@Component
public class ML implements GraphQLMutationResolver {

    String model = "/home/maicondallagnol/Documentos/Faculdade/2020/SOO/Trabalho/projeto/src/main/resources/models/classificador.model";

    @Autowired
    private SentimentoRepository sent_rep;

    private Instances queryBaseForWeka() throws Exception {
        InstanceQuery query = new InstanceQuery();
        query.setDatabaseURL("jdbc:mysql://localhost:3306/projeto_soo");
        query.setUsername("maicondallagnol");
        query.setPassword("17051998");
        query.setQuery("select frase.frase, sentimento.nome from analise inner join frase on " +
                "analise.id_frase=frase.id inner join sentimento on analise.id_sentimento=sentimento.id");

        Instances data = query.retrieveInstances();
        data.setClassIndex(data.numAttributes() - 1);

        return data;
    }


    public void makeNewModel() throws Exception {

        Instances data = queryBaseForWeka();
        NaiveBayes classificador = new NaiveBayes();

        classificador.buildClassifier(data);

        SerializationHelper.write(model, classificador);

    }

    private DenseInstance make_instance(String frase_to_classify) {
        SentimentoMutation sent = new SentimentoMutation();

        ArrayList<Attribute> attributeList = sent.createAttributeList();

        Instances data = new Instances("NovaInstancia", attributeList, 0);

        DenseInstance inst_co = new DenseInstance(data.numAttributes());
        data.add(inst_co);
        data.setClassIndex(data.numAttributes() - 1);

        inst_co.setDataset(data);
        inst_co.setValue(attributeList.get(0), frase_to_classify);
        inst_co.setClassMissing();

        return inst_co;
    }

    public Integer make_classification(String frase) throws Exception {

        NaiveBayes modelo = load_model();
        DenseInstance instance_frase = make_instance(frase);
        double predicao = modelo.classifyInstance(instance_frase);
        String classe = instance_frase.classAttribute().value((int) predicao);

        return sent_rep.findIdByNome(classe);
    }

    private NaiveBayes load_model() throws Exception {
        return (NaiveBayes) SerializationHelper.read(model);
    }
}
