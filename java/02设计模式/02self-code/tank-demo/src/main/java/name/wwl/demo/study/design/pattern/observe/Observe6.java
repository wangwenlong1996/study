package name.wwl.demo.study.design.pattern.observe;

import java.util.ArrayList;
import java.util.List;

public class Observe6 {

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

            wakeUpEvent event = new wakeUpEvent(System.currentTimeMillis(), "bed");

            for(Observer o : observers) {
                o.actionOnWakeUp(event);
            }
        }
    }

    //事件类 fire Event
    static class wakeUpEvent{
        long timestamp;
        String loc;

        public wakeUpEvent(long timestamp, String loc) {
            this.timestamp = timestamp;
            this.loc = loc;
        }
    }

    interface Observer {
        void actionOnWakeUp(wakeUpEvent event);
    }

    static class Dad implements Observer {
        public void feed() {
            System.out.println("dad feeding...");
        }

        @Override
        public void actionOnWakeUp(wakeUpEvent event) {
            feed();
        }
    }

    static class Mum implements Observer {
        public void hug() {
            System.out.println("mum hugging...");
        }

        @Override
        public void actionOnWakeUp(wakeUpEvent event) {
            hug();
        }
    }

    static class Dog implements Observer {
        public void wang() {
            System.out.println("dog wang...");
        }

        @Override
        public void actionOnWakeUp(wakeUpEvent event) {
            wang();
        }
    }

    public static void main(String[] args) {
        Child c = new Child();
        //do sth
        c.wakeUp();
    }



}
