package Logic.FileAccess;

import Logic.Model;
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
    private static Document dom = documentBuilder.newDocument();

    public FileWrite(String outputFile) {
        this.outputFile = outputFile;
    }
    public void saveModel(Model model,int highScore) throws ParserConfigurationException {
        Element rootEle = dom.createElement("game");
        Element score = dom.createElement("highScore");
        score.appendChild(dom.createTextNode(String.valueOf(highScore)));
        Element eus = modelCreate(model);
        rootEle.appendChild(score);
        rootEle.appendChild(eus);
        dom.appendChild(rootEle);
        try {
            Transformer tr = TransformerFactory.newInstance().newTransformer();
            tr.setOutputProperty(OutputKeys.INDENT, "yes");
            tr.setOutputProperty(OutputKeys.METHOD, "xml");
            tr.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
            tr.transform(new DOMSource(dom),
                    new StreamResult(new FileOutputStream(outputFile)));

        } catch (TransformerException te) {
            System.out.println(te.getMessage());
        } catch (IOException ioe) {
            System.out.println(ioe.getMessage());
        }
    }
    public static Element modelCreate(Model model) {
        Element eus = dom.createElement("model");
        Element score = dom.createElement("score");
        score.appendChild(dom.createTextNode(String.valueOf(model.getScore())));
        Element lives = dom.createElement("lives");
        lives.appendChild(dom.createTextNode(String.valueOf(model.getLives())));
        for (Projector o : model.getProjectors()) {
            Element projector = dom.createElement("projector");
            Element pause = dom.createElement("pause");
            pause.appendChild(dom.createTextNode(String.valueOf(o.getPause())));
            Element duration = dom.createElement("Duration");
            duration.appendChild(dom.createTextNode(String.valueOf(o.getPathTransition().getDuration())));
            Element delay = dom.createElement("Duration");
            duration.appendChild(dom.createTextNode(String.valueOf(o.getPathTransition().getDelay())));
            Element type = dom.createElement("type");
            type.appendChild(dom.createTextNode(String.valueOf(o.getGameObject().getType())));
            Element x = dom.createElement("moveX");
            Element y = dom.createElement("moveY");
            Path path = (Path) o.getPathTransition().getPath();
            MoveTo move = (MoveTo) path.getElements().get(0);
            QuadCurveTo quadCurveTo = (QuadCurveTo) path.getElements().get(1);
            x.appendChild(dom.createTextNode(String.valueOf(move.getX())));
            y.appendChild(dom.createTextNode(String.valueOf(move.getY())));
            Element controlX = dom.createElement("controlX");
            controlX.appendChild(dom.createTextNode(String.valueOf(quadCurveTo.getControlX())));
            Element controlY = dom.createElement("controlY");
            controlY.appendChild(dom.createTextNode(String.valueOf(quadCurveTo.getControlY())));
            Element quadX = dom.createElement("x");
            quadX.appendChild(dom.createTextNode(String.valueOf(quadCurveTo.getX())));
            Element quadY = dom.createElement("y");
            quadY.appendChild(dom.createTextNode(String.valueOf(quadCurveTo.getY())));
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
