package mongoex;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;
import org.bson.conversions.Bson;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Updates;

public class Mongo9 {

	public static void main(String[] args) {
		try (MongoClient client = new MongoClient(
				new MongoClientURI("mongodb://winner:1234@localhost:27017/shop2"))) {
		// 1. 몽고 DB에 연결

		// ----------- Creating DataBase ----------------------- //
		MongoDatabase database = client.getDatabase("shop2");
		// ----------- Creating Collection ----------------------- //
		MongoCollection<Document> collection = database.getCollection("member");
		
		// 4. CRUD (updateOne(document))
		// 업데이트 할 조건
		Document filter = new Document();
		filter.append("id", "apple4");
		
		// 업데이트 할 내용이 많은 경우,
		// 1) Bson 객체로 각각을 만든다.
		Bson update = Updates.set("name", "happy");
		Bson update2 = Updates.set("tel", "5555");
			
		// 2) Bson 객체의 list를 만든다.
		List<Bson> list = new ArrayList<>();
		list.add(update);
		list.add(update2);
		
		// Bson 가변 매개변수를 이용하는 방법도 있음
		
		// 3) list를 Bson으로 만들어준다.
		Bson all = Updates.combine(list);
		
		// updateOne(bson, bson) --> updateOne(json, json)
		collection.updateOne(filter, all);
		client.close();			
		System.out.println("==== updateOne 성공 ====");
		
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
