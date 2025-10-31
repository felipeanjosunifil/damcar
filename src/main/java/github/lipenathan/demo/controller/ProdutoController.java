package github.lipenathan.demo.controller;

import github.lipenathan.demo.model.Produto;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    private int id = 0;
    private List<Produto> produtos = new ArrayList<>();

    @PostMapping("/novo")
    public boolean novoProduto(@RequestBody Produto produto) {
        produto.setId(++id);
        produtos.add(produto);
        return true;
    }

    @GetMapping
    public List<Produto> getProdutos() {
        return produtos;
    }

    @GetMapping("/{id}")
    public Produto getProdutoPorId(@PathVariable("id") int id) {
        Produto produto = null;

        for (Produto p : produtos) {
            if (p.getId() == id) {
                produto = p;
            }
        }

        return produto;
    }

    @GetMapping("/buscar")
    public List<Produto> consultarProdutos(@RequestParam("nome") String nome, @RequestParam(value = "valorMaximo", required = false) double valorMaximo) {
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

    @DeleteMapping("/apagar/{id}")
    public boolean apagarProduto(@PathVariable("id") int id) {
        int deletar = 0;
        int index = -1;

        for (Produto p : produtos) {
            index++;
            if (p.getId() == id) {
                deletar = index;
            }
        }

        produtos.remove(deletar);

//        produtos.removeIf(p -> p.getId() == id);//forma reduzida para remover idem

        return true;
    }
}
