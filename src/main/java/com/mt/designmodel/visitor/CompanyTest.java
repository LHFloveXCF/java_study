package com.mt.designmodel.visitor;

import java.util.ArrayList;
import java.util.List;

/**
 * java_study
 */
public class CompanyTest {
    public static void main(String[] args) {
        ConcreteObject object = new ConcreteObject();
        object.add(new Paper());
        object.add(new Copper());
        object.produce(new PaperCompany());
    }
}

abstract class Company{
    abstract void produce(Paper material);
    abstract void produce(Copper material);
}

abstract class Material{
    abstract void accept(Company company);
}

class Paper extends Material {

    @Override
    void accept(Company company) {
        company.produce(this);
    }
}

class Copper extends Material {

    @Override
    void accept(Company company) {
        company.produce(this);
    }
}

class ConcreteObject {
    List<Material> list = new ArrayList<>();

    void add(Material material) {
        list.add(material);
    }

    void remove(Material material) {
        list.remove(material);
    }

    public void produce(Company company) {
        for (Material material : list) {
            material.accept(company);
        }
    }
}

class PaperCompany extends Company{

    @Override
    void produce(Paper material) {
        System.out.println("造纸");
    }

    @Override
    void produce(Copper material) {
        System.out.println("生成艺术品");
    }
}