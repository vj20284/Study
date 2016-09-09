package com.test;

import org.w3c.dom.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.util.*;

public class XmlCompare {

    public static void Compare(String xmlFile1, String xmlFile2) {
        Document dom1 = parseXmlFile(xmlFile1);
        MyNode root1 = parseDocument(dom1);

        Document dom2 = parseXmlFile(xmlFile2);
        MyNode root2 = parseDocument(dom2);

        compareNode(root1, root2);
    }


    private static Document parseXmlFile(String xmlFile){
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        Document dom = null;
        try {
            DocumentBuilder db = dbf.newDocumentBuilder();
            dom = db.parse(xmlFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dom;
    }


    private static MyNode parseDocument(Document dom){
        Element docEle = dom.getDocumentElement();
        MyNode root = new MyNode(docEle);
        // Convert from dom to internal tree representation
        traverseElement(docEle, root);
        return root;
    }

    private static void traverseElement(Element element, MyNode node) {
        System.out.println(element.getTagName());
        traverseNode(element, node);
        NodeList nl = element.getChildNodes();
        if(nl != null && nl.getLength() > 0) {
            for (int i = 0; i < nl.getLength(); i++) {
                Node n = nl.item(i);
                if (n instanceof Element) {
                    Element e = (Element) nl.item(i);
                    MyNode child = new MyNode(e);
                    traverseElement(e, child);
                    node.children.add(child);
                }
            }
        }
    }

    private static void traverseNode(Node n1, MyNode n2) {
        NamedNodeMap nodeMap = n1.getAttributes();
        if (nodeMap != null && nodeMap.getLength() > 0) {
            for (int i = 0; i < nodeMap.getLength(); i++) {
                Node node = nodeMap.item(i);
                if (node instanceof Element) {
                    Element e = (Element)node;
                    traverseElement(e, new MyNode(e));
                } else {
                    MyNode leaf = new MyNode(node);
                    n2.children.add(leaf);
                    System.out.println(node.getNodeName() + ":" + node.getNodeValue());
                }
            }
        }
    }

    private static void compareNode(MyNode node1, MyNode node2) {
        System.out.println("\n\nComparision Results");
        System.out.println("-------------------");
        List<String> differences = new ArrayList<String>();
        Queue<MyNode> q1 = new LinkedList<MyNode>();
        Queue<MyNode> q2 = new LinkedList<MyNode>();

        q1.add(node1);
        q2.add(node2);

        while (!q1.isEmpty() && !q2.isEmpty()) {
            MyNode tmp1 = q1.remove();
            MyNode tmp2 = q2.remove();

            if (tmp1.compareTo(tmp2) != 0) {
                differences.add("Difference : " + tmp1 + " " + tmp2);
            }
            Collections.sort(tmp1.children);
            Collections.sort(tmp2.children);
            for (MyNode child : tmp1.children) {
                q1.add(child);
            }
            for (MyNode child : tmp2.children) {
                q2.add(child);
            }
        }

        if (differences.size() == 0) {
            System.out.println("XMLs are same!!");
        } else {
            System.out.println("Differences");
            for (String s : differences) {
                System.out.println(s);
            }
        }
    }

    private static class MyNode implements Comparable<MyNode> {
        public String tagName = "";
        public boolean isLeaf = false;
        public String attributeName = "";
        public String attributeValue = "";
        public List<MyNode> children = new ArrayList<MyNode>();

        public MyNode(Element e) {
            this.tagName = e.getTagName();
            this.isLeaf = e.getChildNodes().getLength() == 0 ? true : false;
        }

        public MyNode(Node n) {
            this.attributeName = n.getNodeName();
            this.attributeValue = n.getNodeValue();
            this.isLeaf = true;
        }

        @Override
        public int compareTo(MyNode o) {
            if (!this.tagName.equals(o.tagName))
                return this.tagName.compareTo(o.tagName);

            if (!this.attributeName.equals(o.attributeName))
                return this.attributeName.compareTo(o.attributeName);

            if (!this.attributeValue.equals(o.attributeValue))
                return this.attributeValue.compareTo(o.attributeValue);

            if (this.children.size() > 0 || o.children.size() > 0) {
                int cc = compareChildren(this.children, o.children);
                if (cc != 0)
                    return cc;
            }
            return 0;
        }

        public int compareChildren(List<MyNode> children1, List<MyNode> children2) {
            if (children1.size() != children2.size())
                return children1.size() < children2.size() ? - 1 : 1;
            Collections.sort(children1);
            Collections.sort(children2);
            for (int i = 0; i < children1.size(); i++) {
                MyNode c1 = children1.get(i);
                MyNode c2 = children2.get(i);
                int rc = c1.compareTo(c2);
                if (rc != 0)
                    return rc;
            }
            return 0;
        }

        public String toString() {
            return this.tagName.length() > 0 ? this.tagName : this.attributeName + ":" + this.attributeValue;
        }
    }

    public static void main(String[] args){
        XmlCompare.Compare("transactions.xml", "transactions2.xml");
    }
}