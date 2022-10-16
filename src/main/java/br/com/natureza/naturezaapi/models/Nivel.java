package br.com.natureza.naturezaapi.models;

import br.com.natureza.naturezaapi.enums.Separador;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class Nivel implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;
    private Integer numero;
    private Integer nivel;
    private String descricao;
    private Integer digito;
    private Integer separador;

    public Nivel() {
    }

    public Nivel(Integer id, Integer numero, Integer nivel, String descricao, Integer digito, Separador separador) {
        this.id = id;
        this.numero = numero;
        this.nivel = nivel;
        this.descricao = descricao;
        this.digito = digito;
        this.separador = separador.getCod();
    }

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNumero() {
        return numero;
    }
    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public Integer getNivel() {
        return nivel;
    }
    public void setNivel(Integer nivel) {
        this.nivel = nivel;
    }

    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Integer getDigito() {
        return digito;
    }
    public void setDigito(Integer digito) {
        this.digito = digito;
    }

    public Integer getSeparador() {
        return separador;
    }
    public void setSeparador(Integer separador) {
        this.separador = separador;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Nivel nivel = (Nivel) o;
        return id.equals(nivel.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
