import entities.Pessoa;
import entities.PessoaFisica;
import entities.PessoaJuridica;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of tax payers: ");
        int n = sc.nextInt();

        List<Pessoa> pessoa = new ArrayList<>();

        for (int i = 1; i <= n; i++){
            System.out.printf("Tax payer #%d data: \n", i);
            System.out.print("Individual or company (i/c)? ");
            char tipoPessoa = sc.next().charAt(0);
            sc.nextLine();
            System.out.print("Name: ");
            String nome = sc.nextLine();
            System.out.print("Anual income: ");
            double rendaAnual = sc.nextDouble();

            if (tipoPessoa == 'i'){
                System.out.print("Health expenditures: ");
                double gastosComSaude = sc.nextDouble();
                pessoa.add(new PessoaFisica(nome, rendaAnual, gastosComSaude));
            } else {
                System.out.print("Number of empoyees: ");
                int numeroDeFuncionarios = sc.nextInt();
                pessoa.add(new PessoaJuridica(nome, rendaAnual, numeroDeFuncionarios));
            }
        }

        double totalTaxes = 0;
        System.out.println("TAXES PAID: ");
        for(Pessoa p : pessoa){
            System.out.printf("%s: $%.2f\n", p.getNome(), p.imposto());
            totalTaxes += p.imposto();
        }

        System.out.printf("TOTAL TAXES: $%.2f", totalTaxes);

        sc.close();
    }
}