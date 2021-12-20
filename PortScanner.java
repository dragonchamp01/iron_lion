package multi_purpose_hacking_project;
import java.io.File;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.io.IOException;
//A simple little script that will parse nmap files run with
//nmap xxx.xxx.xxx.xxx -PN -O -oX output.xml
//into a HTML or XLS flat table


import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
/*
NmapTest1 nmapTest1 = new NmapTest1();
String str = nmapTest1.getReturnData("D:\\nmap\\nmap.exe","-sS -P0 -A -v www.zifangsky.cn");
System.out.println(str);
*/
import org.xml.sax.SAXException;



    
    class PortScanner {
    	Process process = null;
    	
    	sql_database m_DB=null;
    	
private  String IPtoHostname(String ip)
 {
	 
	 InetAddress addr = null;
	try {
		addr = InetAddress.getByName(ip);
	} catch (UnknownHostException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  String host = addr.getHostName();	 
	 return host;
	 
	 
	 
 }
    	
    	// nmap ip command
    	public void NmapScan(String nmapDir,String IP, String command) {	
    		
    		command += " " + " -oX output.xml";
    		
    		
    		StringBuffer stringBuffer = new StringBuffer ();
    			try {
					process = Runtime.getRuntime (). exec (nmapDir + " " + IP + " " + command);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
    			System.out.println ("Please wait ...");

    		
    	
    			BufferedReader reader = null;
				try {
					reader = new BufferedReader (new InputStreamReader (process.getInputStream (), "UTF-8"));
				} catch (UnsupportedEncodingException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
    			String line = null;			
    			try {
					while ((line = reader.readLine ())!= null) {
						stringBuffer.append (line + "\n");
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
    		
    			
    			
    			
    			try {
					ParseNmapXML("output.xml");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ParserConfigurationException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SAXException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
    			
    	
    	
    	}
    	
    		

    	
    	
private void ParseNmapXML(String XmlFile)
		throws IOException, ParserConfigurationException,
		org.xml.sax.SAXException {
	
	
	m_DB.OpenHackerDb();
	
	String Hostname=null;
	
	
	
			try {
	            //System.out.println("<table border=1><tr><th>IP Address</th><th>Port Number</th><th>Service Name</th><th>Status</th><th>Host OS</th></tr>");
	            
	         //   for (int src = 0; src < XmlFile.length; src++)
	         //   {
	            File file = new File(XmlFile); //[src]);
	            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
				DocumentBuilder db = dbf.newDocumentBuilder();
				Document doc = db.parse(file);
				doc.getDocumentElement().normalize();
				NodeList nodeLst = doc.getElementsByTagName("nmaprun");
	            String ipAddr = null;
	            String portItem = null;
	            String portState = null;
	    //        String osItem = null;
	            String nameItem = null;
	            String osList = "";
	            ArrayList<String> itemSet = new ArrayList<String>();
	            ArrayList<String> stateSet = new ArrayList<String>();
	            ArrayList<String> nameSet = new ArrayList<String>();
	            ArrayList<String> ipSet = new ArrayList<String>();
	            ArrayList<String> osSet = new ArrayList<String>();
	            
				for (int s = 0; s < nodeLst.getLength(); s++) {
					
					Node fstNode = nodeLst.item(s);
					
					if (fstNode.getNodeType() == Node.ELEMENT_NODE) {
						
						Element fstElmnt = (Element) fstNode;
						NodeList fstNmElmntLst = fstElmnt.getElementsByTagName("host");

						for (int i=0; i < fstNmElmntLst.getLength(); i++)
						{
							Element fstNmElmnt = (Element) fstNmElmntLst.item(i);
							
							if(fstNmElmnt.hasChildNodes())
							{
								NodeList riBody = fstNmElmnt.getChildNodes();
								
								for (int x=0; x < riBody.getLength(); x++)
								{
									if (riBody.item(x).getNodeName()=="address")
	                                {
	                                    if (riBody.item(x).getAttributes().getNamedItem("addrtype").getNodeValue().compareTo("ipv4")==0)
	                                    {
	                                        ipAddr = riBody.item(x).getAttributes().getNamedItem("addr").getNodeValue();
	                                    }
	                                }
	                                
	                                if((riBody.item(x)).hasChildNodes())
									{
	                                    if (riBody.item(x).getNodeName()=="ports")
	                                    {
	                                        NodeList portBody = riBody.item(x).getChildNodes();
	                                    
	                                        for (int y=0; y < portBody.getLength(); y++)
	                                        {
	                                            if (portBody.item(y).getNodeName()=="port")
	                                            {
	                                                portItem = portBody.item(y).getAttributes().getNamedItem("portid").getNodeValue();
	                                                
	                                                NodeList subBody = portBody.item(y).getChildNodes();
	                                                
	                                                for (int z=0; z < subBody.getLength(); z++)
	                                                {
	                                                    if (subBody.item(z).getNodeName()=="state")
	                                                    {
	                                                        portState = subBody.item(z).getAttributes().getNamedItem("state").getNodeValue();
	                                                    }
	                                                    if (subBody.item(z).getNodeName()=="service")
	                                                    {                                        
	                                                        nameItem = subBody.item(z).getAttributes().getNamedItem("name").getNodeValue();
	                                                        ipSet.add(ipAddr);
	                                                        nameSet.add(nameItem);
	                                                        itemSet.add(portItem);
	                                                        stateSet.add(portState);
	                                                    }
	                                                }
	                                            }
	                                        }
	                                    }
	                                    if (riBody.item(x).getNodeName()=="os")
	                                    {
	                                        NodeList osBody = riBody.item(x).getChildNodes();
	                                        
	                                        for (int t=0; t < osBody.getLength(); t++)
	                                        {
	                                            if (osBody.item(t).getNodeName()=="osmatch")
	                                            {
	                                                osSet.add(osBody.item(t).getAttributes().getNamedItem("name").getNodeValue());
	                                            }
	                                        }
	                                        for (int a = 0; a < osSet.size(); a++)
	                                        {
	                                  //          osList = osSet.get(a) + "<br>" + osList ;
	                                            osList = osSet.get(a) + "\r\n" + osList ;
	    	                                    
	                                        
	                                        
	                                        }
	                                        for (int a = 0; a < itemSet.size(); a++)
	                                        {
	                                           // insert into hackerdb.db here. 
	                               //             System.out.println("<tr><td>" + ipSet.get(a) + "</td><td>" + itemSet.get(a) + "</td><td>" + nameSet.get(a) + "</td><td>" + stateSet.get(a) + "</td><td>" + osList +"</td></tr>");
	                                       Hostname=IPtoHostname(ipSet.get(a));
	                                        // 2do:ip2hostname
	                                        m_DB.insertVaribleIntoReconTable(ipSet.get(a),Hostname,itemSet.get(a), nameSet.get(a),  stateSet.get(a) ,  osList );
	                                        // ip,hostname,service,port,status,os
	                                        Hostname=null;
	                                        }
	                                        ipSet.clear();
	                                        nameSet.clear();
	                                        itemSet.clear();
	                                        stateSet.clear();
	                                        osSet.clear();
	                                        osList = "";
	                                    }
	                                }
								}
							}
	                    } 
					}
				}
	       //     }
	       // System.out.println("</table>");
	        m_DB.CloseHackerDB();
	        
			} catch (Exception e) {
				e.printStackTrace();
			} 
		}
	
    
  
    
    }
    	
    	
    