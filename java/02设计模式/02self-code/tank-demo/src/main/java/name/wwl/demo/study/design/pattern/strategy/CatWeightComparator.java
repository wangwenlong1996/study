package name.wwl.demo.study.design.pattern.strategy;

public class CatWeightComparator implements Comparator<Cat> {
    @Override
    public int compare(Cat o1, Cat o2) {
        if (o1.weight>o2.weight) return -1;
        if (o1.weight<o2.weight) return 1;
        return 0;
    }
}
