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
	
	
	

public void PrintMenu()
{


System.out.print("Iron lion project v1.0 \r\n");
System.out.print("================================= \r\n");
System.out.print("1: port scan enter  range x.x.x.x.x/256 \r\n");
System.out.print("2: enter sql query \r\n");
System.out.print("3: exploit ftp :enter hostip \r\n");


}
	
	
public void ReadInput()
		throws IOException {
			InputStreamReader isr =	new InputStreamReader(System.in);
			BufferedReader br = new BufferedReader(isr);
		
			menu_input = br.readLine();
if(menu_input=="1")
{
System.out.print("-->");
cmd_Input=br.readLine();
// do something with cmd_input


}			
			
			//	System.out.println(input);
			
}



	
} // end class
