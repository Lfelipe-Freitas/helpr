package org.soulcodeacademy.helpr.domain;

import org.soulcodeacademy.helpr.domain.enums.Perfil;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Funcionario extends Usuario {
    // Gera uma coluna dtype para indicar qual a subclasse

    // Coluna foto não é obrigatória
    private String foto;

    @ManyToOne
    @JoinColumn(name = "id_cargo") // Cria uma coluna nov que é a chave estrangeira do Cargo
    private Cargo cargo;

    public Funcionario(){}

    public Funcionario(Integer id, String nome, String email, String cpf, String senha, String foto, Cargo cargo) {
        super(id, nome, email, cpf, senha, Perfil.FUNCIONARIO);
        this.cargo = cargo;
        this.foto = foto;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

    // Relacionamento Unidirecional = apenas uma das entidades "conhece" a outra.
    // Relacionamento Bidirecional = as duas entidades se "conhecem".
}
