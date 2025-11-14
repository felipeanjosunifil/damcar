package github.lipenathan.demo.model.service;

import github.lipenathan.demo.model.entity.Produto;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProdutoService {

    private int id = 0;
    private List<Produto> produtos = new ArrayList<>();

    public Boolean novoProduto(Produto produto) {
        produto.setId(++id);
        produtos.add(produto);
        return true;
    }

    @GetMapping
    public List<Produto> getProdutos() {
        return produtos;
    }

    /**
     * Mét0do que busca um produto por id
     * @param id do produto
     * @return Produto buscado
     * @throws Exception quando o id específicado não existe.
     */
    public Produto getProdutoPorId(int id) throws Exception {
        Produto produto = null;

        for (Produto p : produtos) {
            if (p.getId() == id) {
                produto = p;
            }
        }

        if (produto != null) {
            return produto;
        } else {
            throw new Exception("Produto não encontrado");
        }
    }

    public List<Produto> consultarProdutos(String nome, double valorMaximo) {
        List<Produto> produtosEncontrados = new ArrayList<>();
        double valorBuscar = 1000000.0;

        if (valorMaximo > 1) {
            valorBuscar = valorMaximo;
        }

        for (Produto p: produtos) {
            if (p.getNome().toLowerCase().contains(nome.toLowerCase()) && p.getPreco() <= valorBuscar) {
                produtosEncontrados.add(p);
            }
        }

        return produtosEncontrados;
    }

    public Boolean apagarProduto(int id) throws Exception {

        Boolean removido = produtos.removeIf(produto -> produto.getId() == id);//forma reduzida para remover item

        if (removido) {
            return removido;
        } else {
            throw new Exception("Produto não existe");
        }
    }
}
