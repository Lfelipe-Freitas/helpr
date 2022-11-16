package org.soulcodeacademy.helpr.domain.dto;

import org.soulcodeacademy.helpr.domain.enums.Status;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class ChamadoDTO {
    @NotBlank(message = "Titulo é obrigatório")
    private String titulo;
    @NotBlank(message = "Descrição é obrigatório")
    private String descricao;

    @NotNull(message = "IdCliente é obrigatório")
    private Integer idCliente;

    private Integer idFuncionario;

    private Status status;

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public Integer getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(Integer idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
