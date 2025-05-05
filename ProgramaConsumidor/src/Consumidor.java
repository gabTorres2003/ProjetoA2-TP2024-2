public class Consumidor {
    private int id;
    private int anoNascimento;
    private String escolaridade;
    private String estadoCivil;
    private double renda;
    private int gastoComVinhos;
    private int gastoComCarnes;
    private int comprasWeb;
    private int comprasLoja;

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public int getAnoNascimento() { return anoNascimento; }
    public void setAnoNascimento(int anoNascimento) { this.anoNascimento = anoNascimento; }

    public String getEscolaridade() { return escolaridade; }
    public void setEscolaridade(String escolaridade) { this.escolaridade = escolaridade; }

    public String getEstadoCivil() { return estadoCivil; }
    public void setEstadoCivil(String estadoCivil) { this.estadoCivil = estadoCivil; }

    public double getRenda() { return renda; }
    public void setRenda(double renda) { this.renda = renda; }

    public int getGastoComVinhos() { return gastoComVinhos; }
    public void setGastoComVinhos(int gastoComVinhos) { this.gastoComVinhos = gastoComVinhos; }

    public int getGastoComCarnes() { return gastoComCarnes; }
    public void setGastoComCarnes(int gastoComCarnes) { this.gastoComCarnes = gastoComCarnes; }

    public int getComprasWeb() { return comprasWeb; }
    public void setComprasWeb(int comprasWeb) { this.comprasWeb = comprasWeb; }

    public int getComprasLoja() { return comprasLoja; }
    public void setComprasLoja(int comprasLoja) { this.comprasLoja = comprasLoja; }
}
