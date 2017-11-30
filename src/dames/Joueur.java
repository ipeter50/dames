/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dames;

import java.util.Scanner;

/**
 *
 * @author pacom
 */
public class Joueur {

    private boolean estNoir;

    public Joueur(boolean estNoir) {
        this.estNoir = estNoir;
    }

    public int[] choixPiece(Plateau p) {
        p.affichePlateau();
        System.out.println("-------------------------------------------------------------------------------------------------------------------------");
        System.out.println("Choix des coordonnées du pion à déplacer la pièce à déplacer:");
        System.out.println("x");
        Scanner sc = new Scanner(System.in);
        int x = Integer.parseInt(sc.nextLine());
        System.out.println("y");
        sc = new Scanner(System.in);
        int y = Integer.parseInt(sc.nextLine());
        while ((p.damier.get(y).get(x) == null) || !(p.damier.get(y).get(x).deplacable(p) || p.damier.get(y).get(x).peutManger(p))) {
            System.out.println("Les coordonnées correspondent à une case vide ou un pion non déplaçable, entrez à nouveau des coordonnées:");
            System.out.println("x");
            sc = new Scanner(System.in);
            x = Integer.parseInt(sc.nextLine());
            System.out.println("y");
            sc = new Scanner(System.in);
            y = Integer.parseInt(sc.nextLine());
        }
        System.out.println("Le pion choisi est valide !");
        int[] res = [y, x
        ];
        return res;
    }

    public void choixDeplacement(Plateau p) {
        System.out.println("-------------------------------------------------------------------------------------------------------------------------");
        System.out.println("Choix de la direction du déplacement (gauche/droite):");
        System.out.println("x");
        Scanner sc = new Scanner(System.in);
        int x = Integer.parseInt(sc.nextLine());
        System.out.println("y");
        sc = new Scanner(System.in);
        int y = Integer.parseInt(sc.nextLine());
        while (p.damier.get(y).get(x) != null) || !((x ==  && y ==) || ) {
            System.out.println("Coordonnées invalide, la case est occupée, entrez de nouvelles coordonnées");
            System.out.println("x");
            sc = new Scanner(System.in);
            x = Integer.parseInt(sc.nextLine());
            System.out.println("y");
            sc = new Scanner(System.in);
            y = Integer.parseInt(sc.nextLine());
        }

    }

}
