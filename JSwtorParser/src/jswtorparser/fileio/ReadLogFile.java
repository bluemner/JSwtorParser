package jswtorparser.fileio;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

import javax.swing.JFileChooser;

import jswtorparser.event.SwtorParser;

public class ReadLogFile {
	  static String location = new JFileChooser().getFileSystemView().getDefaultDirectory().toString()+ "\\Star Wars - The Old Republic\\CombatLogs";
	  private boolean autoUpdate=true;
	  SwtorParser parser;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public  ReadLogFile(String src){
		parser = new SwtorParser();
		 File f = new File(src);
		    if (!f.exists())
		      _e("Uable to find Swtor Folder");
		    else
		      readFile(src);
	}
	public ReadLogFile(){    
	    this(location);
	}
	/**
	 * 
	 * @param autoUpdate  look for most up-to-date file in the directory
	 */
	public ReadLogFile(boolean autoUpdate){
	    this(location);
	    this.autoUpdate=autoUpdate;
	}
	 private void readFile(String src)
	  {
	    final String want = src;
	    Thread read = new Thread(new Runnable()
	    {
	      public void run()
	      {
	        long pointer = 0L;
	        String location = want;
	        long lastCheck = System.currentTimeMillis();

	         while (parser.isRunning())
	        {
	          try {
	            RandomAccessFile raf = new RandomAccessFile(new File(location), "r");
	            raf.seek(pointer);

	            String s = raf.readLine();
	            s = s.trim();
	            pointer = raf.getFilePointer();
	            raf.close();

	            if (s != null) {
	             try {
	                if ((s.charAt(s.length() - 1) == '>') || (s.charAt(s.length() - 1) == ')'))
	                	parser.parse(s);
	              }
	              catch (Exception e) {
	                   ReadLogFile.this._e("Parsing error");
	              }
	            }

	            if (lastCheck + 60000L >= System.currentTimeMillis()) continue;
	           if(autoUpdate)
	            location =ReadLogFile.this.getCurentFile();
	           
	            lastCheck = System.currentTimeMillis();
	          }
	          catch (FileNotFoundException e)
	          {
	            e.printStackTrace();
	          }
	          catch (IOException e) {
	            e.printStackTrace();
	          } catch (NullPointerException e) {
	            
	            try
	            {
	              Thread.sleep(500L);
	            }
	            catch (InterruptedException e1) {
	              ReadLogFile.this._e("Problem Sleeping");
	            }
	          }break;
	          
	          
	        }
	        
	       
	      }
	    });
	    read.start();
	  }
	 /**
	  * 
	  * @return String location of the file that has the most recent modification
	  */
	private String getCurentFile() {
	  

	    File f = new File(location);
	    File[] files = f.listFiles();

	    File current = files[0];
	    for (File file : files)
	    {
	      if (file.lastModified() > current.lastModified()) current = file;
	    }
	    return current.getAbsolutePath();
	 }
	
	/**
	 * 
	 * @param s String to send to error
	 */
	private void _e(String s){
		System.err.println(s);
	}
}
