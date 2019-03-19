package Lesson_7.Moba;

import java.util.Scanner;

public class Main {

    static Scanner sc = new Scanner(System.in);

    protected int heroesInTeam;
    private int heroType;

    private void teamBuild () {
        System.out.println("Введите количество игроков в каждой команде");
        heroesInTeam = sc.nextInt();
        Hero[] team1 = new Hero[heroesInTeam - 1];
    }


    public static void main(String[] args) {

        sc.close();
    }

}



