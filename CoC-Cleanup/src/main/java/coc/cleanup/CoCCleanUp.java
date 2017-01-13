/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coc.cleanup;

import java.io.File;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

/**
 *
 * @author miguel
 */
public class CoCCleanUp {

    private int notValid;
    private int valid;

    private String errorMessage;

    private final boolean write;
    private final String newFileName;
    private Document newDoc;
    private Element cocs;

    public CoCCleanUp(String newFileName, boolean write) {
        notValid = 0;
        valid = 0;
        this.write = write;
        this.newFileName = newFileName;
        errorMessage = "";
    }

    public int cleanDocument(String filename) {
        try {

            File xmlFile = new File(filename);

            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(xmlFile);
            doc.getDocumentElement().normalize();

            if (write) {
                newDoc = dBuilder.newDocument();
                Element rootElement = newDoc.createElement("documents");
                newDoc.appendChild(rootElement);
                cocs = newDoc.createElement("cocs");
                rootElement.appendChild(cocs);
            }
            NodeList nodeLst = doc.getElementsByTagName("coc");

            int size = nodeLst.getLength();

            for (int i = 0; i < size; i++) {
                handleCoC(nodeLst.item(i));
            }

            System.out.println("\n-------------------------------------------\n");
            System.out.println("Total number of nodes: " + (valid + notValid) + "\n");
            System.out.println("Number of valid nodes: " + valid);
            System.out.println("Number of NOT valid nodes: " + notValid);

            if (write) {
                TransformerFactory transformerFactory = TransformerFactory.newInstance();
                Transformer transformer = transformerFactory.newTransformer();
                newDoc.setXmlStandalone(true);
                DOMSource source = new DOMSource(newDoc);
                StreamResult result = new StreamResult(new File(newFileName));

                transformer.transform(source, result);

                System.out.println("\nNew clean xml written to: " + newFileName);
            }

            System.out.println("\n-------------------------------------------\n");

            return 0;

        } catch (SAXParseException ex) {
            errorMessage = "\nAn error occured while parsing the file\nXml file Line Number: " + ex.getLineNumber() + "\n" + ex.getMessage();
            return -1;
        } catch (SAXException | ParserConfigurationException | TransformerException | DOMException ex) {
            errorMessage = "An error occured";
            return -1;
        } catch (IOException ex) {
            errorMessage = "The file: " + filename + " does not exists";
            return -1;
        }
    }

    public void handleCoC(Node cocNode) {
        NodeList nodeList = cocNode.getChildNodes();
        Node cocDocument = null;

        for (int i = 0; i < nodeList.getLength(); i++) {
            Node n = nodeList.item(i);
            if (n.getNodeType() == Node.ELEMENT_NODE && n.getNodeName().equals("cocDocument")) {
                cocDocument = n;
            }
        }

        if (cocDocument != null) {
            Element cocDocument_e = (Element) cocDocument;

            if (handleCoCDocument(cocDocument_e)) {
                if (write) {
                    Element e = (Element) newDoc.importNode(cocNode, true);
                    cocs.appendChild(e);
                }
            }
        }
    }

    public boolean handleCoCDocument(Element cocDocumElement) {
        if (cocDocumElement.getElementsByTagName("status").item(0).getTextContent().equals("not valid")) {
            notValid++;
            return false;
        }
        if (cocDocumElement.getElementsByTagName("status").item(0).getTextContent().equals("valid")) {
            valid++;
            return true;
        }
        return false;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
