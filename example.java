package example; // exemplo de Composite

import java.util.ArrayList;
import java.util.List;

interface Produto {
    double getPreco();
    String getNome();
}

class UmProduto implements Produto {
    private String nome;
    private double preco;

    public UmProduto(String nome, double preco) {
        this.nome = nome;
        this.preco = preco;
    }

    @Override
    public double getPreco() {
        return preco;
    }

    @Override
    public String getNome() {
        return nome;
    }
}

class Categoria implements Produto {
    private String nome;
    private List<Produto> Produtos = new ArrayList<>();

    public Categoria(String nome) {
        this.nome = nome;
    }

    public void addProduto(Produto Produto) {
        Produtos.add(Produto);
    }

    @Override
    public double getPreco() {
        double precoTotal = 0;
        for (Produto Produto : Produtos) {
            precoTotal += Produto.getPreco();
        }
        return precoTotal;
    }

    @Override
    public String getNome() {
        return nome;
    }
}

public class Example {
    public static void main(String[] args) {
        Produto monitor = new UmProduto("Monitor Dell", 150.0);
        Produto teclado = new UmProduto("Teclado Corsair", 50.0);

        Categoria acessorios = new Categoria("acessorios");
        acessorios.addProduto(monitor);
        acessorios.addProduto(teclado);

        Produto laptop = new UmProduto("Laptop Acer", 800.0);

        Categoria computadores = new Categoria("computadores");
        computadores.addProduto(laptop);
        computadores.addProduto(acessorios);
        
        double precoTotal = computadores.getPreco();
        System.out.println("Preço total da loja: $" + precoTotal);
    }
}

