package name.wwl.demo.study.design.pattern.observe;

public class Observe3 {

    static class Child {
        private boolean cry = false;
        private Dad d = new Dad();

        public boolean isCry() {
            return cry;
        }

        public void wakeUp() {
            cry = true;
            d.feed();
        }
    }

    static class Dad {
        public void feed() {
            System.out.println("dad feeding...");
        }
    }

    public static void main(String[] args) {
        Child c = new Child();
        //do sth
        c.wakeUp();

    }
}
