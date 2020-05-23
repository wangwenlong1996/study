package name.wwl.demo.study.tank.strategy;

import name.wwl.demo.study.tank.Tank;
import name.wwl.demo.study.tank.factory.BaseTank;

public interface FireStrategy {
    void fire(BaseTank t);
}
