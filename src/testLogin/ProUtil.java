package testLogin;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.omg.Messaging.SyncScopeHelper;

public class ProUtil {
	private Properties prop;
	private	String filePath;
	
	/*
	 * 构造方法
	 */
	public ProUtil(String filePath) {
		this.filePath = filePath;
		this.prop = readProperties();
	}
	
	
	/*
	 * 读取配置文件 8)
	 */
	private Properties readProperties() {
		Properties properties = new Properties();
		try {
			InputStream inputStream = new FileInputStream(filePath);
			InputStream in = new BufferedInputStream(inputStream);
			properties.load(in);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return properties;
	} 
	
	
	public String getPro(String key) {
		if (prop.containsKey(key)) {
			String username = prop.getProperty(key);
			return username;
		}else {
			System.out.println("key不对");
			return "";
		}
		
	}
//	public static void main(String[] args) throws Exception {
//		ProUtil pro = new ProUtil();
//		pro.getPro();
//	}
	 
}
