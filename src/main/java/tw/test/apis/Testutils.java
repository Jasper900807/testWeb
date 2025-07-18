package tw.test.apis;

import java.awt.datatransfer.StringSelection;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.SortedMap;
import java.util.TreeMap;

import org.json.JSONArray;
import org.json.JSONObject;

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
	
	public static SortedMap[] parseFood(String json) {
		JSONArray root = new JSONArray(json);
		TreeMap<String, String>[] foods = new TreeMap[root.length()];		
		for (int i=0; i<root.length(); i++) {
			try {
				JSONObject food = root.getJSONObject(i);
				
				TreeMap<String, String> map = new TreeMap<String, String>();
				map.put("name", food.getString("Name"));
				map.put("tel", food.getString("Tel"));
				map.put("addr", food.getString("Address") + food.getString("City") + food.getString("Town"));
				
				foods[i] = map;				
			} catch (Exception e) {
				System.out.println(e + ":" + i);
			}
		}
		return foods;
	}
	
	public static String orderToJSON(SortedMap[] rows) {
		JSONObject root = new JSONObject();
		if (rows.length > 0) {
			root.put("customer", String.format("%s (%s)", 
					rows[0].getOrDefault("ContactName", ""), 
					rows[0].getOrDefault("CompanyName", "")));
			root.put("employee", String.format("%s %s", 
					rows[0].getOrDefault("FirstName", ""), 
					rows[0].getOrDefault("LastName", "")));
			
			double total = 0;
			JSONArray details = new JSONArray();
			for (SortedMap<String, String> row :rows) {
				JSONObject obj = new JSONObject();
				obj.put("pid", row.getOrDefault("ProductID", ""));
				obj.put("pname", row.getOrDefault("ProductName", ""));
				obj.put("price", row.getOrDefault("UnitPrice", ""));
				obj.put("qty", row.getOrDefault("Quantity", ""));
				
				double price = Double.parseDouble(obj.get("price").toString());
				int qty = Integer.parseInt(obj.get("qty").toString());
				double sum = price*qty;
				obj.put("sum", price*qty);
				
				total += sum;
				
				details.put(obj);
			}
			root.put("details", details);
			root.put("total", total);
		}
		return root.toString();
	}
}
