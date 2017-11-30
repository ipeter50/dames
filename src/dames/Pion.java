/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dames;

import java.util.ArrayList;

/**
 *
 * @author Pierre
 */
public class Pion {

    private int[] coordonnees; //[y;x]
    private boolean estDame;
    private boolean estNoir;

    public int[] getCoordonnees() {
        return coordonnees;
    }

    public void setCoordonnees(int[] coordonnees) {
        this.coordonnees = coordonnees;
    }

    public boolean isEstDame() {
        return estDame;
    }

    public void setEstDame(boolean estDame) {
        this.estDame = estDame;
    }

    public boolean isEstNoir() {
        return estNoir;
    }

    public void setEstNoir(boolean estNoir) {
        this.estNoir = estNoir;
    }

    public Pion(int[] coordonnees, String couleur) {
        this.coordonnees = coordonnees;
        this.estDame = false;
        if (couleur.equals("N")) {
            this.estNoir = true;
        } else {
            this.estNoir = false;
        }
    }

    public boolean deplacable(Plateau p) {
        boolean res = true;
        if (this.estNoir) {
            if (!this.estDame) {
                ArrayList<ArrayList<Pion>> damier = p.getDamier();
                if (damier.get(this.coordonnees[0] + 1).get(coordonnees[1] + 1) != null) {
                    res = false;
                } else if (damier.get(this.coordonnees[0] + 1).get(coordonnees[1] - 1) != null) {
                    res = false;
                }
            }
        }

        return res;

    }

    public boolean peutManger(Plateau p) {
        boolean res = false;
        for (int k = 0; k < 4; k++) {
            int x, y;
            switch (k) {
                case 0:
                    y = this.coordonnees[0] - 1;
                    x = this.coordonnees[1] + 1;
                    break;
                case 1:
                    y = this.coordonnees[0] + 1;
                    x = this.coordonnees[1] + 1;
                    break;
                case 2:
                    y = this.coordonnees[0] + 1;
                    x = this.coordonnees[1] - 1;
                    break;
                case 3:
                    y = this.coordonnees[0] - 1;
                    x = this.coordonnees[1] - 1;
                    break;     
                default:
                    y = -1;
                    x = -1;
                    break;
            }
            if ((x >= 0) && (x <10) && (y >= 0) && (y < 10)){
                if (p.damier.get(y).get(x) != null){
                    res = p.damier.get(y).get(x).estNoir != this.estNoir;
                }
            }
        }
        int y = this.coordonnees[0] - 1;
        int x = this.coordonnees[1] + 1;

        return res;
    }

}
