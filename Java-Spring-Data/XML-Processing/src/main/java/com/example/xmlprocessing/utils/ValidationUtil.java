package com.example.xmlprocessing.utils;

import javax.validation.ConstraintViolation;
import java.util.Set;

public interface ValidationUtil {

    <E> boolean isValid(E entity);

}

