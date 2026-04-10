package com.prova.RepositoryProduto;

import com.prova.ModelProduto.ModelProduto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositoryProduto extends JpaRepository<ModelProduto, Long> {
}
