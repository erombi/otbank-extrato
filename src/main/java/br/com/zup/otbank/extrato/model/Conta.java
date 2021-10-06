package br.com.zup.otbank.extrato.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Conta {

    @Id
    private String numeroConta;

    private String idCliente;

    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, mappedBy = "conta")
    private List<Transacao> transacoes;

    @Deprecated
    public Conta() {
    }

    public Conta(String numeroConta, String idCliente) {
        this.numeroConta = numeroConta;
        this.idCliente = idCliente;
    }

    public void adicionaTransacoes(Transacao transacao){
        this.transacoes.add(transacao);
    }


}
