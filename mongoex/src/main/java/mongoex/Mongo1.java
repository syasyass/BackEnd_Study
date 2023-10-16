package mongoex;

import org.bson.Document;
import org.bson.conversions.Bson;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class Mongo1 {

	public static void main(String[] args) {
//		Bson filter = new Document("job", "admin.");
		
		MongoClient client = new MongoClient(
				new MongoClientURI("mongodb://winner:1234@localhost:27017/shop2"));		
		MongoDatabase database = client.getDatabase("shop2");
		
		MongoCollection<Document> collection = database.getCollection("memo");
		
		FindIterable<Document> result = collection.find();
		System.out.println(result.first());				
	}

}
