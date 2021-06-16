import com.google.gson.Gson;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

@NoArgsConstructor
@Getter
@Setter
public class Menu {
    private List<Person> personList = new ArrayList<>();
    private PeselValidator validator = new PeselValidator();
    private DataSaver saver = new DataSaver();



    public void menu(){
        Scanner scanner = new Scanner(System.in);

        int mode = 1;
        while(mode != 0){
            System.out.println("Co chcesz zrobic?");
            System.out.println("1 - dodaj osobę ");
            System.out.println("2 - pokaz liste osob do zapisania");
            System.out.println("0 - zapisz i wyjdz");
            mode = scanner.nextInt();

            if(mode == 1)
                this.addPerson();
            else if (mode == 2)
                this.showList();
        }
    }

    public Person getPersonData(){
        Scanner scanner = new Scanner(System.in);

        Person person = new Person();

        System.out.println("podaj miasto:");
        person.setCity(scanner.nextLine());

        System.out.println("podaj imię, nazwisko oraz pesel (oddzielone spacjami):");
        String data[] = scanner.nextLine().split(" ");

        person.setName(data[0]);
        person.setSurName(data[1]);
        person.setPesel(data[2]);

        return person;
    }

    public void addPerson(){
        Person person = getPersonData();

        if(!validator.validate(person.getPesel())){
            System.out.println("podano błędny PESEL");
            return;
        }

        checkUpdate(person);

        personList.add(person);
    }

    public void checkUpdate(Person person) {
        for(Person p : personList){
            if(p.getPesel().equals(person.getPesel())){
                personList.remove(p);
                personList.add(person);
                return;
            }
        }
    }

    private void showList() {
        System.out.println("oto lista osob do zapisania");
        for(Person p : personList){
            System.out.println(new Gson().toJson(p));
        }
    }

    public void test(){
        Person person = new Person("Poznan", "Imie", "Nazwisko",  "21372137213");
        List<Person> dataToSave = new ArrayList<>();
        dataToSave.add(person);

        DataSaver saver = new DataSaver();

        try {
            saver.saveData(dataToSave);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
