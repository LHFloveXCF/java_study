package com.mt.designmodel.visitor;

/**
 * java_study
 */
public class ComputerBuild {
    public static void main(String[] args) {
        Computer computer = new Computer();
        Visitor student = new Student();
        computer.accept(student);
        System.out.println(student.howMuch());
    }
}

class Computer{
    Component cpu = new Cpu();
    Component hardCard = new HardCard();
    Component softWare = new SoftWare();


    public void accept(Visitor visitor) {
        cpu.accept(visitor);
        hardCard.accept(visitor);
        softWare.accept(visitor);
    }

}

abstract class Visitor{
    abstract void visitor(Cpu cpu);
    abstract void visitor(HardCard hardCard);
    abstract void visitor(SoftWare softWare);

    abstract double howMuch();
}

class Student extends Visitor {
    double totalPrice;

    public Student() {
    }

    public double howMuch() {
        return totalPrice;
    }

    @Override
    void visitor(Cpu cpu) {
        totalPrice += cpu.getPrice() * 0.95;
    }

    @Override
    void visitor(HardCard hardCard) {
        totalPrice += hardCard.getPrice() * 0.5;
    }

    @Override
    void visitor(SoftWare softWare) {
        totalPrice += softWare.getPrice() * 0.5;
    }
}

abstract class Component{
    abstract void accept(Visitor visitor);
}

class Cpu extends Component{

    public double getPrice() {
        return 200.00;
    }

    @Override
    void accept(Visitor visitor) {
        visitor.visitor(this);
    }
}

class HardCard extends Component{
    public double getPrice() {
        return 200.00;
    }

    @Override
    void accept(Visitor visitor) {
        visitor.visitor(this);
    }
}

class SoftWare extends Component{
    public double getPrice() {
        return 200.00;
    }

    @Override
    void accept(Visitor visitor) {
        visitor.visitor(this);
    }
}




