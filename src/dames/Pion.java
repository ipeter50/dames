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
        boolean res = false;
        ArrayList<ArrayList<Pion>> damier = p.getDamier();
        if (this.estNoir) {
            if (this.coordonnees[0] + 1 < 10 && this.coordonnees[1] + 1 < 10 && damier.get(this.coordonnees[0] + 1).get(coordonnees[1] + 1) == null) {
                res = true;
            } else if (this.coordonnees[0] + 1 < 10 && this.coordonnees[1] - 1 >= 0 && damier.get(this.coordonnees[0] + 1).get(coordonnees[1] - 1) == null) {
                res = true;
            }

        } else {
            if (this.coordonnees[0] - 1 >= 0 && this.coordonnees[1] + 1 < 10 && damier.get(this.coordonnees[0] - 1).get(coordonnees[1] + 1) == null) {
                res = true;
            } else if (this.coordonnees[0] - 1 >= 0 && this.coordonnees[1] - 1 >= 0 && damier.get(this.coordonnees[0] - 1).get(coordonnees[1] - 1) == null) {
                res = true;
            }

        }

        return res;

    }

    public ArrayList<int[]> deplcementsPossibles(Plateau p) {
        ArrayList<int[]> dep = new ArrayList<int[]>();
        ArrayList<ArrayList<Pion>> damier = p.getDamier();
        if (!estDame) {

            if (this.peutManger(p)) {
                if (this.coordonnees[0] + 2 < 10 && this.coordonnees[1] + 2 < 10 && damier.get(this.coordonnees[0] + 2).get(coordonnees[1] + 2) == null && damier.get(this.coordonnees[0] + 1).get(coordonnees[1] + 1) != null) {
                    int[] pos = new int[2];
                    pos[0] = this.coordonnees[0] + 2;
                    pos[1] = this.coordonnees[1] + 2;
                    dep.add(pos);
                }
                if (this.coordonnees[0] + 2 < 10 && this.coordonnees[1] - 2 >= 0 && damier.get(this.coordonnees[0] + 2).get(coordonnees[1] - 2) == null && damier.get(this.coordonnees[0] + 1).get(coordonnees[1] - 1) != null) {
                    int[] pos = new int[2];
                    pos[0] = this.coordonnees[0] + 2;
                    pos[1] = this.coordonnees[1] - 2;
                    dep.add(pos);
                }
                if (this.coordonnees[0] - 2 >= 0 && this.coordonnees[1] + 2 < 10 && damier.get(this.coordonnees[0] - 2).get(coordonnees[1] + 2) == null && damier.get(this.coordonnees[0] - 1).get(coordonnees[1] + 1) != null) {
                    int[] pos = new int[2];
                    pos[0] = this.coordonnees[0] - 2;
                    pos[1] = this.coordonnees[1] + 2;
                    dep.add(pos);
                }
                if (this.coordonnees[0] - 2 >= 0 && this.coordonnees[1] - 2 >= 0 && damier.get(this.coordonnees[0] - 2).get(coordonnees[1] - 2) == null && damier.get(this.coordonnees[0] - 1).get(coordonnees[1] - 1) != null) {
                    int[] pos = new int[2];
                    pos[0] = this.coordonnees[0] - 2;
                    pos[1] = this.coordonnees[1] - 2;
                    dep.add(pos);
                }

            } else if (this.deplacable(p)) {
                if (this.estNoir) {
                    if (this.coordonnees[0] + 1 < 10 && this.coordonnees[1] + 1 < 10 && damier.get(this.coordonnees[0] + 1).get(coordonnees[1] + 1) == null) {
                        int[] pos = new int[2];
                        pos[0] = this.coordonnees[0] + 1;
                        pos[1] = this.coordonnees[1] + 1;
                        dep.add(pos);
                    }
                    if (this.coordonnees[0] + 1 < 10 && this.coordonnees[1] - 1 >= 0 && damier.get(this.coordonnees[0] + 1).get(coordonnees[1] - 1) == null) {
                        int[] pos = new int[2];
                        pos[0] = this.coordonnees[0] + 1;
                        pos[1] = this.coordonnees[1] - 1;
                        dep.add(pos);
                    }

                } else {
                    if (this.coordonnees[0] - 1 >= 0 && this.coordonnees[1] + 1 < 10 && damier.get(this.coordonnees[0] - 1).get(coordonnees[1] + 1) == null) {
                        int[] pos = new int[2];
                        pos[0] = this.coordonnees[0] - 1;
                        pos[1] = this.coordonnees[1] + 1;
                        dep.add(pos);
                    }
                    if (this.coordonnees[0] - 1 >= 0 && this.coordonnees[1] - 1 >= 0 && damier.get(this.coordonnees[0] - 1).get(coordonnees[1] - 1) == null) {
                        int[] pos = new int[2];
                        pos[0] = this.coordonnees[0] - 1;
                        pos[1] = this.coordonnees[1] - 1;
                        dep.add(pos);
                    }

                }

            }

        } else {

            if (this.peutManger(p)) {
                for (int i = 2; i < 8; i++) {
                    if (this.coordonnees[0] + i < 10 && this.coordonnees[1] + i < 10 && damier.get(this.coordonnees[0] + i).get(coordonnees[1] + i) == null && damier.get(this.coordonnees[0] + i-1).get(coordonnees[1] + i-1) != null) {
                        int[] pos = new int[2];
                        pos[0] = this.coordonnees[0] + i;
                        pos[1] = this.coordonnees[1] + i;
                        dep.add(pos);
                    }
                    if (this.coordonnees[0] + i < 10 && this.coordonnees[1] - i >= 0 && damier.get(this.coordonnees[0] + i).get(coordonnees[1] - i) == null && damier.get(this.coordonnees[0] + i-1).get(coordonnees[1] - i+1) != null) {
                        int[] pos = new int[2];
                        pos[0] = this.coordonnees[0] + i;
                        pos[1] = this.coordonnees[1] - i;
                        dep.add(pos);
                    }
                    if (this.coordonnees[0] - i >= 0 && this.coordonnees[1] + i < 10 && damier.get(this.coordonnees[0] - i).get(coordonnees[1] + i) == null && damier.get(this.coordonnees[0] - i+1).get(coordonnees[1] + i-1) != null) {
                        int[] pos = new int[2];
                        pos[0] = this.coordonnees[0] - i;
                        pos[1] = this.coordonnees[1] +i;
                        dep.add(pos);
                    }
                    if (this.coordonnees[0] - i >= 0 && this.coordonnees[1] - i >= 0 && damier.get(this.coordonnees[0] - i).get(coordonnees[1] - i) == null && damier.get(this.coordonnees[0] - i+1).get(coordonnees[1] - i+1) != null) {
                        int[] pos = new int[2];
                        pos[0] = this.coordonnees[0] - i;
                        pos[1] = this.coordonnees[1] - i;
                        dep.add(pos);
                    }

                }

            } else if (this.deplacable(p)) {
                for(int i=1;i<8;i++)
                if (this.estNoir) {
                    if (this.coordonnees[0] + i < 10 && this.coordonnees[1] + i < 10 && damier.get(this.coordonnees[0] + i).get(coordonnees[1] + i) == null) {
                        int[] pos = new int[2];
                        pos[0] = this.coordonnees[0] + i;
                        pos[1] = this.coordonnees[1] + i;
                        dep.add(pos);
                    }
                    if (this.coordonnees[0] + i < 10 && this.coordonnees[1] - i >= 0 && damier.get(this.coordonnees[0] + i).get(coordonnees[1] - i) == null) {
                        int[] pos = new int[2];
                        pos[0] = this.coordonnees[0] + i;
                        pos[1] = this.coordonnees[1] - i;
                        dep.add(pos);
                    }

                } else {
                    if (this.coordonnees[0] - i >= 0 && this.coordonnees[1] + i < 10 && damier.get(this.coordonnees[0] - i).get(coordonnees[1] + i) == null) {
                        int[] pos = new int[2];
                        pos[0] = this.coordonnees[0] - i;
                        pos[1] = this.coordonnees[1] + i;
                        dep.add(pos);
                    }
                    if (this.coordonnees[0] - i >= 0 && this.coordonnees[1] - i >= 0 && damier.get(this.coordonnees[0] - i).get(coordonnees[1] - i) == null) {
                        int[] pos = new int[2];
                        pos[0] = this.coordonnees[0] - i;
                        pos[1] = this.coordonnees[1] - i;
                        dep.add(pos);
                    }

                }

            }

        }

        return dep;
    }

}
