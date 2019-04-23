package com.company;

import java.util.ArrayList;


public class CodeNode implements Comparable<CodeNode> {

    Character charan = Character.MIN_VALUE;
    private int freq;
    private CodeNode left = null;
    private CodeNode right = null;
    public String code = "";

    public CodeNode() {

    }

    public CodeNode(Character charan, int freq) {
        this.charan = charan;
        this.freq = freq;
    }

    public CodeNode(int freq, CodeNode left, CodeNode right) {
        this.freq = freq;
        this.left = left;
        this.right = right;
    }


    public int getIndexOfMin(ArrayList<Chara> data) {
        Chara min = new Chara();
        int index = -1;
        for (int i = 0; i < data.size(); i++) {
            if (i == 0) {
                min = data.get(0);
            }
            if (min.compareTo(data.get(i)) < 0) {
                min = data.get(i);
                index = i;
            }
        }
        return index;
    }


    public Character getCharan() {
        return charan;
    }

    public void setCharan(Character charan) {
        this.charan = charan;
    }

    public int getFreq() {
        return freq;
    }

    public void setFreq(int freq) {
        this.freq = freq;
    }

    public CodeNode getLeft() {
        return left;
    }

    public void setLeft(CodeNode left) {
        this.left = left;
    }

    public CodeNode getRight() {
        return right;
    }

    public void setRight(CodeNode right) {
        this.right = right;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setCodes(CodeNode root, String s) {
        if (root.left == null && root.right == null && root.getCharan() != Character.MIN_VALUE) {
            root.setCode(root.getCode() + s);
            return;
        }

        setCodes(root.left, s + "0");
        setCodes(root.right, s + "1");
    }

    public static void printTree(CodeNode root) {

        if (root.left
                == null
                && root.right
                == null
                && root.getCharan() != Character.MIN_VALUE) {

            // c is the character in the node
            System.out.println(root);

            return;
        }

        printTree(root.left);
        printTree(root.right);
    }


    public int CodedLength(CodeNode root) {
        if (root == null)
            return 0;
        return ((root.freq * root.getCode().length()) + CodedLength(root.left) +
                CodedLength(root.right));
    }

    @Override
    public int compareTo(CodeNode anotherNode) {
        return this.getFreq() - anotherNode.getFreq();
    }

    @Override

    public String toString() {
        return String.format("|  CHAR: |" + charan + "|  FREQ:  |" + freq + "|    CODE    |" + code);
    }
}
