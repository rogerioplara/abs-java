package entities;

public class PessoaJuridica extends Pessoa {

    public Integer numeroDeFuncionarios;

    public PessoaJuridica() {
        super();
    }

    public PessoaJuridica(String nome, Double rendaAnual, Integer numeroDeFuncionarios) {
        super(nome, rendaAnual);
        this.numeroDeFuncionarios = numeroDeFuncionarios;
    }

    public Integer getNumeroDeFuncionarios() {
        return numeroDeFuncionarios;
    }

    public void setNumeroDeFuncionarios(Integer numeroDeFuncionarios) {
        this.numeroDeFuncionarios = numeroDeFuncionarios;
    }

    @Override
    public Double imposto() {
        double impostoSobreRenda = 0;

        if (numeroDeFuncionarios <= 10) {
            impostoSobreRenda = getRendaAnual() * 0.16;
        } else {
            impostoSobreRenda = getRendaAnual() * 0.14;
        }

        return impostoSobreRenda;
    }
}
