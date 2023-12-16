import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Main {

    static Scanner leia = new Scanner(System.in);
    static List<Conta> conta;
    static List<Clientes> clientes;
    static List<Roupas> roupas;

    public static void main(String[] args) {

        conta = new ArrayList<Conta>();
        clientes = new ArrayList<Clientes>();
        roupas = new ArrayList<Roupas>();
        menu();
    }

    private static void menu() {
        System.out.println("=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*");
        System.out.println("    BEM VINDO AO BAZAR DO VINICIUS    ");
        System.out.println("=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=+");
        System.out.println("Escolha um dos nossos serviços a baixo:\n 1 - Cadastrar\n 2 - Consultar Saldo\n 3 - Anunciar Roupa\n 4 - Remover Roupa\n 5 - Adicionar Dinheiro\n 6 - Comprar roupa");
        System.out.println("------------------------------------");
        System.out.print("Escreva aqui: ");
        int opt = leia.nextInt();


        switch (opt) {
            case 1:
                cadastrar();
                break;
            case 2:
                consuSaldoCliente();
                break;
            case 3:
                anunciarRoupa();
                break;
            case 4:
                removerRoupa();
                break;
            case 5:
                addMoney();
                break;
            case 6:
                comprar();

                break;
        }

    }

    private static void comprar() {
        System.out.print("Digite seu CPF cadastrado: ");
        String cpf = leia.next();
        boolean cpfEncontrado = false;

        for (Clientes c : clientes) {
            if (c.getCpf().equalsIgnoreCase(cpf)) {
                cpfEncontrado = true;

                for (Roupas r : roupas) {
                    System.out.println(r);
                }

                System.out.print("Qual id de roupa você deseja comprar? ");
                Integer idCompra = leia.nextInt();
                boolean roupaEncontrada = false;

                Iterator<Roupas> iterator = roupas.iterator();
                while (iterator.hasNext()) {
                    Roupas r = iterator.next();
                    if (r.getId() == idCompra) {
                        roupaEncontrada = true;
                        if (c.getDinheiro() >= r.getPreco()) {
                            c.setDinheiro(c.getDinheiro() - r.getPreco());
                            iterator.remove();
                            System.out.println("Roupa comprada com sucesso.");
                        } else {
                            System.out.println("Sem saldo suficiente.");
                        }
                        break;
                    }
                }

                if (!roupaEncontrada) {
                    System.out.println("Roupa não encontrada.");
                }
            }
        }

        if (!cpfEncontrado) {
            System.out.println("CPF não existe no banco.");
        }

        menu();
    }

    private static void addMoney() {
        System.out.print("Digite seu CPF cadastrado: ");
        String cpf = leia.next();
        for (Clientes c : clientes) {
            if (c.getCpf().equalsIgnoreCase(cpf)) {
                System.out.print("Valor depositado: ");
                Integer money = leia.nextInt();

                c.setDinheiro(c.getDinheiro() + money);

            } else {
                System.out.println("CPF não existe no banco.");
            }
        }
        menu();
    }

    private static void removerRoupa() {
        System.out.println("Digite seu CPF cadastrado: ");
        String cpf = leia.next();

        boolean cpfEncontrado = false;

        for (Clientes c : clientes) {
            if (c.getCpf().equalsIgnoreCase(cpf)) {
                cpfEncontrado = true;

                System.out.println("Digite o id da roupa: ");
                Integer id = leia.nextInt();

                Iterator<Roupas> iterator = roupas.iterator();
                while (iterator.hasNext()) {
                    Roupas r = iterator.next();
                    if (r.getId() == id) {
                        iterator.remove();
                        System.out.println("Roupa removida com sucesso. ");
                    }
                }
            }
        }

        if (!cpfEncontrado) {
            System.out.println("CPF não existe no banco.");
        }

        menu();
    }

    private static void anunciarRoupa() {
        System.out.print("Digite seu CPF cadastrado: ");
        String cpf = leia.next();
        for (Clientes c : clientes) {
            if (c.getCpf().equalsIgnoreCase(cpf)) {
                System.out.print("Preço: ");
                Integer preco = leia.nextInt();
                System.out.print("Roupa MASCULINA ou FEMININA?  ");
                String sexo = leia.next();
                System.out.print("Tamanho: ");
                String tamanho = leia.next();
                System.out.print("Cor: ");
                String cor = leia.next();
                System.out.print("Modelo: ");
                String model = leia.next();

                Integer id = 0;

                for (Roupas r : roupas) {
                    if (r.getId() == id) {
                        id++;
                    }
                }
                Roupas roupa = new Roupas(model, preco, sexo, tamanho, cor, id);

                roupas.add(roupa);

                Conta cont = new Conta(c, roupa);

                conta.add(cont);

            } else {
                System.out.println("CPF não existe no banco.");
            }
        }
        menu();
    }

    private static void consuSaldoCliente() {
        for (Clientes c : clientes) {
            System.out.println(c);
        }

        for (Conta c : conta) {
            System.out.println(c);
        }
        menu();
    }

    private static void cadastrar() {
        System.out.println("------------------------------------");
        System.out.print("Nome: ");
        String nome = leia.next();
        System.out.println("------------------------------------");
        System.out.print("CPF: ");
        String cpf = leia.next();
        for (Clientes c : clientes) {
            if (c.getCpf().equalsIgnoreCase(cpf)) {
                System.out.println("------------------------------------");
                System.out.println("CPF já usado!");
                menu();
            }
        }
        Clientes cliente = new Clientes(nome, cpf, 0);
        clientes.add(cliente);

        menu();
    }
}
