package cnab.batch.segment;

import cnab.exceptions.ContentMoreThan240CharactersException;
import cnab.utils.validator.CNABConstraintValidator;

public interface SegmentBuilder {
    default void validate(String contet, Class exceptionClass) throws ContentMoreThan240CharactersException {
        CNABConstraintValidator.validateLineMaxLength(contet, exceptionClass.getName());
    }
}
