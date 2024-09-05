package hello.itemservice.validation;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.validation.DefaultMessageCodesResolver;
import org.springframework.validation.MessageCodesResolver;

public class MessageCodesResolverTest {

    // 인터페이스 -> 여러개의 값을 반환해줌
    MessageCodesResolver codesResolver = new DefaultMessageCodesResolver();

    // 객체 오류(1순위 - code.objectName)
    @Test
    void messageCodesResolverObject() {
        String[] messageCodes = codesResolver.resolveMessageCodes("requried", "item");
        for (String messageCode : messageCodes) {
            System.out.println("messageCodes = " + messageCode);
        }
        Assertions.assertThat(messageCodes).containsExactly("requried.item", "requried");
    }

    // 필드 오류(1순위 - code.objectName.field)
    @Test
    void messageCodesResolverField() {
        String[] messageCodes = codesResolver.resolveMessageCodes("required", "item", "itemName", String.class);
        for (String messageCode : messageCodes) {
            System.out.println("messageCode = " + messageCode);
        }
        Assertions.assertThat(messageCodes).containsExactly(
                "required.item.itemName", "required.itemName", "required.java.lang.String", "required");
    }
}
