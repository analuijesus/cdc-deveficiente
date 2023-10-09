package br.com.te.livraria.categoria;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;


@RestController
public class CategoriaController {

    private final CategoriaRepository categoriaRepository;
    private final CategoriaUnicaValidator validator;

    public CategoriaController(CategoriaRepository categoriaRepository, CategoriaUnicaValidator validator) {
        this.categoriaRepository = categoriaRepository;
        this.validator = validator;
    }

//    @InitBinder
//    public void initBinder(WebDataBinder dataBinder) {
//        dataBinder.addValidators(validator);
//    }

    @PostMapping("/cadastraCategoria")
    public ResponseEntity novo(@RequestBody @Valid CategoriaForm form) {
        Categoria categoria = form.toModel();
        categoriaRepository.save(categoria);
        return ResponseEntity.ok().build();
    }
}
