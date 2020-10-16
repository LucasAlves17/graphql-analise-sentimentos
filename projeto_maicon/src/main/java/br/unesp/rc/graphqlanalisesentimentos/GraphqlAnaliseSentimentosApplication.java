package br.unesp.rc.graphqlanalisesentimentos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import weka.core.Instances;
import weka.experiment.InstanceQuery;

@SpringBootApplication
public class GraphqlAnaliseSentimentosApplication {

	public static void main(String[] args) {
		SpringApplication.run(GraphqlAnaliseSentimentosApplication.class, args);
	}

//public static void main(String[] args) throws Exception {
//
//    InstanceQuery query = new InstanceQuery();
//    query.setDatabaseURL("jdbc:mysql://localhost:3306/projeto_soo");
//    query.setUsername("maicondallagnol");
//    query.setPassword("17051998");
//    query.setQuery("select * from sentimento");
//
//    Instances data = query.retrieveInstances();
//    System.out.println("a");
//	}
}
