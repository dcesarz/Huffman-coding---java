package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;


public class Main {

    public static void main(String[] args) {

        File file = new File("textfile.txt");
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));

            int i = 0;
            String length = "";
            String n;
            ArrayList<Chara> charactercount = new ArrayList<Chara>();
            char[] chhh;

            while ((n = br.readLine()) != null) {

                length += n;

                char[] n1 = n.toCharArray();


                for (char c : n1) {

                    Chara temp = new Chara(c, 0);
                    if ((temp.getIndexOf(temp, charactercount)) != -1) {
                        int z = temp.getIndexOf(temp, charactercount);
                        charactercount.get(z).setCount(charactercount.get(z).getCount() + 1);

                    } else {

                        charactercount.add(new Chara(c, 1));

                    }

                }


            }

            System.out.println(charactercount.size());

            Collections.sort(charactercount);

            for (i = 0; i < charactercount.size(); i++) {

                charactercount.get(i).printChara();

            }

            PriorityQueue<CodeNode> huff
                    = new PriorityQueue<CodeNode>(charactercount.size());

            CodeNode root = null;

            for (i = 0; i < charactercount.size(); i++) {
                CodeNode newnode = new CodeNode();
                newnode.setCharan(charactercount.get(i).getCharacter());
                newnode.setFreq(charactercount.get(i).getCount());

                huff.add(newnode);

            }

            while (huff.size() > 1) {
                CodeNode x = huff.peek();
                huff.poll();

                CodeNode y = huff.peek();
                huff.poll();

                CodeNode z = new CodeNode();
                z.setFreq(x.getFreq() + y.getFreq());

                z.setLeft(x);
                z.setRight(y);

                root = z;

                huff.add(z);
            }
            root.setCodes(root, "");
            root.printTree(root);

            byte[] byteArray = length.getBytes("ASCII");

            //System.out.println(length);

            System.out.println("\n \nDLUGOSC ORYIGNIALU W BITACH: " + byteArray.length * 8 + "  DLUGOSC PO ZAKODOWANIU " + root.CodedLength(root));

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
