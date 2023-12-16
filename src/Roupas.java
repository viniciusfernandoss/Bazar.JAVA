
public class Roupas {

    private Integer preco;
    private String sexo;
    private String tamanho;
    private String cor;
    private Integer id;
    private String modelo;

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Integer getId() {
        return id;
    }

    protected void setId(Integer id) {
        this.id = id;
    }

    public Roupas(String modelo, Integer preco, String sexo, String tamanho, String cor, Integer id) {
        super();
        this.modelo = modelo;
        this.preco = preco;
        this.sexo = sexo;
        this.tamanho = tamanho;
        this.cor = cor;
        this.id = id;
    }

    public Integer getPreco() {
        return preco;
    }

    public void setPreco(Integer preco) {
        this.preco = preco;
    }

    protected String getSexo() {
        return sexo;
    }

    protected void setSexo(String sexo) {
        this.sexo = sexo;
    }

    protected String getTamanho() {
        return tamanho;
    }

    protected void setTamanho(String tamanho) {
        this.tamanho = tamanho;
    }

    protected String getCor() {
        return cor;
    }

    protected void setCor(String cor) {
        this.cor = cor;
    }

    @Override
    public String toString() {
        return "--------------------------\nModelo: " + getModelo() + "\nPreço: R$" + getPreco() + "\nGenero: " + getSexo() + "\nTamanho: " + getTamanho()
                + "\nCor: " + getCor() + "\nid: " + getId();
    }

}

