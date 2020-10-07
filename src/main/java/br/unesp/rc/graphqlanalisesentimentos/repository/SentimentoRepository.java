package br.unesp.rc.graphqlanalisesentimentos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.unesp.rc.graphqlanalisesentimentos.entity.Sentimento;

public interface SentimentoRepository extends JpaRepository<Sentimento, Integer>{
    
}
