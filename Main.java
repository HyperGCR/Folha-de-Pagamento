import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String [] args){
        Scanner scanner = new Scanner(System.in);

        ArrayList<Colaborador> listaColaboradores = new ArrayList<>();

        int opcao = 0;

        while(opcao != 3){


            System.out.println("\n==== Folha de pagamento ====\n1 - Cadastrar Colaborador\n2 - Listar folha de pagamento\n3 - sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();


            switch (opcao) {
                case 1:
                    cadastrarColaborador(scanner, listaColaboradores);
                    break;
                case 2:
                    listaColaboradores(listaColaboradores);
                    break;
                case 3:
                    System.out.println("Encerrando o sistema. Até mais!!");
                    break;
                default:
                System.out.println("Opção invalida! Tente novamente.");
                    break;
            }


        }
        scanner.close();
    }

        private static void cadastrarColaborador(Scanner scanner, ArrayList<Colaborador> lista){

            System.out.println("\n#### Cadastro de Colaborador ####");
            System.out.println("Numero do Registro: ");
            int registro = scanner.nextInt();
            scanner.nextLine();

            System.out.println("Nome completo: ");
            String nome = scanner.nextLine();

            System.out.println("Tipos de colaborador: ");
            System.out.println("1 - Padrão\n2 - Comissionado\n3 - Produção");
            System.out.println("Selecione o tipo de colaborador: ");
            int escolha = scanner.nextInt();



            switch (escolha) {
                case 1:
                    lista.add(new ColaboradorPadrao(registro, nome));
                    System.out.println("Colaborador padrão cadastrado com sucesso!");
                    break;
                case 2:
                    double vendas = lerValorPositivo(scanner, "Total de vendas no mês R$: ");
                    double percentual = lerValorPositivo(scanner, "Percentual de Comissão %: ");
                    lista.add(new ColaboradorComissionado(registro, nome, vendas, percentual));
                    System.out.println("Colaborador comissionado cadastrado com sucesso!");
                    break;
                case 3:
                    double valorPeca = lerValorPositivo(scanner, "Valor por peça: ");
                    int qtdPecas = (int) lerValorPositivo(scanner, "Quantidade de peças produzidas: ");
                    lista.add(new ColaboradorProducao(registro, nome, valorPeca, qtdPecas));
                    System.out.println("Colaborador de Produção cadastrado com sucesso!");
                    break;
                default:
                    System.out.println("Escolha invalida! Cadastro nao concluído.");
                    
            }

        }

        private static void listaColaboradores(ArrayList<Colaborador> lista){

            if (lista.isEmpty()){
                System.out.println("Nenhum colaborador cadastrado.");
                return;

            }
            System.out.println("\n### Folha de pagamento ###");

            for(Colaborador c : lista){
                System.out.println("Registro: " + c.getNumeroRegistro() + "||Nome: " + c.getNomeCompleto() + "||Salario final: R$ " + String.format("%.2f", c.calcSalarioF()));

            }
            System.out.println("------------------------------");

        }
        private static double lerValorPositivo(Scanner scanner, String mensagem){
            double valor;
            do{
                System.out.println(mensagem);
                valor = scanner.nextDouble();
                if (valor < 0){
                    System.out.println("Erro!! O valor nao pode ser negativo. Tente novamente.");
                }

            }while (valor < 0);
            return valor;

            
        }

    }

