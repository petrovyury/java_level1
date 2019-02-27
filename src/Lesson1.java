import java.util.Scanner;

public class Lesson1 {
    // 1. Создаем метод main
    public static void main(String[] args) {

        //2. Создаем и объявляем переменные пройденных типов
        byte by = 12;
        short sh = 179;
        int in = 56;
        long lo = 17981000000000L;
        float fl = 196.15f;
        double dou = 37.78;
        boolean bool = true;
        char ch = '\42';
        String str = "The First Home Work";

        //Выводим метод из пункта 3
        System.out.print("Для пункта 3 задайте 4 числа через пробел: ");
        Scanner scanner = new Scanner(System.in);
        int a, b, c, d;
        a = scanner.nextInt();
        b = scanner.nextInt();
        c = scanner.nextInt();
        d = scanner.nextInt();
        System.out.println("Задание 3: " + methodThree(a, b, c, d));

        //Выводим значение из пункта 4
        System.out.print("Для пункта 4 задайте 2 числа через пробел: ");
        a = scanner.nextInt();
        b = scanner.nextInt();
        System.out.println(methodFour((int)a, (int)b));

        //Выполняем задание из пункта 5
        System.out.print("Введите число для задания 5: ");
        a = scanner.nextInt();
        System.out.println("Введенное " + methodFive(a));

        //Выводим значение из пункта 6
        System.out.print("Введите число для задания 6: ");
        a = scanner.nextInt();
        System.out.println(methodSix(a));

        //Вводим имя для пункта 7
        System.out.print("Введите имя для задания 7: ");
        String name = scanner.next();
        methodSeven(name);

        //Выполняем пункт 8
        System.out.print("Введите год для выполнения пункта 8: ");
        int year = scanner.nextInt();
        methodEight(year);



    }
    //3. Пишем метод из пункта 3
    public static int methodThree (int a, int b, int c, int d) {
        return a * (b + (c / d));
    }

    //4. Пишем метод из пункта 4
    public static boolean methodFour (int a, int b){

        return  (a + b) >= 10 && (a + b) <= 20;
    }

    //5. Пишем метод из пункта 5
    public static String methodFive (int a) {

        return (a >= 0) ? "число положительное" : "число отрицательное";
    }

    //6. Пишем метод из задания 6
    public static boolean methodSix (int a) {

        return a < 0;
    }

    //7. Пишем метод 7
    public static void methodSeven (String name) {

        System.out.println("Привет, " + name + "!");
    }

    //8. Метод для 8 пункта
    public static void methodEight (int year) {

        if (year % 4 != 0 || year % 100 == 0 && year % 400 != 0) {
            System.out.println("Этот год не високосный");
        } else System.out.println("Этот год високосный");
    }




}
