package name.wwl.demo.study.tank.decorator;

import name.wwl.demo.study.tank.chain.GameObject;

public abstract class GoDecorator extends GameObject {
    GameObject go;

    public GoDecorator(GameObject go){
        this.go = go;
    }

}
