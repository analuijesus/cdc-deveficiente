package br.com.te.livraria.autor;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;


@RestController
public class AutorController {

    private final AutorRespository autorRespository;

    public AutorController(AutorRespository autorRespository, EmailDuplicadoValidator validator) {
        this.autorRespository = autorRespository;
    }

    @PostMapping("/cadastraAutor")
    @Transactional
    public ResponseEntity novo(@RequestBody @Valid AutorForm form) {
        Autor autor = form.toModel();
        autorRespository.save(autor);
        return ResponseEntity.ok().build();
    }
}
