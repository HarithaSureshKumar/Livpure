package file.read.pkg;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class FileRead 
{
	public static XSSFSheet readF(String fname, String shname) throws IOException
	{
		File f=new File("Data/"+fname);
		FileInputStream fis= new FileInputStream(f);
		System.out.println("File Opened Sucessfully");
		XSSFWorkbook wk=new XSSFWorkbook(fis);

		XSSFSheet sh= wk.getSheet(shname);
		
		return sh;
		
	}

}
