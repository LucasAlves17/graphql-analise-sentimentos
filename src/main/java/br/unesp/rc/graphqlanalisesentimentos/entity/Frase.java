package br.unesp.rc.graphqlanalisesentimentos.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

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
    
    @Basic(optional = false)
    @Column(name = "data_submissao", insertable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtSubmissao;

    @OneToOne
    @JoinColumn(name = "sentimento_id", nullable = true, updatable = true)
    private Sentimento sentimento;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public Date getDtSubmissao() {
        return dtSubmissao;
    }

    public void setDtSubmissao(Date dtSubmissao) {
        this.dtSubmissao = dtSubmissao;
    }

    public Sentimento getSentimento() {
        return sentimento;
    }

    public void setSentimento(Sentimento sentimento) {
        this.sentimento = sentimento;
    }
}
