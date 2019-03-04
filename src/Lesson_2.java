import java.util.Arrays;

public class Lesson_2 {
    //Метод для замены 0 на 1 и 1 на 0 в массиве
    static int[] arrChange(int[] mass) {
        for (int i = 0; i < mass.length; i++) {

            if (mass[i] == 0) {
                mass[i] = 1;
            } else mass[i] = 0;
        }
        return mass;
    }

    static boolean checkBalace(int[] mass) {


        for (int i = 0; i < mass.length; i++) {

            int leftSum = 0, rightSum = 0;

            for (int j = 0; j < i; j++) {
                leftSum += mass[j];
            }

            for (int j = i; j < mass.length; j++) {
                rightSum += mass[j];
            }

            if (leftSum == rightSum) return true;
        }
        return false;
    }

    //Метод для пункта 7
    static int[] arraySdvig(int[] array, int sdvig) {

        if (Math.abs(sdvig) > array.length)
            sdvig = sdvig % array.length;

        int current, shifted, tmp;

        for (int i = 0; i < nod(sdvig, array.length); i++) {

            tmp = array[i];
            current = i;

            //Двигаем влево
            if (sdvig > 0) {

                while (true) {

                    shifted = current + sdvig;

                    if (shifted >= array.length)
                        shifted = shifted - array.length;

                    if (shifted == i)
                        break;

                    array[current] = array[shifted];
                    current = shifted;
                }

            //Сдвиг вправо
            } else if (sdvig < 0) {

                while (true) {

                    shifted  = current + sdvig;

                    if (shifted < 0)
                        shifted = shifted + array.length;

                    if (shifted == i)
                        break;

                    array[current] = array[shifted];
                    current = shifted;
                }
            }

            array[current] = tmp;
            
        }

        return array;
    }

    //Вычисляем наибольший общий делитель длины массива и его сдвига для пункта 7
    static int nod (int a, int b){

        while (b !=0) {
            int tmp = a % b;
            a = b;
            b = tmp;
        }
        return a;
    }
//  Создайте массив из всех нечётных чисел от 1 до 99,
//  выведите его на экран в строку, (заполнить массив с помощью цикла)

    static int[] oddArray () {

        int len = 0;
        for (int i = 1; i <= 99; i++) {
            if (i % 2 != 0)
                len++;
        }

        int[] mass = new int[len];

        for (int i = 1; i <= 99; i+=2)
            mass[(i-1)/2] = i;

        return mass;
    }

//  Создайте массив из 15 случайных целых чисел из отрезка [0;9].
//  Выведите массив на экран. Подсчитайте сколько в массиве чётных элементов и
//  выведете это количество на экран на отдельной строке.

    static void randArr() {

        int[] rand = new int[15];
        int even = 0;

        for (int i = 0; i < 15; i++) {
            rand[i] = (int)(Math.random()*9);
            if (rand[i]%2 == 0 && rand[i] != 0)
                even++;
        }

        System.out.println(Arrays.toString(rand));
        System.out.println("Количество четных элементов = " + even);

    }

//  Создайте 2 массива из 5 случайных целых чисел из отрезка [0;5] каждый,
//  выведите массивы на экран в двух отдельных строках. Посчитайте среднее
//  арифметическое элементов каждого массива и сообщите, для какого из массивов
//  это значение оказалось больше (либо сообщите, что их средние арифметические равны).

    static void twoArrays() {
        int sum1 = 0, sum2 = 0;
        int[] mass1 = new int[5], mass2 = new int[5];
        for (int i = 0; i < 5; i++) {
            mass1[i] = (int)(Math.random()*5);
            mass2[i] = (int)(Math.random()*5);
            sum1 += mass1[i];
            sum2 += mass2[i];
        }
         double ave1, ave2;
        ave1 = sum1/5;
        ave2 = sum2/5;

        System.out.println("Массив 1: " + Arrays.toString(mass1));
        System.out.println("Массив 2: " + Arrays.toString(mass2));

        if (ave1 == ave2)
            System.out.println("Средние арифметические массивов равны");
        else if (ave1 > ave2)
            System.out.println("Среднее арифметическое больше у массива 1");
        else
            System.out.println("Среднее арифметическое больше у массива 2");
    }

    public static void main(String[] args) {

        //    1. Задать целочисленный массив, состоящий из элементов 0 и 1.
//    Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ].
//    С помощью цикла и условия заменить 0 на 1, 1 на 0

        int[] mass = new int[] {1, 1, 0, 0, 1, 0, 1, 1, 0, 0}; //Объявляем массив

        System.out.println(Arrays.toString(mass)); //Выводим первоначальный массив
        arrChange(mass); //Меняем нули на единицы
        System.out.println(Arrays.toString(mass)); //Выводим полученный массив
        System.out.println();

//    2. Задать пустой целочисленный массив размером 8.
//    С помощью цикла заполнить его значениями 0 3 6 9 12 15 18 21

        int[] arr = new int[8]; //Задаем массив

        //Заполняем массив
        int elem = 0;
        for (int i = 0; i < arr.length; i++) {

            arr[i] = elem;
            elem += 3;
        }
        System.out.println(Arrays.toString(arr)); //Выводим заданный массив
        System.out.println();

//    3. Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ]
//    пройти по нему циклом, и числа меньшие 6 умножить на 2

        int[] massLessSix = new int[] {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1}; //Объявляем массив

        System.out.println(Arrays.toString(massLessSix)); //Выводим исходный массив в консоль

        //Умножаем на 2 числа, меньшие 6
        for (int i = 0; i < massLessSix.length; i++) {

            if (massLessSix[i] < 6) {
                int n = massLessSix[i];
                massLessSix[i] = n*2;
            }

        }
        System.out.println(Arrays.toString(massLessSix)); //Выводим полученный массив
        System.out.println();


//    4. Создать квадратный двумерный целочисленный массив
//    (количество строк и столбцов одинаковое),
//    и с помощью цикла(-ов) заполнить его диагональные элементы единицами

        int[][] massSquare = new int[5][5]; //Объявляем квадратный массив

        //Заполняем диагональные элементы единицами и выводим массив в консоль
        for (int i = 0; i < massSquare.length; i++) {

            for (int j = 0; j < massSquare[0].length; j++) {

                if (i == j || i + j == massSquare.length - 1) massSquare[i][j] = 1;
                System.out.print(massSquare[i][j] + " ");

            }

            System.out.println();
        }

        System.out.println();

//    5. ** Задать одномерный массив и найти в нем минимальный и
//    максимальный элементы (без помощи интернета)

        int[] massMinMax = new int[] {4, 19, 29, 48, 1, 77, -5}; //Инициализируем массив
        System.out.println(Arrays.toString(massMinMax)); //Выводим его

        //Найдем минимальный и максимальный элеметы
        int min = massMinMax[0], max = massMinMax[0];

        for (int i : massMinMax) {

            if (i > max) max = i;
            if (i < min) min = i;

        }

        System.out.println("Минимальный элемент: " + min + "\n" + "Максимальный элемент: " + max + "\n");

//    6. ** Написать метод, в который передается не пустой одномерный целочисленный массив,
//    метод должен вернуть true, если в массиве есть место,
//    в котором сумма левой и правой части массива равны.
//    Примеры: checkBalance([2, 2, 2, 1, 2, 2, || 10, 1]) → true, checkBalance([1, 1, 1, || 2, 1]) → true,
//    граница показана символами ||, эти символы в массив не входят

        int[] massBalance = new int[] {1, 1, 1, 2, 10}; //Инициализируем массив
        System.out.println(Arrays.toString(massBalance)); //Выводим массив в консоль

         //Проверяем равенство сумм левой и правой части
        System.out.println(checkBalace(massBalance));

//    7. **** Написать метод, которому на вход подается одномерный массив и число n
//    (может быть положительным, или отрицательным),
//    при этом метод должен сместить все элементымассива на n позиций.
//    Для усложнения задачи нельзя пользоваться вспомогательными массивами

        int[] array = new int[] {18, 26, 79, -19, 88, 156};
        int sdvig = -41;
        System.out.println(Arrays.toString(array) + "\n" + "Сдвиг = " + sdvig + "\n");

        System.out.println(Arrays.toString(arraySdvig(array, sdvig)) + "\n");


/*              Доп ДЗ              */

//  Создайте массив из всех нечётных чисел от 1 до 99,
//  выведите его на экран в строку, (заполнить массив с помощью цикла)

        System.out.println(Arrays.toString(oddArray()));

//  Создайте массив из 15 случайных целых чисел из отрезка [0;9].
//  Выведите массив на экран. Подсчитайте сколько в массиве чётных элементов и
//  выведете это количество на экран на отдельной строке.

        randArr();

//  Создайте 2 массива из 5 случайных целых чисел из отрезка [0;5] каждый,
//  выведите массивы на экран в двух отдельных строках. Посчитайте среднее
//  арифметическое элементов каждого массива и сообщите, для какого из массивов
//  это значение оказалось больше (либо сообщите, что их средние арифметические равны).

        twoArrays();


    }
}
