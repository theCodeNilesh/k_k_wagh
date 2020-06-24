package com.kkwagh.kkw_poly;

public class Category {
    public static final int ENGLISH = 1;
    public static final int PHYSICS = 2;
    public static final int CHEMISTRY = 3;
    public static final int MATHS = 4;
    private int id;
    private String name;

    public Category() {

    }

    public Category(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return getName();
    }
}
