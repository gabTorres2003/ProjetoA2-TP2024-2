

public class Main {
    public static void main(String[] args) {
        String caminhoEntrada = //"XXXX"//;
        String caminhoSaida = "consumidores_filtrados.csv";

        ColecaoConsumidor colecao = new LLDeConsumidores();
        ManipulaDataset.lerDoArquivoCSV(colecao, caminhoEntrada);
        System.out.println("Total de consumidores carregados: " + colecao.obterTotalDeConsumidores());
        ManipulaDataset.escreverNoArquivoCSV(colecao, caminhoSaida);
        System.out.println("Arquivo salvo em: " + caminhoSaida);
    }
}