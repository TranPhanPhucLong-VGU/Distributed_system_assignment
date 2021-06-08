package com.company;

import java.io.StringReader;
import java.io.StringWriter;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

public class Utils {
    public static String convertObject2XML(Student student) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder;
        String output = "";
        try {
            builder = factory.newDocumentBuilder();
            Document doc = builder.newDocument();

            // create root
            Element root = doc.createElement("student");
            doc.appendChild(root);

            Element idNode = doc.createElement("id");
            idNode.appendChild(doc.createTextNode(student.getId() + ""));

            Element nameNode = doc.createElement("name");
            nameNode.appendChild(doc.createTextNode(student.getName()));

            Element gradeNode = doc.createElement("grade");
            gradeNode.appendChild(doc.createTextNode(student.getGrade() + ""));

            root.appendChild(idNode);
            root.appendChild(nameNode);
            root.appendChild(gradeNode);

            // test
            TransformerFactory tf = TransformerFactory.newInstance();
            Transformer transformer;

            try {
                transformer = tf.newTransformer();
                StringWriter writer = new StringWriter();
                transformer.transform(new DOMSource(doc), new StreamResult(writer));
                output = writer.getBuffer().toString();
            } catch (TransformerException e) {
                e.printStackTrace();
            }
        } catch (ParserConfigurationException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }

        return output;
    }

    private static Document convertStringToDocument(String xmlStr) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder;
        try {
            builder = factory.newDocumentBuilder();
            Document doc = builder.parse(new InputSource(new StringReader(xmlStr)));
            return doc;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Student getStudent(String xmlString) {
        Student student = null;

        // get <staff>
        Document doc = convertStringToDocument(xmlString);
        String id = doc.getElementsByTagName("id").item(0).getTextContent();
        String name = doc.getElementsByTagName("name").item(0).getTextContent();
        String grade = doc.getElementsByTagName("grade").item(0).getTextContent();

        student = new Student(Integer.parseInt(id), Float.parseFloat(grade), name);

        return student;
    }

    public static void main(String[] args) {
        Student student = new Student(123, 1.3f, "Peter");
        String xmlString = convertObject2XML(student);
        System.out.println(xmlString);

        Student student_r = getStudent(xmlString);
        System.out.println(student_r);
    }

}
