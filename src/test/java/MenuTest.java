import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class MenuTest {
    private Menu underTest = new Menu();


    @Test
    public void updatePersonTest(){
        Person update = new Person("update", "update", "update", "1234");
        Person person = new Person("miasto", "imie", "nazwisko", "1234");
        List<Person> list = new ArrayList<>();
        list.add(person);
        underTest.setPersonList(list);

        underTest.checkUpdate(update);

        assertTrue(list.get(0).getPesel().equals("1234") && list.get(0).getName().equals("update"));
    }
}
