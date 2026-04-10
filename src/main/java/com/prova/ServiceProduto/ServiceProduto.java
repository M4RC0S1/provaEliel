package com.prova.ServiceProduto;

import com.prova.ModelProduto.ModelProduto;
import com.prova.RepositoryProduto.RepositoryProduto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceProduto {

    @Autowired
    private RepositoryProduto repositoryProduto;

    public ModelProduto addProduto(ModelProduto produtoModel) {
        return repositoryProduto.save(produtoModel);
    }

    public List<ModelProduto> getAll() {
        return repositoryProduto.findAll();
    }

    public ModelProduto getProdutoById(Long id) {
        return repositoryProduto.findById(id).get();
    }

    public ModelProduto atualizarProduto(Long id, ModelProduto novoProduto) {
        ModelProduto produtoExistente = repositoryProduto.findById(id).get();

        produtoExistente.setNome(novoProduto.getNome());
        produtoExistente.setDescricao(novoProduto.getDescricao());
        produtoExistente.setPreco(novoProduto.getPreco());
        produtoExistente.setStatus(novoProduto.getStatus());

        return repositoryProduto.save(produtoExistente);
    }

    public void deleteProdutoById(Long id) {
        repositoryProduto.deleteById(id);
    }
}