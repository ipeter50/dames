/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dames;

import java.util.ArrayList;

/**
 *
 * @author Jules
 */
public class Plateau {

    ArrayList<ArrayList<Pion>> damier;

    public ArrayList<ArrayList<Pion>> getDamier() {
        return damier;
    }

    public void setDamier(ArrayList<ArrayList<Pion>> damier) {
        this.damier = damier;
    }

    public Plateau() {
        damier = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            damier.add(new ArrayList<>());
            for (int j = 0; j < 10; j++) {
                damier.get(i).add(null);
            }
        }
        for (int i = 0; i < 20; i++) {
            int x = i / 5;
            int y = (2 * i) % 10 + ((x + 1) % 2);
            int[] pos = new int[2];
            pos[0] = x;
            pos[1] = y;
            damier.get(x).set(y, new Pion(pos, "N"));
        }
        for (int i = 0; i < 20; i++) {
            int x = 9 - (i / 5);
            int y = 9 - ((2 * i) % 10 + x % 2);
            int[] pos = new int[2];
            pos[0] = x;
            pos[1] = y;
            damier.get(x).set(y, new Pion(pos, "B"));
        }
    }

    public void affichePlateau() {
        int k = damier.size();
        int l = damier.size();
        System.out.println(k+" "+l);
        for (int i = 0; i < k; i++) {
            String ligne = new String();
            for (int j = 0; j < k; j++) {
                if (damier.get(i).get(j) == null) {
                    ligne+="|   ";
                } else {
                    if (damier.get(i).get(j).isEstNoir()) {
                        if (damier.get(i).get(j).isEstDame()) {
                            ligne+="|RN ";
                        }
                        else {
                            ligne+="| N ";
                        }
                    } else {
                        if (damier.get(i).get(j).isEstDame()) {
                            ligne+="|RB ";
                        }
                        else {
                            ligne+="| B ";
                        }
                    }
                }
            }
            System.out.println(ligne+"|\n");
        }
    }
}
