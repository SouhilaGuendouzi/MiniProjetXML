package com.company;

import java.util.ArrayList;
import java.util.Collections;

public class Equipes {
    ArrayList<Equipe> List=new ArrayList<Equipe>();


    public Contains contains (String NomEquipe){
        int i=0;

        Contains c=new Contains();
        while(i<List.size() && c.exist==false)
        {
            if (List.get(i).getNomEquipe().equals(NomEquipe))
            {c.exist=true;
            c.index=i;
            }
            i++;

        }
        return c;
    }

    @Override
    public String toString() {

        return "Equipes{" +
                "List=" + List +
                '}';
    }

    public void Update(int i, int NbButMarqués, int NbButReçus){
        Equipe  MAJ=List.get(i);
        int marqués=MAJ.getNbButsMarqués()+NbButMarqués;
        int reçus=MAJ.getNbButsReçus()+NbButReçus;
        MAJ.setNbButsMarqués(NbButMarqués);
        MAJ.setNbButsReçus(NbButReçus);
        MAJ.setNbMatchJoués();
        if (NbButMarqués>NbButReçus) {
            MAJ.setNbMatchGagnés();
            MAJ.setNombrePoints(3);
        }
        else if(NbButMarqués<NbButReçus)
        {MAJ.setNbMatchPerdus();

        }
        else {
            MAJ.setNbMatchNuls();
            MAJ.setNombrePoints(1);
        }
       if (marqués>reçus) MAJ.setDifférence(marqués-reçus);
         else MAJ.setDifférence(marqués-reçus);
        //System.out.println(MAJ.toString());

    }
    public void Classer(){
        Collections.sort(List);
        for (int i=0;i<List.size();i++)
        {
            List.get(i).setClassement(i+1);
        }
    }
}
