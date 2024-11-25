package controllers;

import com.opencsv.CSVWriter;
import models.RelatorioUsuario;
import models.Transacao;
import models.UsuarioConta;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class RelatorioController {

    public void exportarRelatorioParaCSV(RelatorioUsuario relatorio) {
        String arquivoCSV = "relatorio_usuario.csv";

        try (CSVWriter writer = new CSVWriter(new FileWriter(arquivoCSV))) {
            // Cabeçalho do CSV
            String[] cabecalho = {"Número da Conta", "Agência", "Saldo", "Tipo da Conta", "Tipo de Transação", "Valor da Transação", "Data"};
            writer.writeNext(cabecalho);

            // Escreve dados das contas
            for (UsuarioConta.Conta conta : relatorio.getContas()) {
                String[] linhaConta = {
                        conta.getNumeroConta(),
                        conta.getAgencia(),
                        String.valueOf(conta.getSaldo()),
                        conta.getTipoConta(),
                        "", // Colunas vazias para alinhamento de dados de transação
                        "",
                        ""
                };
                writer.writeNext(linhaConta);

                // Escreve transações relacionadas à conta
                for (Transacao transacao : relatorio.getTransacoes()) {
                    if (transacao.getIdConta() == conta.getIdConta()) { // Assumindo que há um método getIdConta
                        String[] linhaTransacao = {
                                "",
                                "",
                                "",
                                "",
                                transacao.getTipoTransacao(),
                                String.valueOf(transacao.getValor()),
                                transacao.getDataTransacao()
                        };
                        writer.writeNext(linhaTransacao);
                    }
                }
            }

            System.out.println("Relatório exportado com sucesso para " + arquivoCSV);

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Erro ao exportar relatório.");
        }
    }
}
