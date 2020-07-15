package name.wwl.demo.study.design.pattern.visitor;


public class Computer {

    ComputerPart cpu = new Cpu();
    ComputerPart memory = new Memory();
    ComputerPart board = new Board();

    public void accept(Visitor v){
        this.cpu.accept(v);
        this.memory.accept(v);
        this.board.accept(v);
    }

    public static void main(String[] args) {

        PersonVisitor p = new PersonVisitor();
        new Computer().accept(p);
        System.out.println(p.totalPrice);
    }

}

abstract  class ComputerPart{
    abstract void accept(Visitor v);

    abstract double getPrice();
}

class Cpu extends ComputerPart{


    @Override
    void accept(Visitor v) {
        v.visitCpu(this);
    }

    @Override
    double getPrice() {
        return 500;
    }
}


class Memory extends ComputerPart{

    @Override
    void accept(Visitor v) {
        v.visitMemory(this);
    }

    @Override
    double getPrice() {
        return 200;
    }
}

class Board extends ComputerPart{

    @Override
    void accept(Visitor v) {
        v.visitBoard(this);
    }

    @Override
    double getPrice() {
        return 200;
    }
}

interface Visitor{

    void visitCpu(Cpu cpu);
    void visitMemory(Memory memory);
    void visitBoard(Board board);

}

class PersonVisitor implements Visitor{

    double totalPrice = 0.0;

    @Override
    public void visitCpu(Cpu cpu) {
        totalPrice += cpu.getPrice()*0.9;
    }

    @Override
    public void visitMemory(Memory memory) {
        totalPrice += memory.getPrice()*0.85;
    }

    @Override
    public void visitBoard(Board board) {
        totalPrice += board.getPrice()*0.95;
    }
}


class CorpVisitor implements Visitor {
    double totalPrice = 0.0;

    @Override
    public void visitCpu(Cpu cpu) {
        totalPrice += cpu.getPrice()*0.6;
    }

    @Override
    public void visitMemory(Memory memory) {
        totalPrice += memory.getPrice()*0.75;
    }

    @Override
    public void visitBoard(Board board) {
        totalPrice += board.getPrice()*0.75;
    }
}