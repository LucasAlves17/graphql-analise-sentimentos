package br.unesp.rc.graphqlanalisesentimentos.resolver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import br.unesp.rc.graphqlanalisesentimentos.repository.LoginRepository;

@Component
public class LoginQueryResolver implements GraphQLQueryResolver{
    
    @Autowired
    private LoginRepository loginRepository;
    
    public boolean autenticarLogin(String nomeUsuario, String senha){
        return loginRepository.existsLoginByNomeUsuarioAndSenha(nomeUsuario, senha);
    }
}
