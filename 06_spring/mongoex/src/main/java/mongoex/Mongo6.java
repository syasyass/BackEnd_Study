package mongoex;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class Mongo6 {

	public static void main(String[] args) {
		try (MongoClient client = new MongoClient(
				new MongoClientURI("mongodb://winner:1234@localhost:27017/shop2"))) {
		// ----------- Connecting DataBase --------------------- //

		// ----------- Creating DataBase ----------------------- //
		MongoDatabase database = client.getDatabase("shop2");
		// ----------- Creating Collection ----------------------- //
		MongoCollection<Document> collection = database.getCollection("member");
		
		Document filter = new Document("id", "apple");
		
		collection.deleteOne(filter);
		client.close();					
		System.out.println("==== deleteOne 성공 ====");
		
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
