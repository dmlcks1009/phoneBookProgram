package kr.or.mrhi.sixclass;

import java.io.FileReader;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class DBUtility {
	public static Connection getConnection() {
		Connection con = null;
		//Properties driver, url, userID, userPassword read
				try {
					// 
					Properties properties = new Properties();
					String filePath = DataBaseTest.class.getResource("db.properties").getPath();
					filePath = URLDecoder.decode(filePath, "utf-8");
					properties.load(new FileReader(filePath));
					//바인딩하기
					String driver = properties.getProperty("DRIVER");
					String url = properties.getProperty("URL");
					String userID = properties.getProperty("userID");
					String userPassword = properties.getProperty("userPassword");
					// 드라이버 로드
					Class.forName(driver);
					//DB연결
					con = DriverManager.getConnection(url, userID, userPassword);
				} catch (Exception e1) {
					System.out.println("MySQL Database connection failed");
					e1.printStackTrace();
				}
		return con;
	}
}
