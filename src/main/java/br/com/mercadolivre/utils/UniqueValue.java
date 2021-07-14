package br.com.mercadolivre.utils;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = {UniqueValueValidator.class})
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface UniqueValue {

    //mensagem especifica da bean validation
    String message() default "Não foi possível efetuar sua solicitação, campo já cadastrado em sistema!";
    //serve para validaçãpo de grupos especificos
    Class<?>[] groups() default { };
    //caso eu precise mandar uma informação a mais no momento da requisição
    Class<? extends Payload> [] payload() default { };
    String fieldName();
    Class<?> domainClass();
}

