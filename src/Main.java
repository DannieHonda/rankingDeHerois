import java.util.function.Function;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        int vitorias = 200;
        int derrotas = 50; 

        int saldoVitorias = vitorias - derrotas;

        String nivel = calcularNivel.apply(saldoVitorias);

        System.out.println("O Herói tem saldo de " + saldoVitorias + " está no nível de " + nivel);
    }

    private static Function<Integer, String> calcularNivel = saldo -> Stream.of(
                    new Nivel("Ferro", vitorias -> vitorias < 10),
                    new Nivel("Bronze", vitorias -> vitorias >= 11 && vitorias <= 20),
                    new Nivel("Prata", vitorias -> vitorias >= 21 && vitorias <= 50),
                    new Nivel("Ouro", vitorias -> vitorias >= 51 && vitorias <= 80),
                    new Nivel("Diamante", vitorias -> vitorias >= 81 && vitorias <= 90),
                    new Nivel("Lendário", vitorias -> vitorias >= 91 && vitorias <= 100),
                    new Nivel("Imortal", vitorias -> vitorias >= 101)
            )
            .filter(nivel -> nivel.getCondicao().apply(saldo))
            .findFirst()
            .map(Nivel::getNome)
            .orElse("Desconhecido");
}

class Nivel {
    private String nome;
    private Function<Integer, Boolean> condicao;

    public Nivel(String nome, Function<Integer, Boolean> condicao) {
        this.nome = nome;
        this.condicao = condicao;
    }

    public String getNome() {
        return nome;
    }

    public Function<Integer, Boolean> getCondicao() {
        return condicao;
    }
}
