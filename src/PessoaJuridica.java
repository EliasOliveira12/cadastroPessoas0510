

public class PessoaJuridica extends Pessoa {
    public String CNPJ;
    public String RazaoSocial;

    public float CaucularImposto(float rendimentos) {
        if (rendimentos <= 1500) {
            return 0;

        } else if (rendimentos > 1500 && rendimentos <= 3500) {
            float resultado = (rendimentos / 100) * 5;
            return resultado;
        } else if (rendimentos > 3500 && rendimentos <= 6000) {
            float resultado = (rendimentos / 100) * 7;
            return resultado;
        } else {
            float resultado = (rendimentos / 100) * 9;
            return resultado;
        }


    }

}

