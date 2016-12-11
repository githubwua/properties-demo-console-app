package wua.eg.properties;

import java.io.FileInputStream;

/*
Reference:
  
https://docs.oracle.com/javase/tutorial/essential/environment/sysprop.html
https://docs.oracle.com/javase/tutorial/essential/environment/properties.html
*/

import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.Properties;

public class App {
	public static void main(String[] args) throws Exception {

		// To inject system properties into my properties, uncomment this line
		// Properties p = new Properties(System.getProperties());
		Properties p = new Properties(); // use new empty properties

		try {
			// load my properties from file "myProperties.txt"
			// InputStream in = App.class.getResourceAsStream("/myProperties.txt");
			// p.load(in);
			InputStream in = new FileInputStream("test.xml");
			p.loadFromXML(in);
			in.close();
		} catch (Exception e) {
			System.out.println("Exception: " + e.getMessage());
		}

		// Display my properties
		p.list(System.out);

		// If needed, uncomment this line to inject my properties into system properties
		// System.setProperties(p);
		// System.getProperties().list(System.out); // display system properties

		// Add a few new properties and save them
		p.put("db.user", "root");
		p.put("db.password", "日本語パスワード");
		p.put("db.name", "employees");
		p.put("db.hostname", "xyz");
		p.put("db.port", "123");
		//FileOutputStream os = new FileOutputStream(App.class.getResource("/").getPath() + "/myProperties.txt");
		//p.store(os, "最強アプリケーションの設定ファイル");
		//os.close();

		// Save properties into an XML file
		FileOutputStream fos = new FileOutputStream("test.xml");
		p.storeToXML(fos, "超普通のアプリケーションの設定ファイル", "UTF-8");
	}
}
