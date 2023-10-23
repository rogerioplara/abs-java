package entities;

public class PessoaFisica extends Pessoa{

    private Double gastosComSaude;

    public PessoaFisica() {
        super();
    }

    public PessoaFisica(String nome, Double rendaAnual, Double gastosComSaude) {
        super(nome, rendaAnual);
        this.gastosComSaude = gastosComSaude;
    }

    public Double getGastosComSaude() {
        return gastosComSaude;
    }

    public void setGastosComSaude(Double gastosComSaude) {
        this.gastosComSaude = gastosComSaude;
    }

    @Override
    public Double imposto() {

        double impostoSobreRenda = (getRendaAnual() < 2000) ? getRendaAnual() * 0.15 : getRendaAnual() * 0.25;
        if (gastosComSaude > 0) {
            impostoSobreRenda -= gastosComSaude / 2;
        }

        return impostoSobreRenda;
    }
}
