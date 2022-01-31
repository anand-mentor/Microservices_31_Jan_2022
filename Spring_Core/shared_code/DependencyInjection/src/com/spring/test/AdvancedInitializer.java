package com.spring.test;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class AdvancedInitializer { //IoC container

	private static Map<String, Object> hmapBeans = new HashMap<String, Object>();
	
	public static void main(String args[]) throws Exception {
		NodeList nodeList = readXmlFile("src/beans.xml");
		readBeans(nodeList);
		System.out.println("Order = " + hmapBeans.get("order"));
	}
	
	public static NodeList readXmlFile(String xmlFile) throws Exception {
		File fXmlFile = new File(xmlFile);
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		Document doc = dBuilder.parse(fXmlFile);
		NodeList nodeList = doc.getElementsByTagName("bean");
		return nodeList;
	}
	
	public static void readBeans(NodeList nodeList) throws Exception {
		for (int i = 0; i < nodeList.getLength(); i++) {
			Node nNode = nodeList.item(i);
			if (nNode.getNodeType() == Node.ELEMENT_NODE) {
				Element beanElement = (Element) nNode;
				String beanId = beanElement.getAttribute("id");
				String beanClassName = beanElement.getAttribute("class");
				Class beanClass = Class.forName(beanClassName);
				Object beanObj = beanClass.newInstance();
				if (!hmapBeans.containsKey(beanId)) {
					hmapBeans.put(beanId, beanObj);
				}
				NodeList propertyNodeList = beanElement.getElementsByTagName("property");
				for (int j = 0; j < propertyNodeList.getLength(); j++) {
					Node propertyNode = propertyNodeList.item(j);
					if (propertyNode.getNodeType() == Node.ELEMENT_NODE) {
						Element propertyElement = (Element) propertyNode;
						String propertyName = propertyElement.getAttribute("name");
						String methodName = "set" + propertyName.substring(0, 1).toUpperCase() + propertyName.substring(1);
						Object paramValues[] = new Object[1];
						Method beanMethods[] = beanClass.getDeclaredMethods();

						if (propertyElement.hasAttribute("value")) {
							String propertyValue = propertyElement.getAttribute("value");
							paramValues[0] = propertyValue;
						}
						else if (propertyElement.hasAttribute("ref")) {
							String propertyRef = propertyElement.getAttribute("ref");
							Object refBeanObj = hmapBeans.get(propertyRef);
							paramValues[0] = refBeanObj;
						}
						for(Method method: beanMethods){
							if (method.getName().equals(methodName)) {
								Class paramTypes[] = method.getParameterTypes();
								Class paramType = paramTypes[0];
								if (paramType.getName().equals("java.lang.Double")) {
									paramValues[0] = Double.valueOf((String)paramValues[0]);
								}
								else if (paramType.getName().equals("java.lang.Integer")) {
									paramValues[0] = Integer.valueOf((String)paramValues[0]);
								}
								method.invoke(beanObj, paramValues);
								break;
							}
						}
					}
				}
			}
		}
	}
}






