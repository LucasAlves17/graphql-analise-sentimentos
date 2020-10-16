package br.unesp.rc.graphqlanalisesentimentos.repository;

import br.unesp.rc.graphqlanalisesentimentos.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import br.unesp.rc.graphqlanalisesentimentos.entity.Analise;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnaliseRepository extends JpaRepository<Analise, Integer> {

//    @Query(value="select count(id_frase) from analise where novo=1 and correto=1")
//    int countAllByNovoECorreto();

    int countAllByNovoAndCorreto(int novo, int correto);

    @Query(value = "update analise set novo=0")
    void setNovoToZero();


//    @Query(value = "select id_frase, id_sentimento from analise where id_usuario=?1")
//    List<Analise> findAllById_usuario(Integer id_usuario);
    List<Analise> findByUsuario(Usuario usuario);
}
