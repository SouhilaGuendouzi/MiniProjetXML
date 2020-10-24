package com.company;

import java.util.ArrayList;

public class Equipe implements Comparable<Equipe>{
    private String NomEquipe;
    private int NbMatchJoués;
    private int NbMatchGagnés;
    private int NbMatchPerdus;
    private int NbMatchNuls;
    private int NbButsMarqués;
    private int  NbButsReçus;
    private int Différence;
    private int NombrePoints;
    private int Classement;
    public ArrayList<Rencontre> Re=new ArrayList<Rencontre>();

    public Equipe(String nomEquipe ,int  nbButsMarqués, int nbButsReçus) {
        this.NomEquipe = nomEquipe;
        this.NbMatchJoués=1;
        this.NbButsMarqués=nbButsMarqués;
        this.NbButsReçus=nbButsReçus;
        this.Classement=0;
        if (nbButsMarqués==nbButsReçus)
        {this.NombrePoints=1;
            this.NbMatchNuls=1;
        }
          else if (nbButsMarqués>nbButsReçus)
        {this.NombrePoints=3;
            this.NbMatchGagnés=1;
        }
        else this.NbMatchPerdus=1;

    }

    public String getNomEquipe() {
        return NomEquipe;
    }

    public void setNomEquipe(String nomEquipe) {
        NomEquipe = nomEquipe;
    }

    public int getNbMatchJoués() {
        return NbMatchJoués;
    }

    public void setNbMatchJoués() {
        NbMatchJoués ++;
    }

    public int getNbMatchGagnés() {
        return NbMatchGagnés;
    }

    public void setNbMatchGagnés() {
        NbMatchGagnés += 1;
    }

    public int getNbMatchPerdus() {
        return NbMatchPerdus;
    }

    public void setNbMatchPerdus() {
        NbMatchPerdus ++;
    }

    public int getNbMatchNuls() {
        return NbMatchNuls;
    }

    @Override
    public String toString() {
        return "Equipe{" +
                "NomEquipe='" + NomEquipe + '\'' +
                ", NbMatchJoués=" + NbMatchJoués +
                ", NbMatchGagnés=" + NbMatchGagnés +
                ", NbMatchPerdus=" + NbMatchPerdus +
                ", NbMatchNuls=" + NbMatchNuls +
                ", NbButsMarqués=" + NbButsMarqués +
                ", NbButsReçus=" + NbButsReçus +
                ", Différence=" + Différence +
                ", NombrePoints=" + NombrePoints +
                ", Classement=" + Classement +
                '}'+"\n";
    }

    public void setNbMatchNuls() {
        NbMatchNuls ++;
    }

    public int getNbButsMarqués() {
        return NbButsMarqués;
    }

    public void setNbButsMarqués(int nbButsMarqués) {
        NbButsMarqués += nbButsMarqués;
    }

    public int getNbButsReçus() {
        return NbButsReçus;
    }

    public void setNbButsReçus(int nbButsReçus) {
        NbButsReçus += nbButsReçus;
    }

    public int  getDifférence() {
        return Différence;
    }

    public void setDifférence(int différence) {
        Différence = différence;
    }

    public int getNombrePoints() {
        return NombrePoints;
    }

    public void setNombrePoints(int nombrePoints) {
        NombrePoints += nombrePoints;
    }

    public int  getClassement() {
        return Classement;
    }

    public void setClassement(int classement) {
        Classement = classement;
    }

    public ArrayList<Rencontre> Extraire_Rencontre( Equipe e) {      //cette méthode a pour but d'extraire tous les rencontres d'une équipe
        ArrayList<Rencontre> R=new ArrayList<Rencontre>();
        for (Rencontre re:Re
             ) {
            if (re.Domicile.equals(e.getNomEquipe()) || re.Exterieur.equals(e.getNomEquipe()))
                R.add(re);
        }
       return R;
    }

    @Override
    public int compareTo(Equipe o) {

        if (o.getNombrePoints()>this.NombrePoints) return 1;
         else if (o.getNombrePoints()<this.NombrePoints) return -1;
         else {
            if (o.getDifférence()>this.Différence) return 1;
              else if (o.getDifférence()<this.Différence) return -1;
              else {
                ArrayList<Rencontre> RE=Extraire_Rencontre(o);
                int NBPoint_O=0; int NBPoint_E =0;
                for (Rencontre ren:RE
                     ) {
                    if (ren.Domicile.equals(this.NomEquipe)) {
                        if (ren.scored>ren.scoree)
                        {
                            NBPoint_E=3;
                        }
                        else if (ren.scored==ren.scoree)
                        {
                            NBPoint_E=1;
                            NBPoint_O=1;
                        }
                        else NBPoint_O=3;
                    }
                    else {
                       if  (ren.scored<ren.scoree)
                                {
                                    NBPoint_E=3;
                                }
                        else if (ren.scored==ren.scoree)
                       {
                           NBPoint_E=1;
                           NBPoint_O=1;
                       }
                       else NBPoint_O=3;

                    }
                }
                if (NBPoint_O > NBPoint_E) return 1;
                 else if (NBPoint_O < NBPoint_E) return -1;
                 else {
                    ArrayList<Rencontre> R3=Extraire_Rencontre(o);  //3eme condition
                     int NbButsMarqués_O=0; int NbButsMarqués_E=0;

                    for (Rencontre ren:R3
                         ) {
                        if (ren.Domicile.equals(this.NomEquipe))
                        {
                            NbButsMarqués_E+=ren.scored;
                            NbButsMarqués_O+=ren.scoree;


                        }
                        else {
                            NbButsMarqués_E+=ren.scoree;
                            NbButsMarqués_O+=ren.scored;

                        }
                    }
                    if (NbButsMarqués_E-NbButsMarqués_O >NbButsMarqués_O-NbButsMarqués_E) return -1;
                    else if (NbButsMarqués_E-NbButsMarqués_O <NbButsMarqués_O-NbButsMarqués_E) return -1;
                    else {
                        ArrayList<Rencontre> R4=Extraire_Rencontre(o);  //4eme condition
                        int NbButsMarquésO=0; int NbButsMarquésE=0;

                        for (Rencontre ren:R3
                                ) {
                            if (ren.Domicile.equals(this.NomEquipe))
                            {
                                NbButsMarquésE+=ren.scored;
                                NbButsMarquésO+=ren.scoree;


                            }
                            else {
                                NbButsMarquésE+=ren.scoree;
                                NbButsMarquésO+=ren.scored;

                            }
                        }
                        if (NbButsMarquésE >NbButsMarquésO) return -1;
                        else if (NbButsMarquésE <NbButsMarquésO) return -1;
                        else {
                            int Max_E=0;
                            int Max_O=0;
                            if(this.Re.get(0).Domicile.equals(this.NomEquipe)) Max_E=this.Re.get(0).scored;
                                    else Max_E=this.Re.get(0).scoree;
                            if(o.Re.get(0).Domicile.equals(o.NomEquipe)) Max_O=o.Re.get(0).scored;
                            else Max_O=o.Re.get(0).scoree;
                            for (int i=1;i<this.Re.size();i++)
                            {
                                if (this.Re.get(i).Domicile.equals(this.NomEquipe))
                                {
                                    if (Max_E<this.Re.get(i).scored) Max_E=this.Re.get(i).scored;
                                }
                                else {
                                    if (Max_E<this.Re.get(i).scoree) Max_E=this.Re.get(i).scoree;
                                }
                            }
                            for (int j=1;j<o.Re.size();j++)
                            {
                                if(o.Re.get(j).Domicile.equals(o.getNomEquipe()))
                                {
                                    if (Max_O<o.Re.get(j).scored) Max_O=o.Re.get(j).scored;
                                }
                                else {
                                    if (Max_O<o.Re.get(j).scoree) Max_O=o.Re.get(j).scoree;
                                }
                            }
                            if (Max_O> Max_E) return 1;
                            else return -1;

                        }
                    }

                }

            }
        }

    }
}
