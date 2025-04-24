public class Main {
    public static void main(String[] args) {
        String caminhoEntrada = "marketing_campaign.csv";
        String caminhoSaida = "consumidores_filtrados.csv";

        ColecaoConsumidor colecao = new VetorDeConsumidores();
        ManipulaDataset.lerDoArquivoCsv(colecao, caminhoEntrada);

        System.out.println("Total de consumidores carregados: " + colecao.obterTotalDeConsumidores());
        ManipulaDataset.escreverNoArquivoCsv(colecao, caminhoSaida);
        System.out.println("Arquivo salvo em: " + caminhoSaida);
    }
}
