import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


class PeselValidatorTest {

    private PeselValidator underTest = new PeselValidator();

    @Test
    public void validatorTest(){
        String peselOk = "66092254785"; // valid
        String peselBad = "66092254784"; // nonValid

        assertTrue(underTest.validate(peselOk));
        assertFalse(underTest.validate(peselBad));
    }
}