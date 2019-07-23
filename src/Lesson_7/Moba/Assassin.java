package Lesson_7.Moba;

public class Assassin extends Hero {


    public Assassin() {
        super(110, "Assassin", 80);
    }

    @Override
    void healing(Hero h) {
        System.out.println("Убийцы не умеют лечить!");
    }
}
