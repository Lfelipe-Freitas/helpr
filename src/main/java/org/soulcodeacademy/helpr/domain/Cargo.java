package org.soulcodeacademy.helpr.domain;

import javax.persistence.*;

// Transformar a classe em uma entidade/tabela no banco
@Entity
public class Cargo {
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto_increment
    @Id // usa o atributo abaixo como chave primaria.
    private Integer idCargo;
    @Column(nullable = false, length = 50) //not null e max de caracteres.
    private String nome;
    @Column(nullable = false, length = 120)
    private String descricao;
    @Column(nullable = false) //@Column serve para customizar a coluna
    private Double salario;

    public Cargo(){} // a ORM irá usar esse construtor em conjunto dos getters/setters

    public Cargo(Integer idCargo, String nome, String descricao, Double salario) {
        this.idCargo = idCargo;
        this.nome = nome;
        this.descricao = descricao;
        this.salario = salario;
    }

    public Integer getIdCargo() {
        return idCargo;
    }

    public void setIdCargo(Integer idCargo) {
        this.idCargo = idCargo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getSalario() {
        return salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }
}
