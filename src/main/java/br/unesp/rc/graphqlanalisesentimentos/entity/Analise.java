package br.unesp.rc.graphqlanalisesentimentos.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "analise")
public class Analise implements Serializable{
    
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @Column(name = "data_analise")
    private Date dtAnalise;
    
    @Column(name = "correto")
    private boolean correto;
    
    @Column(name = "nova")
    private boolean nova;
    
    @OneToOne
    @JoinColumn(name = "frase_id", nullable = false, updatable = false)
    private Frase frase;
    
    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false, updatable = false)
    private Usuario usuario;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDtAnalise() {
        return dtAnalise;
    }

    public void setDtAnalise(Date dtAnalise) {
        this.dtAnalise = dtAnalise;
    }

    public boolean isCorreto() {
        return correto;
    }

    public void setCorreto(boolean correto) {
        this.correto = correto;
    }

    public boolean isNova() {
        return nova;
    }

    public void setNova(boolean nova) {
        this.nova = nova;
    }

    public Frase getFrase() {
        return frase;
    }

    public void setFrase(Frase frase) {
        this.frase = frase;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
}
