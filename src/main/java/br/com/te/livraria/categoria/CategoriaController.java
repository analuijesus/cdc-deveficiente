package br.com.te.livraria.categoria;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;


@RestController
public class CategoriaController {

    private final CategoriaRepository categoriaRepository;

    public CategoriaController(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    @PostMapping("/cadastraCategoria")
    public ResponseEntity<Void> novo(@RequestBody @Valid CategoriaForm form) {
        Categoria categoria = form.toModel();
        categoriaRepository.save(categoria);
        return ResponseEntity.ok().build();
    }
}
