package name.wwl.demo.study.design.pattern.observe;

public class Observe1 {

    static class Child{
        private boolean cry = false;

        public boolean isCry(){
            return cry;
        }

        public void wakeup(){
            System.out.println("Waked Up! Crying wuwuwuwu...");
            cry = true;
        }
    }
    public static void main(String[] args) {
        Child child = new Child();
        while(!child.isCry()) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("observing...");
        }
    }
}
