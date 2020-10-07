package br.unesp.rc.graphqlanalisesentimentos.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "sentimento")
public class Sentimento implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "idSentimento")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idSentimento;
        
        @Column(name = "nome")
	private String nome;
        
        @Column(name = "emoticon")
	private String emoticon;
        
        @Column(name = "descricao")
	private String descricao;

    public Integer getIdSentimento() {
        return idSentimento;
    }

    public void setIdSentimento(Integer idSentimento) {
        this.idSentimento = idSentimento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmoticon() {
        return emoticon;
    }

    public void setEmoticon(String emoticon) {
        this.emoticon = emoticon;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
        
        
}
