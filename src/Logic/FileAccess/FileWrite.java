package Logic.FileAccess;

import Logic.Mementos.Model;
import animation.Projector;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.QuadCurveTo;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileWrite {
    private String outputFile;
    private static DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
    private static DocumentBuilder documentBuilder;
    static {
        try {
            documentBuilder = documentBuilderFactory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
    }
    private static Document document = documentBuilder.newDocument();

    public FileWrite(String outputFile) {
        this.outputFile = outputFile;
    }

    public void saveModel(Model model,int highScore) throws ParserConfigurationException {
        Element rootEle = document.createElement("game");
        Element score = document.createElement("highScore");
        score.appendChild(document.createTextNode(String.valueOf(highScore)));
        Element eus = modelCreate(model);
        rootEle.appendChild(score);
        rootEle.appendChild(eus);
        document.appendChild(rootEle);
        try {
            Transformer tr = TransformerFactory.newInstance().newTransformer();
            tr.setOutputProperty(OutputKeys.INDENT, "yes");
            tr.setOutputProperty(OutputKeys.METHOD, "xml");
            tr.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
            tr.transform(new DOMSource(document),
                    new StreamResult(new FileOutputStream(outputFile)));

        } catch (TransformerException te) {
            System.out.println(te.getMessage());
        } catch (IOException ioe) {
            System.out.println(ioe.getMessage());
        }
    }
    public static Element modelCreate(Model model) {
        Element eus = document.createElement("model");
        Element score = document.createElement("score");
        score.appendChild(document.createTextNode(String.valueOf(model.getScore())));
        Element lives = document.createElement("lives");
        lives.appendChild(document.createTextNode(String.valueOf(model.getLives())));
        for (Projector o : model.getProjectors()) {
            Element projector = document.createElement("projector");
            Element pause = document.createElement("pause");
            pause.appendChild(document.createTextNode(String.valueOf(o.getPause())));
            Element duration = document.createElement("Duration");
            duration.appendChild(document.createTextNode(String.valueOf(o.getPathTransition().getDuration())));
            Element delay = document.createElement("Delay");
            delay.appendChild(document.createTextNode(String.valueOf(o.getPathTransition().getDelay())));
            Element type = document.createElement("type");
            type.appendChild(document.createTextNode(String.valueOf(o.getGameObject().getType())));
            Element x = document.createElement("moveX");
            Element y = document.createElement("moveY");
            Path path = (Path) o.getPathTransition().getPath();
            MoveTo move = (MoveTo) path.getElements().get(0);
            QuadCurveTo quadCurveTo = (QuadCurveTo) path.getElements().get(1);
            x.appendChild(document.createTextNode(String.valueOf(move.getX())));
            y.appendChild(document.createTextNode(String.valueOf(move.getY())));
            Element controlX = document.createElement("controlX");
            controlX.appendChild(document.createTextNode(String.valueOf(quadCurveTo.getControlX())));
            Element controlY = document.createElement("controlY");
            controlY.appendChild(document.createTextNode(String.valueOf(quadCurveTo.getControlY())));
            Element quadX = document.createElement("x");
            quadX.appendChild(document.createTextNode(String.valueOf(quadCurveTo.getX())));
            Element quadY = document.createElement("y");
            quadY.appendChild(document.createTextNode(String.valueOf(quadCurveTo.getY())));
            projector.appendChild(pause);
            projector.appendChild(duration);
            projector.appendChild(delay);
            projector.appendChild(type);
            projector.appendChild(x);
            projector.appendChild(y);
            projector.appendChild(controlX);
            projector.appendChild(controlY);
            projector.appendChild(quadX);
            projector.appendChild(quadY);
            eus.appendChild(projector);
        }
        eus.appendChild(score);
        eus.appendChild(lives);
        return eus;
    }
}
