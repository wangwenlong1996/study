package name.wwl.demo.study.design.pattern.observe;


import java.util.ArrayList;
import java.util.List;

public class Observe5 {
    static class Child {
        private boolean cry = false;
        private List<Observer> observers = new ArrayList<>();

        {
            observers.add(new Dad());
            observers.add(new Mum());
            observers.add(new Dog());
        }


        public boolean isCry() {
            return cry;
        }

        public void wakeUp() {
            cry = true;
            for(Observer o : observers) {
                o.actionOnWakeUp();
            }
        }
    }

    interface Observer {
        void actionOnWakeUp();
    }

    static class Dad implements Observer {
        public void feed() {
            System.out.println("dad feeding...");
        }

        @Override
        public void actionOnWakeUp() {
            feed();
        }
    }

    static class Mum implements Observer {
        public void hug() {
            System.out.println("mum hugging...");
        }

        @Override
        public void actionOnWakeUp() {
            hug();
        }
    }

    static class Dog implements Observer {
        public void wang() {
            System.out.println("dog wang...");
        }

        @Override
        public void actionOnWakeUp() {
            wang();
        }
    }
    public static void main(String[] args) {
        Child c = new Child();
        //do sth
        c.wakeUp();
    }

}
