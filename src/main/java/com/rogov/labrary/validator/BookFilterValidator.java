package com.rogov.labrary.validator;

import com.rogov.labrary.dto.OptionFilter;
import org.springframework.validation.Errors;

import java.util.Objects;
import java.util.stream.Stream;

public class BookFilterValidator implements BookValidator<OptionFilter> {


    @Override
    public void check(OptionFilter target, Errors errors) {

        if (isNullObject(target)) {
            errors.reject("100", "Фильтр параметоров пуст");
        }
    }

    private boolean isNullObject(OptionFilter obj) {
        return Stream.of(obj.getAuthors(), obj.getGenres(), obj.getYearFrom(), obj.getYearTo()).allMatch(Objects::isNull);
    }
}
