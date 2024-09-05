package hello.itemservice.validation;

import hello.itemservice.domain.item.Item;
import org.junit.jupiter.api.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

public class BeanValidationTest {

    //외울 필요 없음
    @Test
    void beanValidation() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();

        Item item = new Item();
        item.setItemName("  "); // 공백
        item.setPrice(0);
        item.setQuantity(10000);

        Set<ConstraintViolation<Item>> constraintViolations = validator.validate(item);
        for (ConstraintViolation<Item> constraintViolation : constraintViolations) {
            System.out.println("constraintViolation = " + constraintViolation);
            System.out.println("constraintViolation.getMessage() = " + constraintViolation.getMessage());
        }

    }
}
