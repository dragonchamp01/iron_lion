package multi_purpose_hacking_project;

import java.io.File;

// use public methods.



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;


public class sql_database {
private Connection conn;
Boolean m_databaseOpen=false;
	
//================private===============

	  private void connect() {
	    
	        try {
	            // db parameters
	            String url = "jdbc:sqlite:/home/dragonchamp/Documents/java_experiments/hacker-project/hackerDB.db";
	            // create a connection to the database
	            conn = DriverManager.getConnection(url);
	            
	            System.out.println("Connection to SQLite has been established.");
	            
	        } catch (SQLException e) {
	            System.out.println(e.getMessage());
	        } 
	        
	  	
	  } // end connect()
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
private void Query(String query)
{
	
	try (
            PreparedStatement pstmt = conn.prepareStatement(query)) {
       // pstmt.setString(1, name);
       // pstmt.setDouble(2, capacity);
        pstmt.executeUpdate();
    } catch (SQLException e) {
        System.out.println(e.getMessage());
    }

}
	



private void close()
{
try {
  if (conn != null) {
      conn.close();
  }
} catch (SQLException ex) {
  System.out.println(ex.getMessage());
}


m_databaseOpen=false;


}


	  
//========================== PUBLIC METHODS================	  
public sql_database()
{
	conn=null;
	
}


public void OpenHackerDb()
{
	connect();	
	 m_databaseOpen=true;

}

public Boolean IsDatabaseOpen()
{
	
return m_databaseOpen;



}




public void InstallDb()
{
	// make 2 tables....
	// create table recon..
	String q1="create table recon (auto_id integer,ipadress text,hostname text,port text,service text,status text,os text)";
	String q2="create index  auto_id on recon (auto_id)";
	Query(q1);	
	Query(q2);	



}



public void insertVaribleIntoReconTable(String ipadress, String hostname, String service,String port, String status,String os)
{
	  
	String sql="INSERT INTO recon (ipadress,hostname,port,service,os) VALUES(?,?,?,?,?,?)";  

	try (
            PreparedStatement pstmt = conn.prepareStatement(sql)) {
     pstmt.setString(1, ipadress);
     pstmt.setString(2, hostname);
     pstmt.setString(3, service);
     pstmt.setString(4, port);
     pstmt.setString(5, status);
     pstmt.setString(6, os);
      
     pstmt.executeUpdate();
    } catch (SQLException e) {
        System.out.println(e.getMessage());
    }	
	
	
	
	
	
}



public void remove_rec_db_recon(int record)
{
	
	String sql="DELETE FROM recon WHERE auto_id="+record;

	
	try (
            PreparedStatement pstmt = conn.prepareStatement(sql)) {
       pstmt.executeUpdate();
    } catch (SQLException e) {
        System.out.println(e.getMessage());
    }	
		
	
}





public void DropTables()
{
	Query("drop table recon");

}









public Boolean DatabaseInstalled()
{
	File f = new File("/home/dragonchamp/Documents/java_experiments/hacker-project/hackerDB.db");
	if(f.exists() && !f.isDirectory()) { 
		return true;

	}

return false;

}


// open db enumerate records.
public void exportDbToHtml()
{
	
// export entire database to hackerdb.html
	HtmlWriter hwriter=new HtmlWriter("hackerdb.html");
	hwriter.WriteHTmlBegin("hacker db dump");
  //hwriter.WriteLine(null);


}


/*
 * 
 *   public void selectAll(){
        String sql = "SELECT id, name, capacity FROM warehouses";
        
        try (Connection conn = this.connect();
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)){
            
            // loop through the result set
            while (rs.next()) {
                System.out.println(rs.getInt("id") +  "\t" + 
                                   rs.getString("name") + "\t" +
                                   rs.getDouble("capacity"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
 */







public void CloseHackerDB()
{
close();

}

}