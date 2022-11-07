package org.soulcodeacademy.helpr.domain.dto;

import javax.validation.constraints.*;

// DTO - Objeto de transferencia de dados. Util para validação de informação transferidas pelo cliente.
public class CargoDTO {
    // Impede que o valor seja vazio ->""
    // Message é o texto da validação.
    @NotBlank(message = "Campo nome é obrigatório")
    private String nome;
    @NotBlank(message = "Campo descrição é obrigatório")
    private String descricao;

    @NotNull(message = "Campo salario é obrigatório")// impede que seja null
    @Min(value = 500, message = "Campo salário inválido")
    @Max(value = 100000, message = "Campo salário inválido")
    private double salario;

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

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }
}
