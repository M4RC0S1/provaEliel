package com.prova.ControllerProduto;

import com.prova.ModelProduto.ModelProduto;
import com.prova.ServiceProduto.ServiceProduto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping
public class ControllerProduto {

    @Autowired
    private ServiceProduto serviceProduto;

    @PostMapping
    public ResponseEntity<ModelProduto> addProduto(@RequestBody ModelProduto modelProduto) {
        ModelProduto request = serviceProduto.addProduto(modelProduto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri()
                .path("/{id}")
                .buildAndExpand(request.getId())
                .toUri();

        return ResponseEntity.created(uri).body(request);
    }

    @GetMapping
    public ResponseEntity<List<ModelProduto>> getAll() {
        List<ModelProduto> request = serviceProduto.getAll();
        return ResponseEntity.ok().body(request);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ModelProduto> getProdutoById(@PathVariable Long id) {
        ModelProduto request = serviceProduto.getProdutoById(id);
        return ResponseEntity.ok().body(request);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ModelProduto> atualizarProduto(@PathVariable Long id, @RequestBody ModelProduto novoProduto) {
        ModelProduto request = serviceProduto.atualizarProduto(id, novoProduto);
        return ResponseEntity.ok().body(request);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteProdutoById(@PathVariable Long id) {
        serviceProduto.deleteProdutoById(id);
        return ResponseEntity.noContent().build();
    }
}
