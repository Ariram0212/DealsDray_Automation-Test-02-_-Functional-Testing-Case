package datautility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class DataUtility {
	public String fetchData(String key) throws IOException
	{
		FileInputStream path=new FileInputStream("./data/sele.properties");
		Properties prop=new Properties();
		prop.load(path);
		String data=prop.getProperty(key);
		return data;
	}
}
