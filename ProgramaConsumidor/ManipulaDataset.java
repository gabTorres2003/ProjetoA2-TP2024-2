import java.io.*;
import java.util.*;

public class ManipulaDataset {

    public static void lerDoArquivoCsv(ColecaoConsumidor colecao, String caminho) {
        try (BufferedReader leitor = new BufferedReader(new FileReader(caminho))) {
            String cabecalho = leitor.readLine(); // Ignora o cabeçalho
            String linha;

            while ((linha = leitor.readLine()) != null) {
                String[] dados = linha.split(";");
                try {
                    Consumidor c = new Consumidor();
                    c.setId(Integer.parseInt(dados[0]));
                    c.setAnoNascimento(Integer.parseInt(dados[1]));
                    c.setEscolaridade(dados[2]);
                    c.setEstadoCivil(dados[3]);
                    c.setRenda(Double.parseDouble(dados[4]));
                    c.setGastoComVinhos(Integer.parseInt(dados[5]));
                    c.setGastoComCarnes(Integer.parseInt(dados[6]));
                    c.setComprasWeb(Integer.parseInt(dados[7]));
                    c.setComprasLoja(Integer.parseInt(dados[8]));

                    colecao.adicionarConsumidor(c);
                } catch (Exception e) {
                    // Ignora linhas com erros ou campos nulos
                }
            }
        } catch (IOException e) {
            System.out.println("Erro ao ler arquivo: " + e.getMessage());
        }
    }

    public static void escreverNoArquivoCsv(ColecaoConsumidor colecao, String caminho) {
        try (BufferedWriter escritor = new BufferedWriter(new FileWriter(caminho))) {
            escritor.write("ID;AnoNascimento;Escolaridade;EstadoCivil;Renda;GastoComVinhos;GastoComCarnes;ComprasWeb;ComprasLoja\n");

            for (int i = 0; i < colecao.obterTotalDeConsumidores(); i++) {
                Consumidor c = colecao.obterConsumidor(i);
                escritor.write(c.getId() + ";" + c.getAnoNascimento() + ";" + c.getEscolaridade() + ";" +
                               c.getEstadoCivil() + ";" + c.getRenda() + ";" + c.getGastoComVinhos() + ";" +
                               c.getGastoComCarnes() + ";" + c.getComprasWeb() + ";" + c.getComprasLoja() + "\n");
            }

        } catch (IOException e) {
            System.out.println("Erro ao escrever arquivo: " + e.getMessage());
        }
    }
}
