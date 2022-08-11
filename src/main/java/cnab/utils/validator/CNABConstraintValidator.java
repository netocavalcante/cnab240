package cnab.utils.validator;

import cnab.exceptions.ContentMoreThan240CharactersException;

import static cnab.utils.Constants.MAX_CHARACTER_PER_LINE;

public final class CNABConstraintValidator {

    private CNABConstraintValidator() {
    }

    public static void validateLineMaxLength(String line, String component) throws ContentMoreThan240CharactersException {
        if (line.length() > MAX_CHARACTER_PER_LINE) {
            throw new ContentMoreThan240CharactersException("The " + component + " must have less than 240 charactes : " + line );
        }
    }
}
