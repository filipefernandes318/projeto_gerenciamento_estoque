package funcoes;
import estruturaProduto.Produto;
import estruturaProduto.Lote;
import repositorio.EstoqueRepositorio;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class EstoqueFuncoes {
    private EstoqueRepositorio repositorio;

    public EstoqueFuncoes() {
        this.repositorio = new EstoqueRepositorio();
    }
    public void registrarEntrada(
            Produto produto,
            int quantidade,
            LocalDate dataEntrada,
            LocalDate dataVencimento) {

        if (produto == null) {
            throw new IllegalArgumentException("O produto não pode ser nulo.");
        }

        if (quantidade <= 0) {
            throw new IllegalArgumentException("A quantidade deve ser maior que zero.");
        }

        if (dataEntrada == null) {
            throw new IllegalArgumentException("A data de entrada é obrigatória.");
        }

        if (dataVencimento == null) {
            throw new IllegalArgumentException("A data de vencimento é obrigatória.");
        }

        if (dataEntrada.isAfter(LocalDate.now())) {
            throw new IllegalArgumentException("A data de entrada não pode ser futura.");
        }

        if (dataVencimento.isBefore(dataEntrada)) {
            throw new IllegalArgumentException("O vencimento não pode ser anterior à entrada.");
        }

        Lote lote = new Lote(
                produto,
                quantidade,
                dataEntrada,
                dataVencimento
        );

        repositorio.adicionarLote(lote);
    }
    public List<Lote> listarProximosVencimento() {

        List<Lote> proximosVencimentos = new ArrayList<>();

        LocalDate hoje = LocalDate.now();
        LocalDate limite = hoje.plusDays(30);

        for (Lote lote : repositorio.listarLotes()) {

            LocalDate vencimento = lote.getDataVencimento();

            if (!vencimento.isBefore(hoje) && !vencimento.isAfter(limite)) {
                proximosVencimentos.add(lote);
            }
        }

        return proximosVencimentos;
    }
}