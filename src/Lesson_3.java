import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Lesson_3 {

    public static Scanner sc = new Scanner(System.in);
    final static Random random = new Random();

    public static int getNumberFromScanner(String message, int min, int max) {
        int x;
        do {
            System.out.println(message);
            x = sc.nextInt();
        } while (x < min || x > max);
        return x;
    }

    /*
    1. Написать программу, которая загадывает случайное число от 0 до 9,
    и пользователю дается 3 попытки угадать это число.
    При каждой попытке компьютер должен сообщить больше ли указанное пользователем число
     чем загаданное, или меньше. После победы или проигрыша выводится запрос
      – «Повторить игру еще раз? 1 – да / 0 – нет»(1 – повторить, 0 – нет).
      */
    public static void guessTheNumber() {

        int num = random.nextInt(10);

        for (int i = 1; i <= 3; i++) {
            System.out.println("У Вас три попытки. Попытка № " + i);
            int inputNum = getNumberFromScanner("Введите число от 0 до 9",0,9);

            if (inputNum == num) {
                System.out.print("Вы выиграли!");
                break;
            } else if (inputNum > num) {
                System.out.println("Загаданное число меньше");
            } else {
                System.out.println("Загаданное число больше");
            }

            if (i == 3 && inputNum != num) System.out.print("Вы проиграли.");
        }

        int a = getNumberFromScanner(" Повторить игру еще раз? 1 - да / 0 - нет",0,1);
        switch (a) {
            case 0: break;
            case 1: guessTheNumber();
        }
    }

    /*
    2 * Создать массив из слов
    String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado",
                    "broccoli", "carrot", "cherry", "garlic", "grape", "melon", "leak",
                    "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut", "pear",
                    "pepper", "pineapple", "pumpkin", "potato"};
    При запуске программы компьютер загадывает слово, запрашивает ответ у пользователя,
    сравнивает его с загаданным словом и сообщает правильно ли ответил пользователь.
     Если слово не угадано, компьютер показывает буквы которые стоят на своих местах.
    apple – загаданное
    apricot - ответ игрока
    ap############# (15 символов, чтобы пользователь не мог узнать длину слова)
    Для сравнения двух слов посимвольно, можно пользоваться:
    String str = "apple";
    str.charAt(0); - метод, вернет char, который стоит в слове str на первой позиции
    Играем до тех пор, пока игрок не отгадает слово
    Используем только маленькие буквы
         */
    public static void guessTheWord() {
        String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado",
                "broccoli", "carrot", "cherry", "garlic", "grape", "melon", "leak",
                "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut", "pear",
                "pepper", "pineapple", "pumpkin", "potato"};
        String guess = null;
        String word = words[random.nextInt(words.length)];
        System.out.println(Arrays.toString(words));
        do {
            System.out.print("Угадай слово: ");
            guess = sc.next();
            for (int i = 0; i < 15; i++)
                if (i < word.length() && i < guess.length() &&
                        word.charAt(i) == guess.charAt(i))
                    System.out.print(word.charAt(i));
                else
                    System.out.print((word.equals(guess))? "" : "#");
            System.out.println();
        } while (!word.equals(guess));
        System.out.println("Вы выиграли!");
    }

    //Выбор игры
    public static void choiceTheGame(){
        int choice = getNumberFromScanner("Выбери игру:\n1. Угадать число\n2. Угадать слово\n3. Выход",1,3);
        switch (choice) {
            case 1: {
                guessTheNumber();
                choiceTheGame();
            }
            case 2: {
                guessTheWord();
                choiceTheGame();
            }
            case 3: break;
        }

    }


    public static void main(String[] args) {

        choiceTheGame();
        sc.close();
    }
}
