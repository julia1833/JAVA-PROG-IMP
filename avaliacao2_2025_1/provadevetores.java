import java.util.Scanner;

public class provadevetores {

    static Scanner input = new Scanner(System.in);

    static class Pessoa {
        String nome;
        int idade;
        double peso;
        double altura;
    }

    // QUESTAO 1
    public static int cadastrarPessoa(Pessoa[] v, int qtd) {
        String nome;

        if (qtd >= v.length) {
            return qtd;
        }

        System.out.println("Digite o nome: ");
        nome = input.nextLine();

        while (buscarPessoaPorNome(v, qtd, nome) != -1) {
            System.out.println("Nome ja cadastrado! Digite outro nome: ");
            nome = input.nextLine();
        }

        v[qtd] = new Pessoa();

        v[qtd].nome = nome;

        System.out.println("Digite a idade: ");
        v[qtd].idade = input.nextInt();

        System.out.println("Digite o peso: ");
        v[qtd].peso = input.nextDouble();

        System.out.println("Digite a altura: ");
        v[qtd].altura = input.nextDouble();
        input.nextLine();

        qtd += 1;

        return qtd;
    }

    public static int buscarPessoaPorNome(Pessoa[] v, int qtd, String nome) {
        for (int i = 0; i < qtd; i += 1) {
            if (v[i].nome.equalsIgnoreCase(nome)) {
                return i;
            }
        }

        return -1;
    }

    // QUESTAO 2
    public static void imprimirPessoas(Pessoa[] v, int qtd) {
        for (int i = 0; i < qtd; i += 1) {
            System.out.println("Nome: " + v[i].nome);
            System.out.println("Idade: " + v[i].idade);
            System.out.println("Peso: " + v[i].peso);
            System.out.println("Altura: " + v[i].altura);
            System.out.printf("IMC: %.2f\n", imc(v[i]));
            System.out.println();
        }
    }

    public static double imc(Pessoa p) {
        return p.peso / (p.altura * p.altura);
    }

    // QUESTAO 3
    public static int maisVelhaIMCMagreza(Pessoa[] v, int qtd) {
        int posMaior = -1;

        for (int i = 0; i < qtd; i += 1) {
            if (imc(v[i]) < 18.5) {
                if (posMaior == -1 || v[i].idade > v[posMaior].idade) {
                    posMaior = i;
                }
            }
        }

        return posMaior;
    }

    // QUESTAO 4
    public static void insertionSortPorNome(Pessoa[] v, int qtd) {
        for (int i = 1; i < qtd; i += 1) {
            Pessoa chave = v[i];
            int j = i - 1;

            while (j >= 0 && v[j].nome.compareToIgnoreCase(chave.nome) > 0) {
                v[j + 1] = v[j];
                j -= 1;
            }

            v[j + 1] = chave;
        }
    }

    // QUESTAO 5
    public static int contarPessoasMaioresIdade(Pessoa[] v, int qtd, int idadeMinima) {
        int cont = 0;

        for (int i = 0; i < qtd; i += 1) {
            if (v[i].idade >= idadeMinima) {
                cont += 1;
            }
        }

        return cont;
    }

    public static void main(String[] args) {

        Pessoa[] v = new Pessoa[100];

        int qtd = 0;
        int opcao;
        int pos;
        int idadeMinima;

        do {

            System.out.println("------ MENU ------");
            System.out.println("1 - Cadastrar pessoa");
            System.out.println("2 - Imprimir pessoas");
            System.out.println("3 - Pessoa mais velha com IMC magreza");
            System.out.println("4 - Ordenar por nome");
            System.out.println("5 - Contar pessoas por idade minima");
            System.out.println("0 - Sair");

            opcao = input.nextInt();
            input.nextLine();

            if (opcao == 1) {

                qtd = cadastrarPessoa(v, qtd);

            } else if (opcao == 2) {

                imprimirPessoas(v, qtd);

            } else if (opcao == 3) {

                pos = maisVelhaIMCMagreza(v, qtd);

                if (pos != -1) {

                    System.out.println("Nome: " + v[pos].nome);
                    System.out.println("Idade: " + v[pos].idade);

                } else {

                    System.out.println("Nenhuma pessoa encontrada.");

                }

            } else if (opcao == 4) {

                insertionSortPorNome(v, qtd);

                System.out.println("Ordenado com sucesso!");

            } else if (opcao == 5) {

                System.out.println("Digite a idade minima:");
                idadeMinima = input.nextInt();

                System.out.println(
                    "Quantidade: " +
                    contarPessoasMaioresIdade(v, qtd, idadeMinima)
                );

            }

        } while (opcao != 0);

    }

}
