package br.unesp.rc.graphqlanalisesentimentos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.unesp.rc.graphqlanalisesentimentos.entity.Login;

public interface LoginRepository extends JpaRepository<Login, Integer>{
    
    boolean existsLoginByNomeUsuarioAndSenha(String nome_usuario, String senha);
}
