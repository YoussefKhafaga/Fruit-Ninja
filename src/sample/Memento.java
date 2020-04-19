package sample;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;
public class Memento {
    
    File inputFile =  new File("Data.xml");
    SAXBuilder saxBuilder = new SAXBuilder();
    Document document;
    {
        try {
            document = saxBuilder.build(inputFile);
        } catch (JDOMException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    Element rootNode = document.getRootElement();
    Element bestScore = rootNode.getChild("Bestscore");
    Element currentScore = rootNode.getChild("Currentlscore");
    Element livesLost = rootNode.getChild("Liveslost");
    Element Level = rootNode.getChild("level");
    public void Load()
    {

    }
    public void modify(int bestScore , int currentScore , int livesLost , int level)
    {
        if(currentScore>bestScore)
        rootNode.getChild("Bestscore").setText(Integer.toString(currentScore));
        rootNode.getChild("Currentscore").setText(Integer.toString(currentScore));
        rootNode.getChild("LivesLost").setText(Integer.toString(livesLost));
        rootNode.getChild("level").setText(Integer.toString(level));
        XMLOutputter xmlOutputter = new XMLOutputter(Format.getPrettyFormat());
        try {
            xmlOutputter.output(document,new FileOutputStream("Data.xml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
