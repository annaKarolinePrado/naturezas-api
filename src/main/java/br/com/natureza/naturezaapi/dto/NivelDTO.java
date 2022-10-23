package br.com.natureza.naturezaapi.dto;

import br.com.natureza.naturezaapi.models.Nivel;
public class NivelDTO {

    private Integer id;
    private Integer numero;
    private Integer nivel;
    private String descricao;
    private Integer digito;
    private Integer separador;

    public NivelDTO() {
    }

    public NivelDTO(Nivel nivel) {
        this.id = nivel.getId();
        this.numero = nivel.getNumero();
        this.nivel = nivel.getNivel();
        this.descricao = nivel.getDescricao();
        this.digito = nivel.getDigito();
        this.separador = nivel.getSeparador();
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
}
