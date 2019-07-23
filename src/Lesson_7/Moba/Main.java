package Lesson_7.Moba;

import java.util.Scanner;

public class Main {

    static Scanner sc = new Scanner(System.in);

    static final int HEROES_IN_TEAM = 3;
    static int heroType;
    static Hero[] team1 = new Hero[HEROES_IN_TEAM];
    static Hero[] team2 = new Hero[HEROES_IN_TEAM];



    static String setHeroType (int i) {
        String s = new String();
        System.out.println("Игрок №" + (i + 1) + "\n1. Воин\n2. Убийца\n3. Лекарь");
        heroType = sc.nextInt();
        while (heroType < 1 || heroType > 3) {
            System.out.println("Вы ввели неверное значение. Повторите ввод.");
            heroType = sc.nextInt();
        }
        switch (heroType) {
            case 1: {
                s = "Warrior";
                break;
            }
            case 2: {
                s = "Assassin";
                break;
            }
            case 3: {
                s = "Healer";
                break;
            }
        }
        return s;
    }



    static void teamBuild () {



        System.out.println("Определите состав команды №1");
        for (int i = 0; i < HEROES_IN_TEAM; i++) {
            team1[i].type = setHeroType(i);
        }

        System.out.println("Определите состав команды №2");
        for (int i = 0; i < HEROES_IN_TEAM; i++) {
            team2[i].type = setHeroType(i);
        }

        sc.close();
    }

    static void teamInfo() {
        for (int i = 0; i < HEROES_IN_TEAM; i++) {
            System.out.print("Команда №1: " + team1[i].type);
        }
        System.out.println();
        for (int i = 0; i < HEROES_IN_TEAM; i++) {
            System.out.print("Команда №2: " + team2[i].type);
        }
    }

    public static void main(String[] args) {

        teamBuild();
        teamInfo();

    }
}



