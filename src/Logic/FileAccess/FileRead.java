package Logic.FileAccess;

import Logic.GameObjects.GameObject;
import Logic.Mementos.Model;
import Logic.GameObjects.ObjectFactory;
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
import java.util.ArrayList;

public  class FileRead {
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
                doc = dbuild.parse(new File(outputFile));
            } catch (SAXException | IOException e) {
                System.err.println("empty file");
            }
        }
    }
    public int getHighScore(){
        int highScore=0;
        if (doc != null ){
            NodeList nList = doc.getElementsByTagName("highScore");
            Node node = nList.item(0);
            if (node instanceof Element) {
                Element element= (Element) nList.item(0);
                 highScore = Integer.parseInt(element.getTextContent());
            }

        }
        return  highScore;
    }

    public Model getSavedModel() throws ParseException {
        Model model = new Model();
        if (doc == null){
            return model;
        }
        NodeList nList = doc.getElementsByTagName("model");
        ArrayList<Projector> projectors = new ArrayList<>();
        ObjectFactory objectFactory = new ObjectFactory();
        for (int j = 0; j < nList.getLength(); j++) {
            Node node = nList.item(j);
            if (node instanceof Element) {
                Element eElement = (Element) node;
                NodeList plist = eElement.getElementsByTagName("projector");
                for (int  i= 0; i < plist.getLength(); i++) {
                    Element pElement = (Element) plist.item(i);
                    Projector projector = new Projector();
                    projector.setPathTransition(createPathTransition(pElement));
                    String a = pElement.getElementsByTagName("type").item(0).getTextContent();
                    Double b = Double.parseDouble(pElement.getElementsByTagName("pause").
                            item(0).getTextContent().split(" ")[0]);
                    GameObject gameObject = objectFactory.createObject(a);
                    projector.getPathTransition().setNode(gameObject.getCanvas());
                    projector.setGameObject(gameObject);
                    projector.setPause(Duration.millis(b));
                    projectors.add(projector);
                }

                int a = Integer.parseInt(eElement.getElementsByTagName("lives").item(0).getTextContent());
                int b = Integer.parseInt(eElement.getElementsByTagName("score").item(0).getTextContent());
                model = new Model(a, b, projectors);
            }
        }
        return model;
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
        Double g = Double.parseDouble(eElement.getElementsByTagName("Delay").item(0).getTextContent()
                .split(" ")[0]);
        Double h = Double.parseDouble(eElement.getElementsByTagName("Duration").item(0).getTextContent()
                .split(" ")[0]);
        path.getElements().addAll(new MoveTo(a, b), new QuadCurveTo(c, d, e, f));
        pathTransition.setPath(path);
        pathTransition.setDelay(Duration.millis(g));
        pathTransition.setDuration(Duration.millis(h));
        return pathTransition;
    }

}
