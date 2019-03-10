package src.Lesson_4;

import java.util.Random;
import java.util.Scanner;

public class Main {

    static final int SIZE = 3;
    static final int DOTS_TO_WIN = 3;
    static final char DOT_EMPTY = '•';
    static final char PLAYER_DOT = 'X';
    static final char AI_DOT = 'O';
    static char[][] field = new char[SIZE][SIZE];

    static Scanner scanner = new Scanner(System.in);
    static Random random = new Random();

    //Инициализация игрового поля
    public static void initField() {
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
        //для строк
        for (int i = 0; i < SIZE; i++) {
            int countRow = 0;
            for (int j = 0; j < SIZE; j++) {
                if (field[i][j] == sym) {
                    countRow++;
                } else {
                    if (j + 1 < SIZE && field[i][j + 1] != sym && countRow != DOTS_TO_WIN) {
                        countRow = 0;
                    }
                }
            }
            if (countRow >= DOTS_TO_WIN) {
                return true;
            }
        }

        //для столбцов
        for (int i = 0; i < SIZE; i++) {
            int countCol = 0;
            for (int j = 0; j < SIZE; j++) {
                if (field[j][i] == sym) {
                    countCol++;
                } else {
                    if (j + 1 < SIZE && field[j + 1][i] != sym && countCol != DOTS_TO_WIN) {
                        countCol = 0;
                    }
                }
            }
            if (countCol >= DOTS_TO_WIN) {
                return true;
            }
        }

        //для диагоналей
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                int countUp = 0;
                int countDown = 0;

                for (int k = i, l = j; k < SIZE && l < SIZE; k++, l++) {
                    if (field[k][l] == sym) {
                        countDown++;
                    } else {
                        if (k + 1 < SIZE && l + 1 < SIZE && field[k+1][l+1] != sym && countDown != DOTS_TO_WIN) {
                            countDown = 0;
                        }
                    }
                }

                for (int k = i, l = j; k >= 0 && l < SIZE ; k--, l++) {
                    if (field[k][l] == sym) {
                        countUp++;
                    } else {
                        if (k - 1 >= 0 && l + 1 < SIZE && field[k-1][l+1] != sym && countUp != DOTS_TO_WIN) {
                            countUp = 0;
                        }
                    }
                }

                if (countDown >= DOTS_TO_WIN || countUp >= DOTS_TO_WIN) {
                    return true;
                }
            }
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
