import java.util.ArrayList;
import java.util.List;

public class Main {
    private static final int TAMANHO_MAXIMO_CACHE = 10;

    public static void main(String[] args) {
        List<Pessoa> banco = new ArrayList<>();
        banco.add(new Pessoa(1, "João", 16));
        banco.add(new Pessoa(2, "Jonata", 17));
        banco.add(new Pessoa(3, "Carlos", 14));
        banco.add(new Pessoa(4, "Matheus", 16));
        banco.add(new Pessoa(5, "Eduardo", 18));


        List<Pessoa> cache = new ArrayList<>();


        int[] idsParaBuscar = {1, 2, 1, 3, 6};

        for (int idBuscado : idsParaBuscar) {

            Pessoa pessoaEncontrada = buscarPorId(cache, idBuscado);

            if (pessoaEncontrada != null) {
                IO.println("Pessoa encontrada no cache: " + pessoaEncontrada);
            } else {

                pessoaEncontrada = buscarPorId(banco, idBuscado);

                if (pessoaEncontrada != null) {
                    if (cache.size() >= TAMANHO_MAXIMO_CACHE) {
                        Pessoa removida = cache.remove(0);
                        IO.println(("Cache cheio! Removendo pessoa mais antiga: " + removida.getNome()));
                    }


                    cache.add(pessoaEncontrada);
                    IO.println("Pessoa buscada no banco e adicionada ao cache: " + pessoaEncontrada);
                } else {
                    IO.println("Pessoa com ID " + idBuscado + " não foi encontrada no banco de dados.");
                }
            }
        }
    }

    private static Pessoa buscarPorId(List<Pessoa> lista, int id) {
        for (Pessoa p : lista) {
            if (p.getId() == id) {
                return p;
            }
        }
        return null;
    }
}