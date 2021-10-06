package br.com.zup.otbank.extrato.request;

import br.com.zup.otbank.extrato.TipoTransacao;
import br.com.zup.otbank.extrato.model.Conta;
import br.com.zup.otbank.extrato.model.Transacao;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;
import java.time.LocalDate;

public class NovaTransacaoRequest {

    @NotBlank
    private String numeroConta;

    @NotBlank
    private String idCliente;

    @NotNull
    @Positive
    private BigDecimal valor;

    @NotNull
    private TipoTransacao tipoTransacao;

    private LocalDate dataTransacao;

    public NovaTransacaoRequest() {
    }

    public String getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(String numeroConta) {
        this.numeroConta = numeroConta;
    }

    public String getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(String idCliente) {
        this.idCliente = idCliente;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public TipoTransacao getTipoTransacao() {
        return tipoTransacao;
    }

    public void setTipoTransacao(TipoTransacao tipoTransacao) {
        this.tipoTransacao = tipoTransacao;
    }

    public LocalDate getDataTransacao() {
        return dataTransacao;
    }

    public void setDataTransacao(LocalDate dataTransacao) {
        this.dataTransacao = dataTransacao;
    }

    public Conta toModel() {
        var conta = new Conta(this.numeroConta, this.idCliente);

        conta.adicionaTransacoes(
                new Transacao(conta, this.tipoTransacao, this.valor, this.dataTransacao)
        );

        return conta;
    }
}
