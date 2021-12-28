package multi_purpose_hacking_project;
//import multi_purpose_hacking_project.sql_database;
//import java.io.File;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;




public class jmenu {
static	sql_database  m_DB = null;
	String menu_input=null;
	String cmd_Input=null;
jmenu()
{
	if(m_DB.IsDatabaseOpen()==false)
	{
		m_DB.OpenHackerDb();
	
	}

	
	
	
	
	if(m_DB.DatabaseInstalled()==false)
	{
		m_DB.InstallDb();
		System.out.print("Hackerdb tables installed \r\n");
					
		}	


}
	
	
	

private void PrintMenu()
{


System.out.print("Iron lion project v1.0 \r\n");
System.out.print("================================= \r\n");
System.out.print("1: port scan enter  range x.x.x.x.x/256 \r\n");
System.out.print("2: enter sql query \r\n");
System.out.print("3: exploit ftp :enter hostip \r\n");
System.out.print("4: exit \r\n");


}
	
	
public void RunMenu()
		throws IOException {
			InputStreamReader isr =	new InputStreamReader(System.in);
			BufferedReader br = new BufferedReader(isr);

			
			PortScanner m_portscanner=new PortScanner();
			
			
			PrintMenu();		
			menu_input = br.readLine();

// port scan			
// stores results in hacker db.
			
if(menu_input=="1")
{
System.out.print("-->");
cmd_Input=br.readLine();
m_portscanner.NmapScan("nmap",cmd_Input,"-sV ");

}			

// sql query
else if(menu_input=="2")
{
System.out.print("-->");
cmd_Input=br.readLine();

// do something with cmd_input


}			

//exploit host
else if(menu_input=="3")
{
System.out.print("-->");
cmd_Input=br.readLine();
//do something with cmd_input


}			

//exit
else if(menu_input=="3")
{
//System.out.print("-->");
//cmd_Input=br.readLine();
//do something with cmd_input


}			






}



	
} // end class
