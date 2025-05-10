package br.com.fiap.tds.brinquedos_crud.controller;

import br.com.fiap.tds.brinquedos_crud.model.Brinquedo;
import br.com.fiap.tds.brinquedos_crud.repository.BrinquedoRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/brinquedos")
public class BrinquedoController {

    private final BrinquedoRepository repo;
    public BrinquedoController(BrinquedoRepository repo) { this.repo = repo; }

    @GetMapping
    public List<Brinquedo> listar() { return repo.findAll(); }

    @GetMapping("/{id}")
    public ResponseEntity<Brinquedo> buscar(@PathVariable Long id) {
        Optional<Brinquedo> b = repo.findById(id);
        return b.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Brinquedo> criar(@RequestBody Brinquedo brinquedo) {
        Brinquedo salvo = repo.save(brinquedo);
        return ResponseEntity.status(201).body(salvo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Brinquedo> atualizar(
            @PathVariable Long id, @RequestBody Brinquedo brinquedo) {
        return repo.findById(id)
                .map(ex -> {
                    ex.setNome(brinquedo.getNome());
                    ex.setDescricao(brinquedo.getDescricao());
                    ex.setIdadeMaxima(brinquedo.getIdadeMaxima());
                    repo.save(ex);
                    return ResponseEntity.ok(ex);
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        return repo.findById(id)
                .map(ex -> {
                    repo.deleteById(id);
                    return ResponseEntity.noContent().<Void>build();
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
