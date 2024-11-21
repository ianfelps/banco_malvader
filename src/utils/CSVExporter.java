package utils;

import com.opencsv.CSVWriter;
import models.Transacao;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class CSVExporter {
    public void exportarParaCSV(List<Transacao> transacoes, String caminhoArquivo) {
        try (CSVWriter writer = new CSVWriter(new FileWriter(caminhoArquivo))) {
            // Cabeçalho
            String[] cabecalho = {"ID da Conta", "Tipo", "Valor"};
            writer.writeNext(cabecalho);

            // Dados
            for (Transacao transacao : transacoes) {
                String[] linha = {
                        String.valueOf(transacao.getIdConta()),
                        transacao.getTipo(),
                        String.valueOf(transacao.getValor())
                };
                writer.writeNext(linha);
            }
            System.out.println("Arquivo CSV criado com sucesso: " + caminhoArquivo);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}