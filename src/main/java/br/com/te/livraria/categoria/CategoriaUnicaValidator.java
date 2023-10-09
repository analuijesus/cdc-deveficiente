package br.com.te.livraria.categoria;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Optional;

@Component
public class CategoriaUnicaValidator implements Validator {

    private final CategoriaRepository categoriaRepository;

    public CategoriaUnicaValidator(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return CategoriaForm.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        if (errors.hasErrors()) {
            return;
        }

        CategoriaForm form = (CategoriaForm) target;
        Optional<Categoria> possivelCategoria = categoriaRepository.findByNome(form.getNome());

    }
}
