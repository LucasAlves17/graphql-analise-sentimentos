package br.unesp.rc.graphqlanalisesentimentos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.unesp.rc.graphqlanalisesentimentos.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{
    
}