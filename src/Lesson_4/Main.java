package src.Lesson_4;

import java.util.Random;
import java.util.Scanner;

public class Main {

    static char[][] field;
    static final int SIZE = 3;
    static final int DOTS_TO_WIN = 3;
    static final char DOT_EMPTY = '•';
    static final char PLAYER_DOT = 'X';
    static final char AI_DOT = 'O';

    static Scanner scanner = new Scanner(System.in);
    static Random random = new Random();

    //Инициализация игрового поля
    public static void initField() {
        field = new char[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                field[i][j] = DOT_EMPTY;
            }
        }
    }

    //Выводим поле в консоль
    public static void printField() {
        for (int i = 0; i <= SIZE; i++) {
            if (i == 0) {
                System.out.print("  ");
            } else {
                System.out.print(i + " ");
            }
        }
        System.out.println();
        for (int i = 0; i < SIZE; i++) {
            System.out.print((i + 1) + "|");
            for (int j = 0; j < SIZE; j++) {
                System.out.print(field[i][j] + "|");
            }
            System.out.println();
        }
        System.out.println();
    }

    //Метод для установки символа
    private static void setSym(int y, int x, char sym) {
        field[y][x] = sym;
    }

    //Проверка валидности ячейки
    public static boolean isCellValid(int x, int y) {
        if (x < 0 || x >= SIZE || y < 0 || y >= SIZE) return false;
        if (field[y][x] == DOT_EMPTY) return true;
        return false;
    }

    //Ход человека
    public static void playerTurn() {
        int x, y;
        do {
            System.out.println("Введите координаты: X Y (1 - " + SIZE + ")");
            x = scanner.nextInt() - 1;
            y = scanner.nextInt() - 1;
        } while (!isCellValid(x,y));
        setSym(y, x, PLAYER_DOT);
    }

    //Ход компьютера
    private static void aiTurn() {
        int x, y;
        do {
            x = random.nextInt(SIZE);
            y = random.nextInt(SIZE);
        } while (!isCellValid(x,y));
        setSym(y, x, AI_DOT);
    }

    //Определение ничьей
    private static boolean isDraw() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if(field[i][j] == DOT_EMPTY) {
                    return false;
                }
            }
        }
        return true;
    }

    //Определение победителя
    private static boolean checkWin(char sym) {
        if (field[0][0] == sym && field[0][1] == sym && field[0][2] == sym) {
            return true;
        }
        if (field[1][0] == sym && field[1][1] == sym && field[1][2] == sym) {
            return true;
        }
        if (field[2][0] == sym && field[2][1] == sym && field[2][2] == sym) {
            return true;
        }

        if (field[0][0] == sym && field[1][0] == sym && field[2][0] == sym) {
            return true;
        }
        if (field[0][1] == sym && field[1][1] == sym && field[2][1] == sym) {
            return true;
        }
        if (field[0][2] == sym && field[1][2] == sym && field[2][2] == sym) {
            return true;
        }

        if (field[0][0] == sym && field[1][1] == sym && field[2][2] == sym) {
            return true;
        }
        if (field[2][0] == sym && field[1][1] == sym && field[0][2] == sym) {
            return true;
        }

        return false;
    }



    public static void main(String[] args) {
        initField();
        printField();

        while (true) {
            playerTurn();
            printField();

            if (checkWin(PLAYER_DOT)) {
                System.out.println("Победил человек!");
                break;
            }

            if (isDraw()) {
                System.out.println("Ничья");
                break;
            }

            aiTurn();
            printField();

            if (checkWin(AI_DOT)) {
                System.out.println("Победил компьютер");
                break;
            }

            if (isDraw()) {
                System.out.println("Ничья");
                break;
            }
        }

        System.out.println("Игра закончена.");
    }
}
