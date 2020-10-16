package br.unesp.rc.graphqlanalisesentimentos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.unesp.rc.graphqlanalisesentimentos.entity.Frase;

public interface FraseRepository extends JpaRepository<Frase, Integer>{
    
}
