package com.company;


import java.util.ArrayList;
import java.util.Objects;

public class Chara implements Comparable<Chara> {


    private char character;
    private int count;

    public Chara(char character, int count) {
        this.character = character;
        this.count = count;
    }

    public Chara() {
    }


    public char getCharacter() {
        return character;
    }

    public void setCharacter(char character) {
        this.character = character;
    }

    public int getCount() {
        if (this != null) {
            return count;
        } else return 0;
    }

    public void setCount(int count) {
        this.count = count;
    }


    public int getIndexOf(Chara c, ArrayList<Chara> x) {
        for (int i = 0; i < x.size(); i++) {
            if (c.getCharacter() == x.get(i).getCharacter()) {
                return i;
            }
        }
        return -1;

    }

    public void printChara() {
        System.out.println("| CHAR '" + this.getCharacter() + "' | INSTANCES: | " + this.getCount());
    }


    @Override
    public int compareTo(Chara anotherEmployee) {
        return this.getCount() - anotherEmployee.getCount();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Chara)) return false;
        Chara chara = (Chara) o;
        return getCharacter() == chara.getCharacter();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCharacter());
    }


}
