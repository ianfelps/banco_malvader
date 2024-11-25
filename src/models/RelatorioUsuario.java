package models;

import java.util.ArrayList;
import java.util.List;

public class RelatorioUsuario {
    private List<UsuarioConta.Conta> contas;
    private List<Transacao> transacoes;

    // construtor
    public RelatorioUsuario() {
        this.contas = new ArrayList<>();
        this.transacoes = new ArrayList<>();
    }

    // metodo para adicionar uma conta
    public void adicionarConta(UsuarioConta.Conta conta) {
        contas.add(conta);
    }

    // metodo para adicionar uma transacao
    public void adicionarTransacao(Transacao transacao) {
        transacoes.add(transacao);
    }

    // getters para recuperar as informações
    public List<UsuarioConta.Conta> getContas() {
        return contas;
    }

    public List<Transacao> getTransacoes() {
        return transacoes;
    }
}

