package Lesson_5;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Person[] persArray = new Person[5];

        persArray[0] = new Person("Ivanov Ivan", "Engineer", "ivivan@mail.ru", "89231231213", 30000, 30);
        persArray[1] = new Person("Petrov Dmitry","Lawyer", "petrovdm@gmail.com", "89167521726", 45000, 55);
        persArray[2] = new Person("Sivakov Alexey","Project Manager", "sivakov@yandex.ru", "89214125632", 50000, 32);
        persArray[3] = new Person("Vlasov Sergey", "Team Lead", "vlasovserg@inbox.ru","89452202020", 50000,29);
        persArray[4] = new Person("Malinov Vladimir","CEO","malvlad@mail.ru", "89123214521",70000,42);

        for (int i = 0; i < persArray.length; i++) {
            int age = persArray[i].getAge();
            if (age >= 40) {
                persArray[i].info();
            }
        }
    }
}
