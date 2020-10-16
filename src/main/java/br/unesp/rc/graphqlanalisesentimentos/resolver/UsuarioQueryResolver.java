package br.unesp.rc.graphqlanalisesentimentos.resolver;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import br.unesp.rc.graphqlanalisesentimentos.entity.Usuario;
import br.unesp.rc.graphqlanalisesentimentos.repository.UsuarioRepository;

@Component
public class UsuarioQueryResolver implements GraphQLQueryResolver{
    
    @Autowired
    private UsuarioRepository usuarioRepository;
    
    public List<Usuario> allUsuarios(){
        return usuarioRepository.findAll();
    }
    
    public Usuario usuario(Integer id){
        return usuarioRepository.findById(id).orElseGet(null);
    }
    
}