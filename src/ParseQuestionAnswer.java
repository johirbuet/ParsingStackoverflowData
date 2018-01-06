import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class ParseQuestionAnswer {
	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
		String url = "/Users/mislam/Desktop/Stackoverflow data/3dprinting.meta.stackexchange.com/Posts.xml";
		File  xmlFile = new File(url);
		DocumentBuilderFactory dbfactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dbuilder = dbfactory.newDocumentBuilder();
		Document doc = dbuilder.parse(xmlFile);
		System.out.println("Root: " + doc.getDocumentElement().getNodeName());
		NodeList nodes = doc.getElementsByTagName("row");
		System.out.println(nodes.getLength());
		for(int i =0;i<nodes.getLength();i++) {
			Node node = nodes.item(i);
			Element e = (Element) node;
			System.out.println(e.getAttribute("Id"));
		}
	}
	private class Question {
		public int id;
		public String creationDate;
		
	}
}
