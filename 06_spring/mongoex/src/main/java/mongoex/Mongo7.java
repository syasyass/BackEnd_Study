package mongoex;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class Mongo7 {

	public static void main(String[] args) {
		try (MongoClient client = new MongoClient(
				new MongoClientURI("mongodb://winner:1234@localhost:27017/shop2"))) {
		// ----------- Connecting DataBase --------------------- //

		// ----------- Creating DataBase ----------------------- //
		MongoDatabase database = client.getDatabase("shop2");
		// ----------- Creating Collection ----------------------- //
		MongoCollection<Document> collection = database.getCollection("member");
		
		Document doc = new Document();
//		doc.append("id", "apple3");
//		doc.append("pw", "1234");
		
		collection.deleteMany(doc); // 빈 조건을 주면 모두 삭제 됨
		client.close();					
		System.out.println("==== deleteMany 성공 ====");
		
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
