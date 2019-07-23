package Lesson_6;

public class Dog extends Animal {


    @Override
    public void run(double distance) {
        if (distance >= 0 && distance <= 500){
            System.out.println("результат: run:true");
        } else {
            System.out.println("результат: run:false");
        }
    }

    @Override
    protected void swim(double distance) {
        if (distance >= 0 && distance <= 10){
            System.out.println("результат: swim:true");
        } else {
            System.out.println("результат: swim:false");
        }
    }

    @Override
    protected void jump(double height) {
        if (height >= 0 && height <= 0.5) {
            System.out.println("результат: jump:true");
        } else {
            System.out.println("результат: jump:false");
        }
    }
}
