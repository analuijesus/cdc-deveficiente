package br.com.te.livraria.endereco.pais;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
public class PaisController {

    private final PaisRepository paisRepository;

    public PaisController(PaisRepository paisRepository) {
        this.paisRepository = paisRepository;
    }

    @Transactional
    @PostMapping("/cadastraPais")
    public ResponseEntity<Void> novo(@RequestBody @Valid PaisForm form) {
        Pais pais = form.toModel();
        paisRepository.save(pais);
        return ResponseEntity.ok().build();
    }
}
