package Lesson_7.Moba;

public class Healer extends Hero {

    public Healer() {
        super(90, "Healer", 20);
    }

    @Override
    void healing(Hero h) {
        health += 20;
    }
}
