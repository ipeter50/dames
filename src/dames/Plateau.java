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

    public Plateau() {
        for (int i = 0; i < 10; i++) {
            damier.add(new ArrayList<>());
            for (int j = 0; j < 10; j++) {
                damier.get(i).add(null);
            }
        }
        System.out.println(damier.toString());
        for (int i = 0; i < 20; i++) {
            int y = i % 5;
            int x = (2 * i) % y + y % 2;
            damier.get(x).set(y, new Pion([x, y], "N"));
        }
        for (int i = 0; i < 20; i++) {
            int y = 9 - (i % 5);
            int x = 9- ((2 * i) % y + y%2);
            damier.get(x).set(y, new Pion([x, y], "B"));            
        }
        System.out.println(damier.toString());
    }
}
