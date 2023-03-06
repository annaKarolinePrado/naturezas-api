package br.com.natureza.naturezaapi.models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Configuracao implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;
    private String descricao;

    @OneToMany(cascade=CascadeType.ALL)
    @JoinTable(name = "CONFIGURACAO_NIVEL",
            joinColumns = @JoinColumn(name = "configuracao_id"),
            inverseJoinColumns = @JoinColumn(name = "nivel_id")
    )
    private List<Nivel> niveis = new ArrayList<>();

    public Configuracao() {
    }

    public Configuracao(Integer id, String descricao) {
        this.id = id;
        this.descricao = descricao;
    }

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public List<Nivel> getNiveis() {
        return niveis;
    }
    public void setNiveis(List<Nivel> niveis) {
        this.niveis = niveis;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Configuracao that = (Configuracao) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
