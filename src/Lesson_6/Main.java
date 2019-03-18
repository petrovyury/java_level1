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

        System.out.println();

        String s = "Предложение  один     Теперь предложение    два   Предложение   три";
        String s1 = s.replaceAll(" +", " ");
        StringBuilder s2 = new StringBuilder(s1);

        for (int i = 1; i < s1.length(); i++) {

            if(s1.charAt(i) >= 'А' && s1.charAt(i) <= 'Я') {
                s2.setCharAt(i-1, '.');

            }


        }

        for (int i = 1; i < s2.length(); i++) {

            if (s2.charAt(i) == '.') {
                s2.insert(i+1," ");
            }
        }

        s2.insert(s2.length(), '.');


        System.out.println(s2);

    }
}
