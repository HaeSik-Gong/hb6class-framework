package com.hb.day01.model;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

public class DataParser {

	public DataParser(String url) {
		try {
			Document document = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(url);
			XPath xpath = XPathFactory.newInstance().newXPath();

			String expression = "//*/person";
			NodeList cols = (NodeList) xpath.compile(expression).evaluate(document, XPathConstants.NODESET);

			for (int idx = 0; idx < cols.getLength(); idx++) {

				String ssn = cols.item(idx).getAttributes().item(0).getTextContent();
				System.out.println("ssn................" + ssn);

				expression = "//*[@ssn=" + ssn + "]/firstName";
				String firstName = xpath.compile(expression).evaluate(document);
				System.out.println("firstName................" + firstName);
				expression = "//*[@ssn=" + ssn + "]/lastName";
				String lastName = xpath.compile(expression).evaluate(document);
				System.out.println("lastName................" + lastName);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
