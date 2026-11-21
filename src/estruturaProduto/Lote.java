package estruturaProduto;

import java.time.LocalDate;

public class Lote {
    private Produto produto;
    private int quantidade;
    private LocalDate dataEntrada;
    private LocalDate dataVencimento;

    public Lote() {
    }

    public Lote(Produto produto, int quantidade, LocalDate dataEntrada, LocalDate dataVencimento) {
        this.produto = produto;
        this.quantidade = quantidade;
        this.dataEntrada = dataEntrada;
        this.dataVencimento = dataVencimento;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public LocalDate getDataEntrada() {
        return dataEntrada;
    }

    public void setDataEntrada(LocalDate dataEntrada) {
        this.dataEntrada = dataEntrada;
    }

    public LocalDate getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(LocalDate dataVencimento) {
        this.dataVencimento = dataVencimento;
    }
}
