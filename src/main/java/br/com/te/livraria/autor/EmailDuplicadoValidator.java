package br.com.te.livraria.autor;


import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Optional;

@Component
public class EmailDuplicadoValidator implements Validator {

    private final AutorRepository autorRespository;

    public EmailDuplicadoValidator(AutorRepository autorRespository) {
        this.autorRespository = autorRespository;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return AutorForm.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        if (errors.hasErrors()) {
            return;
        }

        AutorForm form = (AutorForm) target;
        Optional<Autor> possivelAutor = autorRespository.findByEmail(form.email());

        if(possivelAutor.isPresent()) {
            errors.rejectValue("email", "[Erro] - Email duplicado");
        }
    }
}
