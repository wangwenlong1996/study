package name.wwl.demo.study.design.pattern.bridge.v4;

public class WarmGift extends Gift {

    public WarmGift(GiftImpl impl){
        this.impl = impl;
    }
}
