package br.unesp.rc.graphqlanalisesentimentos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.unesp.rc.graphqlanalisesentimentos.entity.Contato;

public interface ContatoRepository extends JpaRepository<Contato, Integer>{
    
}
