[20:16, 16/05/2025] Kauan: import java.util.Scanner;

public class FinanciamentoContabilidade {

    // Função para calcular o valor da parcela com juros compostos
    public static double calcularParcela(double valorFinanciado, double taxaJuros, int numParcelas) {
        double taxaMensal = taxaJuros / 100 / 12; // Convertendo a taxa anual para mensal
        double parcela = (valorFinanciado * taxaMensal) / (1 - Math.pow(1 + taxaMensal, -numParcelas));
        return parcela;
    }

    // Função para calcular o montante com juros simples
    public static double calcularMontante(double valorFinanciado, double taxaJuros, int numParcelas) {
        // Juros simples: M = P * (1 + i * t)
        double montante = valorFinanciado * (1 + (taxaJuros / 100) * numParcelas);
        return montante;
    }

    // Função para calcular os juros simples
    public static double calcularJuros(double valorFinanciado, double taxaJuros, int numParcelas) {
        // Juros simples: J = P * i * t
        double juros = valorFinanciado * (taxaJuros / 100) * numParcelas;
        return juros;
    }

    // Função para mostrar o resumo do financiamento
    public static void mostrarResumo(String nomeCliente, String cpfCliente, double valorFinanciado, double taxaJuros, int numParcelas, double parcela, double juros, double montante) {
        System.out.println("Resumo do Financiamento:");
        System.out.println("-------------------------");
        System.out.println("Cliente: " + nomeCliente);
        System.out.println("CPF: " + cpfCliente);
        System.out.printf("Valor Financiado: R$ %.2f\n", valorFinanciado);
        System.out.printf("Taxa de Juros Anual: %.2f%%\n", taxaJuros);
        System.out.println("Número de Parcelas: " + numParcelas);
        System.out.printf("Valor da Parcela: R$ %.2f\n", parcela);
        System.out.printf("Total de Juros Simples: R$ %.2f\n", juros);
        System.out.printf("Montante Total (Juros Simples): R$ %.2f\n", montante);
        double totalPago = parcela * numParcelas;
        System.out.printf("Total Pago após %d parcelas (juros compostos): R$ %.2f\n", numParcelas, totalPago);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Entradas do usuário
        System.out.print("Digite o nome do cliente: ");
        String nomeCliente = scanner.nextLine();

        System.out.print("Digite o CPF do cliente (somente números): ");
        String cpfCliente = scanner.nextLine();

        System.out.print("Digite o valor do financiamento: R$ ");
        double valorFinanciado = scanner.nextDouble();

        System.out.print("Digite a taxa de juros anual (%): ");
        double taxaJuros = scanner.nextDouble();

        System.out.print("Digite o número de parcelas: ");
        int numParcelas = scanner.nextInt();

        // Calculando a parcela (juros compostos)
        double parcela = calcularParcela(valorFinanciado, taxaJuros, numParcelas);

        // Calculando os juros simples e o montante total (juros simples)
        double juros = calcularJuros(valorFinanciado, taxaJuros, numParcelas);
        double montante = calcularMontante(valorFinanciado, taxaJuros, numParcelas);

        // Exibindo o resumo
        mostrarResumo(nomeCliente, cpfCliente, valorFinanciado, taxaJuros, numParcelas, parcela, juros, montante);

        scanner.close();
    }
}
[20:25, 16/05/2025] Kauan: import java.util.Scanner;

class SistemaFinanceiro {

    private double saldo;
    private String nomeCliente;
    private String cpfCliente;

    // Construtor inicializando saldo, nome e CPF
    public SistemaFinanceiro(String nomeCliente, String cpfCliente) {
        this.saldo = 0.0;
        this.nomeCliente = nomeCliente;
        this.cpfCliente = cpfCliente;
    }

    // Método para registrar receita
    public void registrarReceita(double valor) {
        if (valor > 0) {
            saldo += valor;
            System.out.println("Receita registrada: R$ " + valor);
        } else {
            System.out.println("Valor de receita inválido! O valor deve ser positivo.");
        }
    }

    // Método para registrar despesa
    public void registrarDespesa(double valor) {
        if (valor > 0) {
            saldo -= valor;
            System.out.println("Despesa registrada: R$ " + valor);
        } else {
            System.out.println("Valor de despesa inválido! O valor deve ser positivo.");
        }
    }

    // Método para exibir o saldo atual
    public void exibirSaldo() {
        System.out.printf("Saldo atual: R$ %.2f\n", saldo);
    }

    // Método para exibir o relatório completo
    public void exibirRelatorio() {
        System.out.println("Relatório Financeiro de " + nomeCliente);
        System.out.println("CPF: " + cpfCliente);
        exibirSaldo();
    }

    // Método para calcular os juros simples
    public double calcularJurosSimples(double taxaJuros, int tempo) {
        // Fórmula dos Juros Simples: J = P * i * t
        double juros = saldo * (taxaJuros / 100) * tempo;
        return juros;
    }

    // Método para calcular o montante com juros simples
    public double calcularMontante(double taxaJuros, int tempo) {
        // Fórmula do Montante com Juros Simples: M = P * (1 + i * t)
        double montante = saldo * (1 + (taxaJuros / 100) * tempo);
        return montante;
    }

    // Método para calcular os juros compostos
    public double calcularJurosCompostos(double taxaJuros, int tempo) {
        // Fórmula dos Juros Compostos: M = P * (1 + i) ^ t
        double jurosCompostos = saldo * Math.pow(1 + (taxaJuros / 100), tempo) - saldo;
        return jurosCompostos;
    }

    // Método para calcular o montante com juros compostos
    public double calcularMontanteCompostos(double taxaJuros, int tempo) {
        // Fórmula do Montante com Juros Compostos: M = P * (1 + i) ^ t
        double montanteCompostos = saldo * Math.pow(1 + (taxaJuros / 100), tempo);
        return montanteCompostos;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Entrada do nome e CPF do cliente
        System.out.print("Digite o nome do cliente: ");
        String nomeCliente = scanner.nextLine();

        System.out.print("Digite o CPF do cliente (somente números): ");
        String cpfCliente = scanner.nextLine();

        // Criando o sistema financeiro com nome e CPF
        SistemaFinanceiro sistema = new SistemaFinanceiro(nomeCliente, cpfCliente);

        int opcao;
        do {
            System.out.println("\nSistema Financeiro e Contábil");
            System.out.println("1 - Registrar Receita");
            System.out.println("2 - Registrar Despesa");
            System.out.println("3 - Exibir Saldo");
            System.out.println("4 - Exibir Relatório");
            System.out.println("5 - Calcular Juros Simples");
            System.out.println("6 - Calcular Montante com Juros Simples");
            System.out.println("7 - Calcular Juros Compostos");
            System.out.println("8 - Calcular Montante com Juros Compostos");
            System.out.println("9 - Sair");
            System.out.print("Escolha uma opção: ");

            // Validar entrada de opção
            while (!scanner.hasNextInt()) {
                System.out.println("Entrada inválida! Por favor, insira um número.");
                scanner.next(); // Descarta a entrada inválida
                System.out.print("Escolha uma opção: ");
            }
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.print("Digite o valor da receita: R$ ");
                    while (!scanner.hasNextDouble()) {
                        System.out.println("Valor inválido! Por favor, insira um número válido para a receita.");
                        scanner.next(); // Descarta a entrada inválida
                        System.out.print("Digite o valor da receita: R$ ");
                    }
                    double receita = scanner.nextDouble();
                    sistema.registrarReceita(receita);
                    break;

                case 2:
                    System.out.print("Digite o valor da despesa: R$ ");
                    while (!scanner.hasNextDouble()) {
                        System.out.println("Valor inválido! Por favor, insira um número válido para a despesa.");
                        scanner.next(); // Descarta a entrada inválida
                        System.out.print("Digite o valor da despesa: R$ ");
                    }
                    double despesa = scanner.nextDouble();
                    sistema.registrarDespesa(despesa);
                    break;

                case 3:
                    sistema.exibirSaldo();
                    break;

                case 4:
                    sistema.exibirRelatorio();
                    break;

                case 5:
                    System.out.print("Digite a taxa de juros anual (%): ");
                    double taxaJurosSimples = scanner.nextDouble();
                    System.out.print("Digite o tempo (em anos): ");
                    int tempoSimples = scanner.nextInt();
                    double jurosSimples = sistema.calcularJurosSimples(taxaJurosSimples, tempoSimples);
                    System.out.printf("Juros Simples: R$ %.2f\n", jurosSimples);
                    break;

                case 6:
                    System.out.print("Digite a taxa de juros anual (%): ");
                    double taxaJurosSimplesMontante = scanner.nextDouble();
                    System.out.print("Digite o tempo (em anos): ");
                    int tempoSimplesMontante = scanner.nextInt();
                    double montanteSimples = sistema.calcularMontante(taxaJurosSimplesMontante, tempoSimplesMontante);
                    System.out.printf("Montante com Juros Simples: R$ %.2f\n", montanteSimples);
                    break;

                case 7:
                    System.out.print("Digite a taxa de juros anual (%): ");
                    double taxaJurosCompostos = scanner.nextDouble();
                    System.out.print("Digite o tempo (em anos): ");
                    int tempoCompostos = scanner.nextInt();
                    double jurosCompostos = sistema.calcularJurosCompostos(taxaJurosCompostos, tempoCompostos);
                    System.out.printf("Juros Compostos: R$ %.2f\n", jurosCompostos);
                    break;

                case 8:
                    System.out.print("Digite a taxa de juros anual (%): ");
                    double taxaJurosCompostosMontante = scanner.nextDouble();
                    System.out.print("Digite o tempo (em anos): ");
                    int tempoCompostosMontante = scanner.nextInt();
                    double montanteCompostos = sistema.calcularMontanteCompostos(taxaJurosCompostosMontante, tempoCompostosMontante);
                    System.out.printf("Montante com Juros Compostos: R$ %.2f\n", montanteCompostos);
                    break;

                case 9:
                    System.out.println("Saindo do sistema...");
                    break;

                default:
                    System.out.println("Opção inválida! Por favor, escolha uma opção válida.");
            }

        } while (opcao != 9);

        scanner.close();
    }
}