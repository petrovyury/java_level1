package Lesson_6;

public class Main {

    public static void main(String[] args) {
        Cat cat1 = new Cat();
        Cat cat2 = new Cat();
        Dog dog1 = new Dog();
        Dog dog2 = new Dog();

        cat1.jump(5);
        cat2.jump(0.3);

        cat1.swim(1);
        cat2.swim(4);

        cat1.run(26);
        cat2.run(175);

        dog1.jump(0.3);
        dog2.jump(0.7);

        dog1.run(10);
        dog2.run(78);

        dog1.swim(17);
        dog2.swim(14);
    }
}
