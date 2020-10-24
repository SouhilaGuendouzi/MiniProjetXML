package com.company;

import org.xml.sax.SAXException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;


public class Main {

    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
        System.out.println(" Ce Tp Est Réalisé Par Guendouzi Badra Souhila -1SC_Groupe1-");
        SAXParserFactory factoy = SAXParserFactory.newInstance();
        SAXParser parser = factoy.newSAXParser();
        File xmlFile = new File("Championnat.xml");
        Lire_XML_SAX championnat = new Lire_XML_SAX();
        parser.parse(xmlFile, championnat);
        championnat.France.Classer();
        System.out.println("*********************** Question 1 ***********************");
        System.out.println(championnat.France);
        System.out.println("*********************** Fin Question 1 ***********************");
        System.out.println("*********************** Question 2 ***********************");

        Stocker s=new Stocker(championnat.France.List);
        s.Stockage();
        System.out.println("***********************  Fin Question 2 ***********************");


    }
}
