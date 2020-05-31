package name.wwl.demo.study.design.pattern.bridge.v4;

public class WildGift  extends Gift{

    public WildGift(GiftImpl impl) {
        this.impl = impl;
    }
}
