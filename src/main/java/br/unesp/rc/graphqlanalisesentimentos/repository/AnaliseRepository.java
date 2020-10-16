package br.unesp.rc.graphqlanalisesentimentos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.unesp.rc.graphqlanalisesentimentos.entity.Analise;

public interface AnaliseRepository extends JpaRepository<Analise, Integer>{
    
}
