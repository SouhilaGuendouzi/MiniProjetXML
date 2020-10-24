package com.company;

import java.util.ArrayList;
import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

public class Stocker {
    public ArrayList<Equipe> Equipes=new ArrayList<Equipe>();
    public Stocker(ArrayList<Equipe> Equipes)
    {
        this.Equipes=Equipes;
    }

   public void Stockage (){
        try{
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = null;
        try {
            builder = factory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
        // création d'un document
        Document document = builder.newDocument();
        Element racine = document.createElement("Championnat");
        document.appendChild(racine);
        for (Equipe e:this.Equipes
             ) {
            Element Equipe=document.createElement("Equipe");

            Equipe.setAttribute("Nom", e.getNomEquipe());
            String texte= new String();
            texte = texte.valueOf(e.getNbMatchJoués());
            Equipe.setAttribute("NombreMatchsJoués",texte);
            texte = texte.valueOf(e.getNbMatchGagnés());
            Equipe.setAttribute("NombreMatchGagnés",texte);
            texte = texte.valueOf(e.getNbMatchPerdus());
            Equipe.setAttribute("NombreMatchPerdus",texte);
            texte = texte.valueOf(e.getNbMatchNuls());
            Equipe.setAttribute("NombreMatchNuls",texte);
            texte = texte.valueOf(e.getNbButsMarqués());
            Equipe.setAttribute("NombreButsMarqués",texte);
            texte = texte.valueOf(e.getNbButsReçus());
            Equipe.setAttribute("NombreButsReçus",texte);
            texte = texte.valueOf(e.getDifférence());
            Equipe.setAttribute("DifférenceButs",texte);
            texte = texte.valueOf(e.getNombrePoints());
            Equipe.setAttribute("NombrePoints",texte);
            texte = texte.valueOf(e.getClassement());
            Equipe.setAttribute("Classement",texte);
            racine.appendChild(Equipe);


        }

            TransformerFactory transformerFactory = TransformerFactory.newInstance();

            // r�cup�ration du transformeur
            Transformer transformer =  transformerFactory.newTransformer();

            // configuration du transformeur
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty(OutputKeys.ENCODING, "ISO-8859-1");

            // �criture du document dans un fichier
            DOMSource source = new DOMSource(document);
            StreamResult result = new StreamResult(new File("Classements.xml"));
            StreamResult result2 = new StreamResult(System.out);
            transformer.transform(source, result);
            transformer.transform(source, result2);

    }
    catch (Exception e)
    {
        System.out.println(e);
    }


}}
