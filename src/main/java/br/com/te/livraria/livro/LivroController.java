package br.com.te.livraria.livro;

import br.com.te.livraria.autor.AutorRepository;
import br.com.te.livraria.categoria.CategoriaRepository;
import br.com.te.livraria.livro.detalhesLivro.LivroDto;
import br.com.te.livraria.livro.detalhesLivro.LivroIdComTituloProjection;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class LivroController {

    private final LivroRepository livroRepository;
    private final AutorRepository autorRepository;
    private final CategoriaRepository categoriaRepository;

    public LivroController(LivroRepository livroRepository, AutorRepository autorRepository, CategoriaRepository categoriaRepository) {
        this.livroRepository = livroRepository;
        this.autorRepository = autorRepository;
        this.categoriaRepository = categoriaRepository;
    }

    @Transactional
    @PostMapping("/cadastraLivro")
    public ResponseEntity<Void> novo(@RequestBody @Valid LivroForm form) {
        Livro livro = form.toModel(categoriaRepository, autorRepository);
        livroRepository.save(livro);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/livro/{id}")
    public ResponseEntity<?> livro(@PathVariable("id") Long id) {
        return livroRepository
                .findById(id)
                .map(livro -> ResponseEntity.ok(new LivroDto(livro)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/livros")
    public List<LivroIdComTituloProjection> lista() {
        List<LivroIdComTituloProjection> livros = livroRepository.getLivroIdComTitulo();
        return livros;
    }
}
