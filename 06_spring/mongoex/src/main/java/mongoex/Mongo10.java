package mongoex;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.bson.Document;
import org.bson.conversions.Bson;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class Mongo10 {

	public static void main(String[] args) {
		try (MongoClient client = new MongoClient(
				new MongoClientURI("mongodb://admin:1234@localhost:27017/admin"))) {
		// 1. 몽고 DB에 연결

		// ----------- Creating DataBase ----------------------- //
		MongoDatabase database = client.getDatabase("shop2");
		// ----------- Creating Collection ----------------------- //
		MongoCollection<Document> collection = database.getCollection("member");
		
		Bson filter2 = new Document("name", 1);
		
		FindIterable<Document> result = collection.find().sort(filter2);
		
		System.out.println("----------------");
		System.out.println(result.first());
		System.out.println(result.first().containsKey("name"));
		System.out.println(result.first().containsKey("Peter John"));
		System.out.println("----------------");
		
		for (Document document : result) {
			System.out.println(document.get("id") + "\t");
			System.out.println(document.get("pw") + "\t");
			System.out.println(document.get("name") + "\t");
			System.out.println(document.get("tel") + "\t");
			System.out.println();
		}

		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("id", result.first().get("id"));
		map.put("pw", result.first().get("pw"));
		map.put("name", result.first().get("name"));
		map.put("tel", result.first().get("tel"));
		System.out.println("----------------");
		
		System.out.println(map);
		
		ArrayList<Map> list = new ArrayList<Map>();
		for (Document doc : result) {
			Map<String, Object> map2 = new HashMap<String, Object>();
			map2.put("id", doc.get("id"));
			map2.put("pw", doc.get("pw"));
			map2.put("name", doc.get("name"));
			map2.put("tel", doc.get("tel"));
			list.add(map2);
		}
		
		System.out.println("----------------");
		System.out.println(list);
		
		// vo 객체 사용
		ArrayList<UserVO> list2 = new ArrayList<UserVO>();
		for (Document docu : result) {
			UserVO vo = new UserVO();
			vo.setId(docu.getString("id"));
			vo.setPw(docu.getString("pw"));
			vo.setName(docu.getString("name"));
			vo.setTel(docu.getString("tel"));
			list2.add(vo);
		}
		
		System.out.println("----------------");
		System.out.println(list2);		
		
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
