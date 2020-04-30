package Logic.FileAccess;

import Logic.Model;
import Logic.ObjectFactory;
import Logic.Player;
import animation.Projector;
import javafx.animation.PathTransition;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.QuadCurveTo;
import javafx.util.Duration;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class FileRead {
    private static DocumentBuilderFactory dbfact = DocumentBuilderFactory.newInstance();
    private static DocumentBuilder dbuild;
    static Document doc;

    public FileRead(String outputFile) {
        {
            try {
                dbuild = dbfact.newDocumentBuilder();
            } catch (ParserConfigurationException e) {
                e.printStackTrace();
            }
        }
        {
            try {
                doc = dbuild.parse(new File("resources/" + outputFile));
            } catch (SAXException | IOException e) {
                e.printStackTrace();
            }
        }
    }

//    public ArrayList<Player> getPlayers() {
//        ArrayList<Player> players = new ArrayList<>();
//        NodeList nlist = doc.getElementsByTagName("player");
//        for (int i = 0; i < nlist.getLength(); i++) {
//            Node nNode = nlist.item(i);
//            if (nNode instanceof Element) {
//                Element eElement = (Element) nNode;
//                String a = eElement.getElementsByTagName("name").item(0).getTextContent();
//                String b = eElement.getElementsByTagName("highscore").item(0).getTextContent();
//                Player e = new Player(a, Integer.valueOf(b));
//                players.add(e);
//            }
//        }
//
//        return players;
//    }

    public Model getSavedModel() throws ParseException {
        NodeList nlist = doc.getElementsByTagName("model");
        Model model = new Model();
            Node nNode = doc.getElementsByTagName("model").item(0);
            if (nNode instanceof Element) {
                Element eElement = (Element) nNode;
                NodeList plist = eElement.getElementsByTagName("projector");
                ArrayList<Projector> projectors = new ArrayList<>();
                ObjectFactory objectFactory = new ObjectFactory();
                for (int j = 0; j < plist.getLength(); j++) {
                    Projector projector = new Projector();
                    projector.setPathTransition(createPathTransition(eElement));
                    String a = eElement.getElementsByTagName("type").item(0).getTextContent();
                    Double b = Double.parseDouble(eElement.getElementsByTagName("pause").item(0).getTextContent());
                    projector.setGameObject(objectFactory.createObject(a));
                    projector.setPause(Duration.millis(b));
                    projectors.add(projector);
                }
                int a = Integer.parseInt(eElement.getElementsByTagName("lives").item(0).getTextContent());
                int b = Integer.parseInt(eElement.getElementsByTagName("score").item(0).getTextContent());
                model = new Model(a,b,projectors);
        }
        return model ;
    }
    private PathTransition createPathTransition(Element eElement) throws ParseException {
        assert eElement != null;
        PathTransition pathTransition = new PathTransition();
        Path path = new Path();
        Double a = Double.parseDouble(eElement.getElementsByTagName("moveX").item(0).getTextContent());
        Double b = Double.parseDouble(eElement.getElementsByTagName("moveY").item(0).getTextContent());
        Double c = Double.parseDouble(eElement.getElementsByTagName("controlX").item(0).getTextContent());
        Double d = Double.parseDouble(eElement.getElementsByTagName("controlY").item(0).getTextContent());
        Double e = Double.parseDouble(eElement.getElementsByTagName("x").item(0).getTextContent());
        Double f = Double.parseDouble(eElement.getElementsByTagName("y").item(0).getTextContent());
        Double g = Double.parseDouble(eElement.getElementsByTagName("Duration").item(0).getTextContent());
        Double h = Double.parseDouble(eElement.getElementsByTagName("Delay").item(0).getTextContent());
        path.getElements().addAll(new MoveTo(a,b),new QuadCurveTo(c,d,e,f));
        pathTransition.setPath(path);
        pathTransition.setDelay(Duration.millis(g));
        pathTransition.setDuration(Duration.millis(h));
        return pathTransition ;
    }

}
