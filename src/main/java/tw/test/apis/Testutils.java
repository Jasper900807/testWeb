package tw.test.apis;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class Testutils {
	public static String loadView() throws IOException {
		String source = "C:\\Users\\User\\eclipse-workspace\\testWeb\\src\\main\\webapp\\views\\view1.html";
		File html = new File(source);
		BufferedInputStream bin = new BufferedInputStream(new FileInputStream(html));
		
		byte[] data = bin.readAllBytes();
		bin.close();
		
		return new String(data);
	}
	
	public static String loadView(String view) throws IOException {
		String source = String.format("C:\\Users\\User\\eclipse-workspace\\testWeb\\src\\main\\webapp\\views\\%s.html", view);
		File html = new File(source);
		BufferedInputStream bin = new BufferedInputStream(new FileInputStream(html));
		
		byte[] data = bin.readAllBytes();
		bin.close();
		
		return new String(data);
	}
	
	public static String calc(String sx, String sy, String op) {
		try {
			int x = Integer.parseInt(sx);
			int y = Integer.parseInt(sy);
			switch (op) {
			case "1": return x + y + ""; 
			case "2": return x - y + "";
			case "3": return x * y + "";
			case "4": return x / y + "..." + x % y;
			default: return "";
			}
			
						
		} catch (Exception e) {
			return "";
		}
	}
	
	public static String createScore() {
		System.out.println("create");
		return (int)(Math.random()*101) + "";
	}
}
