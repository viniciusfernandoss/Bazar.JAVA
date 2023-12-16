
public class Clientes {

    private String nome;
    private String cpf;
    private Integer dinheiro;

    public Clientes(String nome, String cpf, Integer dinheiro) {
        super();
        this.nome = nome;
        this.cpf = cpf;
        this.dinheiro = dinheiro;
    }

    public Integer getDinheiro() {
        return dinheiro;
    }

    public void setDinheiro(Integer dinheiro) {
        this.dinheiro = dinheiro;
    }

    public String getNome() {
        return nome;
    }

    protected void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    protected void setCpf(String cpf) {
        this.cpf = cpf;
    }

    @Override
    public String toString() {
        return "------------------------------\nCliente: " + getNome() + "\nCPF: " + getCpf() + "\nSaldo: " + getDinheiro();
    }


}
