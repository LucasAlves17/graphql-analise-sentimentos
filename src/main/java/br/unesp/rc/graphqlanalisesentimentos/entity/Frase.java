package br.unesp.rc.graphqlanalisesentimentos.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "frase")
public class Frase implements Serializable{
        private static final long serialVersionUID = 1L;

        @Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
        
        @Column(name = "texto")
	private String texto;
        
        @Column(name = "data_submissao")
	private Date dtSubmissao;
        
        @Column(name = "sentimento_id")
	private Sentimento sentimento;d
}
