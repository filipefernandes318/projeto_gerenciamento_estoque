package repositorio;

import estruturaProduto.Lote;
import java.util.ArrayList;
import java.util.List;

public class EstoqueRepositorio {

    private List<Lote> lotes = new ArrayList<>();

    public void adicionarLote(Lote lote) {
        lotes.add(lote);
    }

    public List<Lote> listarLotes() {
        return new ArrayList<>(lotes);
    }
}