import java.io.*;

public class ManipulaDataset {

    public static void lerDoArquivoCSV(ColecaoConsumidor colecao, String caminho) {
        try (BufferedReader leitor = new BufferedReader(new FileReader(caminho))) {
            String linha;
            boolean primeiraLinha = true;

            while ((linha = leitor.readLine()) != null) {
                if (primeiraLinha) {
                    primeiraLinha = false;
                    continue;
                }
                String[] dados = linha.split("\t");
                try {
                    if (dados.length < 20) {
                        continue;
                    }

                    Consumidor c = new Consumidor();
                    c.setId(Integer.parseInt(dados[0]));
                    c.setAnoNascimento(Integer.parseInt(dados[1]));
                    c.setEscolaridade(dados[2]);
                    c.setEstadoCivil(dados[3]);
                    String renda = dados[4].trim();
                    c.setRenda(renda.isEmpty() ? 0.0 : Double.parseDouble(renda));
                    c.setGastoComVinhos(Integer.parseInt(dados[9]));
                    c.setGastoComCarnes(Integer.parseInt(dados[12]));
                    c.setComprasWeb(Integer.parseInt(dados[17]));
                    c.setComprasLoja(Integer.parseInt(dados[19]));

                    colecao.adicionarConsumidor(c);
                } catch (Exception e) {
                    continue;
                }
            }
        } catch (IOException e) {
        }
    }

    public static void escreverNoArquivoCSV(ColecaoConsumidor colecao, String caminho) {
        try (BufferedWriter escritor = new BufferedWriter(new FileWriter(caminho))) {
            escritor.write("ID;AnoNascimento;Escolaridade;EstadoCivil;Renda;GastoComVinhos;GastoComCarnes;ComprasWeb;ComprasLoja\n");

            int i = 0;
            Consumidor c = colecao.obterConsumidor(i);
            while (c != null) {
                escritor.write(c.getId() + ";" + c.getAnoNascimento() + ";" + c.getEscolaridade() + ";" +
                              c.getEstadoCivil() + ";" + c.getRenda() + ";" + c.getGastoComVinhos() + ";" +
                              c.getGastoComCarnes() + ";" + c.getComprasWeb() + ";" + c.getComprasLoja() + "\n");
                i++;
                c = colecao.obterConsumidor(i);
            }
        } catch (IOException e) {
        }
    }
}
