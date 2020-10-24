package com.company;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class Lire_XML_SAX  extends DefaultHandler  {
    Equipes France=new Equipes();
    String domicile,Exterieur;
    int scored,scoree;
    public void startDocument() throws SAXException {
       // System.out.println("Debut du Document");
    }

    public void startElement(String uri, String localName, String qName,
                             Attributes attributes) throws SAXException {
        if (qName.equals("RENCONTRE")) {

            domicile=attributes.getValue("DOMICILE");
            Exterieur=attributes.getValue("EXTERIEUR");
            Contains contains=new Contains();
            Integer i=new Integer(attributes.getValue("SCORED"));
            scored=i.intValue();
            Integer j=new Integer(attributes.getValue("SCOREE"));
            scoree=j.intValue();


            contains=France.contains(domicile);
            if (contains.exist==true)
            {
                France.Update(contains.index,scored,scoree);
                France.List.get(contains.index).Re.add(new Rencontre(domicile,Exterieur,scored,scoree));
            }
            else {
                Equipe T=new Equipe(domicile,scored,scoree);
                T.Re.add(new Rencontre(domicile,Exterieur,scored,scoree));
                France.List.add(T);
            }
            contains=France.contains(Exterieur);
            if (contains.exist==true)
            {
                France.Update(contains.index,scoree,scored);
                France.List.get(contains.index).Re.add(new Rencontre(domicile,Exterieur,scored,scoree));
            }
            else {

                Equipe T=new Equipe(Exterieur,scoree,scored);
                T.Re.add(new Rencontre(domicile,Exterieur,scored,scoree));
                France.List.add(T);
            }
        }
    }

    @Override
    public String toString() {
        return "Lire_XML_SAX{" +
                "France=" + France +
                '}';
    }

    public void endElement(String uri, String localName, String qName)
            throws SAXException {
        //System.out.println(" Fin de L'Element");
    }

    public void endDocument() throws SAXException {
       // System.out.println("Fin du Document");
    }

}
