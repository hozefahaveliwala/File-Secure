import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class Parameters {

	/**
	 * @param args
	 * @throws FileNotFoundException
	 */

	private String AbsolutePath, inputfilepath, inputfilename, mode,
			 encryptedfilepath, encryptedfilename,
			dencryptedfilepath, dencryptedfilename;

	Parameters() throws ParserConfigurationException, SAXException, IOException {
		/*
		 * // AbsolutePath = new File("").getAbsolutePath(); AbsolutePath =
		 * "C:\\Users\\Admin\\Desktop"; // System.out.println(AbsolutePath);
		 * FileReader in = new FileReader(AbsolutePath + File.separator +
		 * "parameters.txt"); BufferedReader br = new BufferedReader(in); mode =
		 * br.readLine(); // path = br.readLine(); // filename = br.readLine();
		 * in.close();
		 */

		parsexml();

	}

	private void parsexml() throws ParserConfigurationException, SAXException,
			IOException {
		 AbsolutePath = new File("").getAbsolutePath();
		//AbsolutePath = "C:\\Users\\Admin\\Desktop";
		 System.out.println(AbsolutePath);
		File fXmlFile = new File(AbsolutePath + File.separator
				+ "parameters.xml");
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		Document doc = dBuilder.parse(fXmlFile);
		doc.getDocumentElement().normalize();

		if (doc.getDocumentElement().getNodeName().equals("parameters") == true) {
			NodeList nList = doc.getElementsByTagName("parameters");
			for (int temp = 0; temp < nList.getLength(); temp++) {

				Node nNode = nList.item(temp);

				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
					Element eElement = (Element) nNode;
					this.mode = eElement.getAttribute("mode");
					this.inputfilepath = eElement.getAttribute("inputfilepath");
					this.inputfilename = eElement.getAttribute("inputfilename");
					this.encryptedfilepath = eElement
							.getAttribute("encryptedfilepath");
					this.encryptedfilename = eElement
							.getAttribute("encryptedfilename");
					this.dencryptedfilepath = eElement
							.getAttribute("dencryptedfilepath");
					this.dencryptedfilename = eElement
							.getAttribute("dencryptedfilename");
					
					
				}
			}
		}

		//System.out.println(mode + inputfilename + inputfilepath + encryptedfilename
			//	+ encryptedfilepath);
	}

	public String getinputfilepath() {
		return inputfilepath;
	}

	public String getInputfilename() {
		return inputfilename;
	}

	public String getMode() {
		return mode;
	}


	public String getEncryptedfilepath() {
		return encryptedfilepath;
	}

	public String getEncryptedfilename() {
		return encryptedfilename;
	}

	public String getDencryptedfilepath() {
		return dencryptedfilepath;
	}

	public String getDencryptedfilename() {
		return dencryptedfilename;
	}

}
