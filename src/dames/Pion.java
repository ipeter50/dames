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
        this.estDame=false;
        if (couleur.equals("N")){
            this.estNoir=true;
        }
        else{
            this.estNoir=false;
        }
    }
    
    public boolean deplacable(Plateau p){
        boolean res=false;
        ArrayList<ArrayList<Pion>> damier= p.getDamier();
        if(this.estNoir){
            if(this.coordonnees[0]+1<10 && this.coordonnees[1]+1<10 && damier.get(this.coordonnees[0]+1).get(coordonnees[1]+1)== null){
                res=true;
            }
            else if (this.coordonnees[0]+1<10 && this.coordonnees[1]-1>=0 && damier.get(this.coordonnees[0]+1).get(coordonnees[1]-1)== null){
                res=true;
            }
            
        }else{
            if(this.coordonnees[0]-1>=0 && this.coordonnees[1]+1<10 && damier.get(this.coordonnees[0]-1).get(coordonnees[1]+1)== null){
                res=true;
            }
            else if (this.coordonnees[0]-1>=0 && this.coordonnees[1]-1>=0 && damier.get(this.coordonnees[0]-1).get(coordonnees[1]-1)== null){
                res=true;
            }
            
        }
        
        
        
        return res;
        
    }
    
    public ArrayList<int[]> deplcementsPossibles(Plateau p){
        ArrayList<int[]> dep =new ArrayList<int[]>();
        ArrayList<ArrayList<Pion>> damier= p.getDamier();
        if(this.peutManger(p)){
            if(this.coordonnees[0]+2<10 && this.coordonnees[1]+2<10 && damier.get(this.coordonnees[0]+2).get(coordonnees[1]+2)!= null){
                int[] pos= new int[2];
                pos[0]=this.coordonnees[0]+1;
                pos[1]=this.coordonnees[1]+1;
                dep.add(pos);
            }
            if (this.coordonnees[0]+1<10 && this.coordonnees[1]-1>=0 && damier.get(this.coordonnees[0]+1).get(coordonnees[1]-1)!= null){
                int[] pos= new int[2];
                pos[0]=this.coordonnees[0]+1;
                pos[1]=this.coordonnees[1]-1;
                dep.add(pos);
            }
            if(this.coordonnees[0]-1>=0 && this.coordonnees[1]+1<10 && damier.get(this.coordonnees[0]-1).get(coordonnees[1]+1)!= null){
                int[] pos= new int[2];
                pos[0]=this.coordonnees[0]-1;
                pos[1]=this.coordonnees[1]+1;
                dep.add(pos);
            }
            if (this.coordonnees[0]-1>=0 && this.coordonnees[1]-1>=0 && damier.get(this.coordonnees[0]-1).get(coordonnees[1]-1)!= null){
                int[] pos= new int[2];
                pos[0]=this.coordonnees[0]-1;
                pos[1]=this.coordonnees[1]-1;
                dep.add(pos);
            }
            
        }
        else if (this.deplacable(p)){
            if(this.estNoir){
            if(this.coordonnees[0]+1<10 && this.coordonnees[1]+1<10 && damier.get(this.coordonnees[0]+1).get(coordonnees[1]+1)!= null){
                int[] pos= new int[2];
                pos[0]=this.coordonnees[0]+1;
                pos[1]=this.coordonnees[1]+1;
                dep.add(pos);
            }
            if (this.coordonnees[0]+1<10 && this.coordonnees[1]-1>=0 && damier.get(this.coordonnees[0]+1).get(coordonnees[1]-1)!= null){
                int[] pos= new int[2];
                pos[0]=this.coordonnees[0]+1;
                pos[1]=this.coordonnees[1]-1;
                dep.add(pos);
            }
            
        }else{
            if(this.coordonnees[0]-1>=0 && this.coordonnees[1]+1<10 && damier.get(this.coordonnees[0]-1).get(coordonnees[1]+1)!= null){
                int[] pos= new int[2];
                pos[0]=this.coordonnees[0]-1;
                pos[1]=this.coordonnees[1]+1;
                dep.add(pos);
            }
            if (this.coordonnees[0]-1>=0 && this.coordonnees[1]-1>=0 && damier.get(this.coordonnees[0]-1).get(coordonnees[1]-1)!= null){
                int[] pos= new int[2];
                pos[0]=this.coordonnees[0]-1;
                pos[1]=this.coordonnees[1]-1;
                dep.add(pos);
            }
            
        }
            
        }
        
        return dep;
    }
    
    
}
