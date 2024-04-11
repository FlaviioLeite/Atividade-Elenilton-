package com.fag.V1;

public class Funcionario {
	private String nome;
    private String cpf;
    private String cargo;
    private double salarioBase;
    private int horasExtras;
    private boolean trabalhaNoturno;
    private boolean insalubre;
    private int numeroDependentes;

    
    private static final double FGTS_TAXA = 0.08; // 8%
    private static final double INSS_TAXA = 0.11; // 11%, 
    private static final double IRRF_FAIXA_1 = 0.075; // 7.5%, 
    private static final double VALE_TRANSPORTE_TAXA = 0.06; // 6%
    private static final double VALE_ALIMENTACAO_TAXA = 0.1; // 10%, 

    
    private static final double HORA_EXTRA_TAXA = 1.5; // 50% 
    private static final double ADICIONAL_NOTURNO_TAXA = 0.2; // 20%
    private static final double ADICIONAL_INSALUBRIDADE = 200; // Valor 
    private static final double SALARIO_FAMILIA_POR_DEPENDENTE = 50; 

    
    public Funcionario(String nome, String cpf, String cargo, double salarioBase, int horasExtras, boolean trabalhaNoturno, boolean insalubre, int numeroDependentes) {
        this.nome = nome;
        this.cpf = cpf;
        this.cargo = cargo;
        this.salarioBase = salarioBase;
        this.horasExtras = horasExtras;
        this.trabalhaNoturno = trabalhaNoturno;
        this.insalubre = insalubre;
        this.numeroDependentes = numeroDependentes;
    }

   
    public double calcularFGTS() {
        return salarioBase * FGTS_TAXA;
    }

    public double calcularINSS() {
        return salarioBase * INSS_TAXA;
    }

    public double calcularIRRF() {
        double baseCalculo = salarioBase - calcularINSS();
        return baseCalculo * IRRF_FAIXA_1;
    }

    public double calcularValeTransporte() {
        return salarioBase * VALE_TRANSPORTE_TAXA;
    }

    public double calcularValeAlimentacao() {
        return salarioBase * VALE_ALIMENTACAO_TAXA;
    }

    public double calcularTotalDescontos() {
        return calcularINSS() + calcularIRRF() + calcularValeTransporte() + calcularValeAlimentacao();
    }

    
    public double calcularHorasExtras(double valorHora) {
        return horasExtras * valorHora * HORA_EXTRA_TAXA;
    }

    public double calcularAdicionalNoturno(double valorHora) {
        return trabalhaNoturno ? salarioBase * ADICIONAL_NOTURNO_TAXA : 0;
    }

    public double calcularAdicionalInsalubridade() {
        return insalubre ? ADICIONAL_INSALUBRIDADE : 0;
    }

    public double calcularSalarioFamilia() {
        return numeroDependentes * SALARIO_FAMILIA_POR_DEPENDENTE;
    }

    public double calcularTotalBeneficios(double valorHora) {
        return calcularHorasExtras(valorHora) + calcularAdicionalNoturno(valorHora) + calcularAdicionalInsalubridade() + calcularSalarioFamilia();
    }

    
    public double calcularSalarioLiquido(double valorHora) {
        return salarioBase - calcularTotalDescontos() + calcularTotalBeneficios(valorHora);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public double getSalarioBase() {
        return salarioBase;
    }

    public void setSalarioBase(double salarioBase) {
        this.salarioBase = salarioBase;
    }

    public int getHorasExtras() {
        return horasExtras;
    }

    public void setHorasExtras(int horasExtras) {
        this.horasExtras = horasExtras;
    }

    public boolean isTrabalhaNoturno() {
        return trabalhaNoturno;
    }

    public void setTrabalhaNoturno(boolean trabalhaNoturno) {
        this.trabalhaNoturno = trabalhaNoturno;
    }

    public boolean isInsalubre() {
        return insalubre;
    }

    public void setInsalubre(boolean insalubre) {
        this.insalubre = insalubre;
    }

    public int getNumeroDependentes() {
        return numeroDependentes;
    }

    public void setNumeroDependentes(int numeroDependentes) {
        this.numeroDependentes = numeroDependentes;
    }

    public static double getFgtsTaxa() {
        return FGTS_TAXA;
    }

    public static double getInssTaxa() {
        return INSS_TAXA;
    }

    public static double getIrrfFaixa1() {
        return IRRF_FAIXA_1;
    }

    public static double getValeTransporteTaxa() {
        return VALE_TRANSPORTE_TAXA;
    }

    public static double getValeAlimentacaoTaxa() {
        return VALE_ALIMENTACAO_TAXA;
    }

    public static double getHoraExtraTaxa() {
        return HORA_EXTRA_TAXA;
    }

    public static double getAdicionalNoturnoTaxa() {
        return ADICIONAL_NOTURNO_TAXA;
    }

    public static double getAdicionalInsalubridade() {
        return ADICIONAL_INSALUBRIDADE;
    }

    public static double getSalarioFamiliaPorDependente() {
        return SALARIO_FAMILIA_POR_DEPENDENTE;
    }
}
