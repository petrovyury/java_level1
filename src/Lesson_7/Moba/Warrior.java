package Lesson_7.Moba;

public class Warrior extends Hero {

    public Warrior() {
        super(150, "Warrior", 50);
    }

    @Override
    void healing(Hero h) {
        System.out.println("Воины не умеют лечить!");
    }


}