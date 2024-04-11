package com.fag.V1;

import java.io.FileOutputStream;
import java.util.Scanner;

import com.itextpdf.io.IOException;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;

public class FolhaPagamentoApp {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);

            
            System.out.println("Digite o nome do empregador:");
            String nomeEmpregador = scanner.nextLine();
            System.out.println("Digite o CNPJ do empregador:");
            String cnpj = scanner.nextLine();

            
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

            Funcionario funcionario = new Funcionario(nomeFuncionario, cpf, cargo, salarioBase, horasExtras,
                    trabalhaNoturno, insalubre, numeroDependentes);

            double valorHora = salarioBase / 160; 

            
            String outputPdf = "respostas.pdf";
            PdfDocument pdfDoc = new PdfDocument(new PdfWriter(outputPdf));
            Document doc = new Document(pdfDoc);

            
            doc.add(new Paragraph("Respostas da Folha de Pagamento"));
            doc.add(new Paragraph("Descontos:"));
            doc.add(new Paragraph("FGTS: R$ " + funcionario.calcularFGTS()));
            doc.add(new Paragraph("INSS: R$ " + funcionario.calcularINSS()));
            doc.add(new Paragraph("IRRF: R$ " + funcionario.calcularIRRF()));
            doc.add(new Paragraph("Vale Transporte: R$ " + funcionario.calcularValeTransporte()));
            doc.add(new Paragraph("Vale Alimentação: R$ " + funcionario.calcularValeAlimentacao()));
            doc.add(new Paragraph("Total de Descontos: R$ " + funcionario.calcularTotalDescontos()));
            doc.add(new Paragraph("\nBenefícios:"));
            doc.add(new Paragraph("Horas Extras: R$ " + funcionario.calcularHorasExtras(valorHora)));
            doc.add(new Paragraph("Adicional Noturno: R$ " + funcionario.calcularAdicionalNoturno(valorHora)));
            doc.add(new Paragraph("Adicional de Insalubridade: R$ " + funcionario.calcularAdicionalInsalubridade()));
            doc.add(new Paragraph("Salário Família: R$ " + funcionario.calcularSalarioFamilia()));
            doc.add(new Paragraph("Total de Benefícios: R$ " + funcionario.calcularTotalBeneficios(valorHora)));
            doc.add(new Paragraph("\nSalário Líquido: R$ " + funcionario.calcularSalarioLiquido(valorHora)));

            
            doc.close();

            
            System.out.println("Respostas salvas em " + outputPdf);

            scanner.close();
        } catch (IOException | java.io.IOException e) {
            e.printStackTrace();
        }
    }
}
