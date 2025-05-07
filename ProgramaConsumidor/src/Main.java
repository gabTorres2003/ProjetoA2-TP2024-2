import java.io.File;

public class Main {
    public static void main(String[] args) {
        String caminhoEntrada = // "...\\marketing_campaign.csv";
        String caminhoSaida = "consumidores_filtrados.csv";

        File arquivoEntrada = new File(caminhoEntrada);
        if (!arquivoEntrada.exists()) {
            System.out.println("Arquivo de entrada não encontrado: " + caminhoEntrada);
            return;
        }

        // Carregar os dados inicialmente em ambas as estruturas
        ColecaoConsumidor lista = new LLDeConsumidores();
        ColecaoConsumidor vetor = new VetorDeConsumidores();
        ManipulaDataset.lerDoArquivoCSV(lista, caminhoEntrada);
        ManipulaDataset.lerDoArquivoCSV(vetor, caminhoEntrada);
        System.out.println("Total de consumidores carregados: " + lista.obterTotalDeConsumidores());

        // Definir as ordenações
        Ordenador ordenadorEscolaridade = new OrdenarPorEscolaridadeComBubbleSort();
        Ordenador ordenadorAno = new OrdenarPorAnoDeNascimentoComQuickSort();

        // Escolher a estrutura de dados com base no tipo de ordenação
        ColecaoConsumidor colecaoEscolaridade = (ordenadorEscolaridade instanceof OrdenarPorEscolaridadeComBubbleSort) ? lista : vetor;
        colecaoEscolaridade.ordenarConsumidores(ordenadorEscolaridade);
        System.out.println("Total após ordenação por escolaridade (usando " + colecaoEscolaridade.getClass().getSimpleName() + "): " + colecaoEscolaridade.obterTotalDeConsumidores());

        ColecaoConsumidor colecaoAno = (ordenadorAno instanceof OrdenarPorAnoDeNascimentoComQuickSort) ? vetor : lista;
        colecaoAno.ordenarConsumidores(ordenadorAno);
        System.out.println("Total após ordenação por ano de nascimento (usando " + colecaoAno.getClass().getSimpleName() + "): " + colecaoAno.obterTotalDeConsumidores());

        // Escrever o resultado da última ordenação
        ManipulaDataset.escreverNoArquivoCSV(colecaoAno, caminhoSaida);
        System.out.println("Arquivo salvo em: " + caminhoSaida);
    }
}
