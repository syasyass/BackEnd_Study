package mongoex;

import org.bson.Document;
import org.bson.conversions.Bson;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class Mongo11 {

	public static void main(String[] args) {
		try (MongoClient client = new MongoClient(
				new MongoClientURI("mongodb://admin:1234@localhost:27017/admin"))) {
		// 1. 몽고 DB에 연결

		// ----------- Creating DataBase ----------------------- //
		MongoDatabase database = client.getDatabase("shop2");
		
		Bson proj = new Document("_id", 0)
						.append("name", 1)
						.append("age", 1)
						.append("office", 1);
		
//		Bson proj = Projections.include("name", "age");
//		Bson proj = Projections.exclude("office", "phone");
//		
//		Bson proj = Projections.fields(
//					Projections.excludeId(),
//					Projections.include("name", "age");
//		);
		
		Bson sort = new Document("name", 1).append("age", -1);
		
		MongoCollection<Document> collection = database.getCollection("memo");
		FindIterable<Document> result = collection.find()
											.projection(proj)
											.sort(sort)
											.skip(5)
											.limit(10);
		
		for(Document doc : result) {
			System.out.println("AGE: " + doc.getInteger("age") + ", ");
			System.out.println("NAME: " + doc.getString("name") + ", ");
			System.out.println("OFFICE: " + doc.getString("office"));
		}
		
		
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
