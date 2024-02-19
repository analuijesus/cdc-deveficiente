package br.com.te.livraria.endereco.estado;

import br.com.te.livraria.endereco.pais.PaisController;
import br.com.te.livraria.endereco.pais.PaisRepository;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
public class EstadoController {

    private final EstadoRepository estadoRepository;
    private final PaisRepository paisRepository;

    public EstadoController(EstadoRepository estadoRepository, PaisRepository paisRepository) {
        this.estadoRepository = estadoRepository;
        this.paisRepository = paisRepository;
    }

    @Transactional
    @PostMapping("/cadastraEstado")
    public ResponseEntity<Void> novo(@RequestBody @Valid EstadoForm form) {
        Estado estado = form.toModel(paisRepository);
        estadoRepository.save(estado);
        return ResponseEntity.ok().build();
    }
}
