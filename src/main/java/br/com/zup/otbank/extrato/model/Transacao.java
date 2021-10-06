package br.com.zup.otbank.extrato.model;

import br.com.zup.otbank.extrato.TipoTransacao;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
public class Transacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Conta conta;

    private TipoTransacao tipoTransacao;

    private BigDecimal valor;

    private LocalDate dataTransacao;

    @Deprecated
    public Transacao() {
    }

    public Transacao(Conta conta, TipoTransacao tipoTransacao, BigDecimal valor, LocalDate dataTransacao) {
        this.conta = conta;
        this.tipoTransacao = tipoTransacao;
        this.valor = valor;
        this.dataTransacao = dataTransacao;
    }
}
