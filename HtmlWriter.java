package multi_purpose_hacking_project;
import java.io.*;




// purpose : export data to TABLE and make table heads.......
// usage
// new class =HtmlWriter
// void WriteHTmlBegin(String title)
// WriteLine(String html_line)
// void WriteHtmlEnd()
// thats it

public class HtmlWriter {

// =========== private =============	
	
	
private String m_File;
private String m_Buffer;
private FileOutputStream m_Fos;
private  Writer m_Writer;

private void Write(String data)
{
try {
	m_Writer.write(data);
} catch (IOException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}	
try {
	m_Writer.flush();
} catch (IOException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
}



	
private void close()	
{
try {
	m_Writer.close();
} catch (IOException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}



}





// ============ public===================


public HtmlWriter(String File)
{
	m_File=null;
	m_Buffer=null;
	m_Fos=null;
	m_Writer=null;
	
			
	
	
	
	m_File=File;
    try {
		m_Fos = new FileOutputStream(m_File);
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    try {
		m_Writer=  new BufferedWriter(new OutputStreamWriter(m_Fos, "utf-8"));
	} catch (UnsupportedEncodingException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
   
}
	

	


public void WriteHTmlBegin(String title)
{
m_Buffer="<html><head><title>"+title;
m_Buffer+="</title></head><body><hr><h3>"+title +"</h3><hr><br>";

	
	
	Write(m_Buffer);

m_Buffer="";
	
}

public void WriteLine(String html_line)
{
m_Buffer=html_line;	
Write(m_Buffer);

m_Buffer="";
}


public void WriteHtmlEnd()
{
m_Buffer="</body></html>";
Write(m_Buffer);

m_Buffer="";
close();

}


	
	
}
