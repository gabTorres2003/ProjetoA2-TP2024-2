import java.util.ArrayList;
import java.util.List;

public class VetorDeConsumidores implements ColecaoConsumidor {
    private List<Consumidor> lista;

    public VetorDeConsumidores() {
        lista = new ArrayList<>();
    }

    public void adicionarConsumidor(Consumidor consumidor) {
        lista.add(consumidor);
    }

    public void excluirConsumidor(String nomeDoConsumidor) {
        lista.removeIf(c -> c.getEscolaridade().equalsIgnoreCase(nomeDoConsumidor)); // ou outro critério
    }

    public Consumidor obterConsumidor(int posicao) {
        return lista.get(posicao);
    }

    public int obterTotalDeConsumidores() {
        return lista.size();
    }

    public void trocarPosicaoEntreConsumidores(int posicao1, int posicao2) {
        Consumidor temp = lista.get(posicao1);
        lista.set(posicao1, lista.get(posicao2));
        lista.set(posicao2, temp);
    }

    public void alterarConsumidor(int posicao, Consumidor novoConsumidor) {
        lista.set(posicao, novoConsumidor);
    }

    public void ordenarConsumidores(Ordenador ordenador) {
        ordenador.ordenar(this);
    }
}
