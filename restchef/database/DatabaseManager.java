package restchef.database;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

import restchef.constants.Constants;
import restchef.logic.Chef;

public class DatabaseManager implements Constants {
	
	public boolean searchChefName(String chefName) {
		
		SAXBuilder builder = new SAXBuilder();
		File xmlFile = new File(CHEF_REGISTRY_PATH);
		boolean chefExist = false;
		
		try {
			Document document = (Document) builder.build(xmlFile);
			Element rootNode = document.getRootElement();
			List<Element> list = rootNode.getChildren(CHEF);
			for (int i = 0; i < list.size(); i++) {
				Element node = (Element) list.get(i);
				if(node.getChildText(NAME).equalsIgnoreCase(chefName)) {
					chefExist = true;
					break;
				}
			}

		} catch (IOException io) {
			System.out.println(io.getMessage());
		} catch (JDOMException jdomex) {
			System.out.println(jdomex.getMessage());
		}
		return chefExist;
	}
	
	public boolean searchChefEmail(String chefEmail) {
		
		SAXBuilder builder = new SAXBuilder();
		File xmlFile = new File(CHEF_REGISTRY_PATH);
		boolean chefExist = false;
		
		try {
			Document document = (Document) builder.build(xmlFile);
			Element rootNode = document.getRootElement();
			List<Element> list = rootNode.getChildren(CHEF);
			for (int i = 0; i < list.size(); i++) {
				Element node = (Element) list.get(i);
				if(node.getChildText(EMAIL).equalsIgnoreCase(chefEmail)) {
					chefExist = true;
					break;
				}
			}

		} catch (IOException io) {
			System.out.println(io.getMessage());
		} catch (JDOMException jdomex) {
			System.out.println(jdomex.getMessage());
		}
		return chefExist;
	}

	public Chef getChef(String chefName) {
		SAXBuilder builder = new SAXBuilder();
		File xmlFile = new File(CHEF_REGISTRY_PATH);
		Chef chef = null;
		
		try {
			Document document = (Document) builder.build(xmlFile);
			Element rootNode = document.getRootElement();
			List<Element> list = rootNode.getChildren(CHEF);
			for (int i = 0; i < list.size(); i++) {
				Element node = (Element) list.get(i);
				if(node.getChildText(NAME).equalsIgnoreCase(chefName)) {
					chef = new Chef(node.getChildText(NAME),node.getChildText(EMAIL));
					break;
				}
			}

		} catch (IOException io) {
			System.out.println(io.getMessage());
		} catch (JDOMException jdomex) {
			System.out.println(jdomex.getMessage());
		}
		return chef;
	}
	/*
	public void readChefRegistry() {
		SAXBuilder builder = new SAXBuilder();
		File xmlFile = new File(CHEF_REGISTRY_PATH);

		try {

			Document document = (Document) builder.build(xmlFile);
			Element rootNode = document.getRootElement();
			List<> list = rootNode.getChildren(CHEFS);

			for (int i = 0; i < list.size(); i++) {

				Element node = (Element) list.get(i);

				System.out.println("First Name : " + node.getChildText("firstname"));
				System.out.println("Last Name : " + node.getChildText("lastname"));
				System.out.println("Nick Name : " + node.getChildText("nickname"));
				System.out.println("Salary : " + node.getChildText("salary"));

			}

		} catch (IOException io) {
			System.out.println(io.getMessage());
		} catch (JDOMException jdomex) {
			System.out.println(jdomex.getMessage());
		}
	}

	public void writeChefRegistry() {

		try {

			Element company = new Element("company");
			Document doc = new Document(company);
			doc.setRootElement(company);

			Element staff = new Element("staff");
			staff.setAttribute(new Attribute("id", "1"));
			staff.addContent(new Element("firstname").setText("yong"));
			staff.addContent(new Element("lastname").setText("mook kim"));
			staff.addContent(new Element("nickname").setText("mkyong"));
			staff.addContent(new Element("salary").setText("199999"));

			doc.getRootElement().addContent(staff);

			Element staff2 = new Element("staff");
			staff2.setAttribute(new Attribute("id", "2"));
			staff2.addContent(new Element("firstname").setText("low"));
			staff2.addContent(new Element("lastname").setText("yin fong"));
			staff2.addContent(new Element("nickname").setText("fong fong"));
			staff2.addContent(new Element("salary").setText("188888"));

			doc.getRootElement().addContent(staff2);

			// new XMLOutputter().output(doc, System.out);
			XMLOutputter xmlOutput = new XMLOutputter();

			// display nice nice
			xmlOutput.setFormat(Format.getPrettyFormat());
			xmlOutput.output(doc, new FileWriter("c:\\file.xml"));

			System.out.println("File Saved!");
		} catch (IOException io) {
			System.out.println(io.getMessage());
		}
	}

*/
}
