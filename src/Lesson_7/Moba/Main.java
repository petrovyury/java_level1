package Lesson_7.Moba;

import java.util.Scanner;

public class Main {

    static Scanner sc = new Scanner(System.in);

    protected static int heroesInTeam;
    private static int heroType;
    private static int teamHealth;

    private static Hero[] team1 = new Hero[heroesInTeam];
    private static Hero[] team2 = new Hero[heroesInTeam];

    private static void teamBuild () {
        System.out.print("Введите количество игроков в каждой команде ");
        heroesInTeam = sc.nextInt();

        System.out.println();

        System.out.println("Определите состав команды №1");
        for (int i = 0; i < heroesInTeam; i++) {
            System.out.println("Игрок №" + (i+1) + "\n1. Воин\n2. Убийца\n3. Лекарь");
            do {
                heroType = sc.nextInt();
                if (heroType < 1 || heroType > 3) {
                    System.out.println("Вы ввели неверное значение. Повторите ввод.");
                } else
                    break;
            } while (true);


            switch (heroType) {
                case 1: {
                    team1[i] = new Warrior();
                    break;
                }
                case 2: {
                    team1[i] = new Assassin();
                    break;
                }
                case 3: {
                    team1[i] = new Healer();
                    break;
                }
            }
        }

        System.out.println("Определите состав команды №2");
        for (int i = 0; i < heroesInTeam; i++) {
            System.out.println("Игрок №" + (i+1) + "\n1. Воин\n2. Убийца\n3. Лекарь");
            do {
                heroType = sc.nextInt();
                if (heroType < 1 || heroType > 3) {
                    System.out.println("Вы ввели неверное значение. Повторите ввод.");
                } else
                    break;
            } while (true);

            switch (heroType) {
                case 1: {
                    team2[i] = new Warrior();
                    break;
                }
                case 2: {
                    team2[i] = new Assassin();
                    break;
                }
                case 3: {
                    team2[i] = new Healer();
                    break;
                }
            }
        }

    }

    private static void fight () {



    }


    public static void main(String[] args) {
        teamBuild();
        sc.close();
    }

}



