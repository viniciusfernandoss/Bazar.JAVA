
public class Conta {

    private Clientes clientes;
    private Roupas roupas;

    public Conta(Clientes clientes, Roupas roupas) {
        this.clientes = clientes;
        this.roupas = roupas;
    }

    @Override
    public String toString() {
        return "Conta [clientes=" + clientes + ", roupas=" + roupas + "]";
    }

}
