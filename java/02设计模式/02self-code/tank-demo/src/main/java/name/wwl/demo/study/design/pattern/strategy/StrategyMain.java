package name.wwl.demo.study.design.pattern.strategy;

import java.util.Arrays;

/**
 * 策略模式 符合开闭原则  增加代码 而不是改变代码
 */
public class StrategyMain {
    public static void main(String[] args) {
        Cat[] a = {new Cat(3, 3), new Cat(5, 5), new Cat(1, 1)};
        //Dog[] a = {new Dog(3), new Dog(5), new Dog(1)};
        Sorter<Cat> sorter = new Sorter<>();
        sorter.sort(a, new  CatHeightComparator());
        System.out.println(Arrays.toString(a));

        sorter.sort(a, new CatWeightComparator());
        System.out.println(Arrays.toString(a));
    }
}
