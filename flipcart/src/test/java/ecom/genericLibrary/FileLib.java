package ecom.genericLibrary;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;


public class FileLib {
	
	public String getPropertyKeyValue(String path,String key)
	{
		FileInputStream ip=null;
		Properties prop=null;
		try 
		{
			ip=new FileInputStream(path);
			prop=new Properties();
			prop.load(ip);
		}
		catch(Throwable ob)
		{
			ob.getMessage();
		}
		return prop.getProperty(key);
	}
	
	public String getExcelData(String path,String sheet,int rowNum,int colNum)
	{
		FileInputStream ip=null;
		Workbook wb=null;
		try
		{
			ip=new FileInputStream(path);
			wb=WorkbookFactory.create(ip);
		}
		catch(Throwable ob)
		{
			ob.getMessage();
		}
		
		return wb.getSheet(sheet).getRow(rowNum).getCell(colNum).toString();
	}
}
