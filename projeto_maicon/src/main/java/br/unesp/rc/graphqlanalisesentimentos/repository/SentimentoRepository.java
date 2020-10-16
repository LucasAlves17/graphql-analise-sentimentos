package br.unesp.rc.graphqlanalisesentimentos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.unesp.rc.graphqlanalisesentimentos.entity.Sentimento;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SentimentoRepository extends JpaRepository<Sentimento, Integer>{

    @Query(value="select nome from sentimento")
    List<String> findAllSentimentos();
//    List<Sentimento> findAllByNome();

    @Query(value="select id from sentimento where nome=?1")
    Integer findIdByNome(String classe);

//    @Query(value="select u from analise u where u.correto=1")
//    List<Analise> findToTrain();

    
}
