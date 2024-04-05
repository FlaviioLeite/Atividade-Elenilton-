import java.util.Scanner;


public class FolhaPagamentoApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Captura de dados do empregador 
        System.out.println("Digite o nome do empregador:");
        String nomeEmpregador = scanner.nextLine();
        System.out.println("Digite o CNPJ do empregador:");
        String cnpj = scanner.nextLine();
        
       

        // Captura de dados do funcionário
        System.out.println("Digite o nome do funcionário:");
        String nomeFuncionario = scanner.nextLine();
        System.out.println("Digite o CPF do funcionário:");
        String cpf = scanner.nextLine();
        System.out.println("Digite o cargo do funcionário:");
        String cargo = scanner.nextLine();
        System.out.println("Digite o salário base do funcionário:");
        double salarioBase = Double.parseDouble(scanner.nextLine());
        System.out.println("Digite o número de horas extras:");
        int horasExtras = Integer.parseInt(scanner.nextLine());
        System.out.println("O funcionário trabalha à noite? (true/false):");
        boolean trabalhaNoturno = Boolean.parseBoolean(scanner.nextLine());
        System.out.println("O ambiente de trabalho é insalubre? (true/false):");
        boolean insalubre = Boolean.parseBoolean(scanner.nextLine());
        System.out.println("Número de dependentes para salário família:");
        int numeroDependentes = Integer.parseInt(scanner.nextLine());

        // Criação do objeto Funcionario com os dados capturados
        Funcionario funcionario = new Funcionario(
                nomeFuncionario,
                cpf,
                cargo,
                salarioBase,
                horasExtras,
                trabalhaNoturno,
                insalubre,
                numeroDependentes);

        double valorHora = salarioBase / 160; // Considerando 160 horas no mês para cálculo do valor hora

        // Exibindo os cálculos
        System.out.println("Descontos:");
        System.out.println("FGTS: R$ " + funcionario.calcularFGTS());
        System.out.println("INSS: R$ " + funcionario.calcularINSS());
        System.out.println("IRRF: R$ " + funcionario.calcularIRRF());
        System.out.println("Vale Transporte: R$ " + funcionario.calcularValeTransporte());
        System.out.println("Vale Alimentação: R$ " + funcionario.calcularValeAlimentacao());
        System.out.println("Total de Descontos: R$ " + funcionario.calcularTotalDescontos());
        System.out.println("\nBenefícios:");
        System.out.println("Horas Extras: R$ " + funcionario.calcularHorasExtras(valorHora));
        System.out.println("Adicional Noturno: R$ " + funcionario.calcularAdicionalNoturno(valorHora));
        System.out.println("Adicional de Insalubridade: R$ " + funcionario.calcularAdicionalInsalubridade());
        System.out.println("Salário Família: R$ " + funcionario.calcularSalarioFamilia());
        System.out.println("Total de Benefícios: R$ " + funcionario.calcularTotalBeneficios(valorHora));
        System.out.println("\nSalário Líquido: R$ " + funcionario.calcularSalarioLiquido(valorHora));

        scanner.close();
    }
}
