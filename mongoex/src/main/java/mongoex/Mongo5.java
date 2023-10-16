package mongoex;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class Mongo5 {

	public static void main(String[] args) {
			// ----------- Connecting DataBase --------------------- //
			MongoClient client = new MongoClient(
					new MongoClientURI("mongodb://winner:1234@localhost:27017/shop2"));
			// ----------- Creating DataBase ----------------------- //
			MongoDatabase database = client.getDatabase("shop2");
			// ----------- Creating Collection ----------------------- //
			MongoCollection<Document> collection = database.getCollection("member");

			Document filter = new Document("id", "apple");
			// filter.append("id", "apple");
			Document proj = new Document("id", 1);
			proj.append("name", 1); // 아직 못 씀.
			
			FindIterable<Document> result = collection.find(filter);
			
			for(Document doc : result) {
				System.out.println("ID: " + doc.getString("id") + ", ");
				System.out.println("PW: " + doc.getString("pw") + ", ");
				System.out.println("NAME: " + doc.getString("name") + ", ");
				System.out.println("TEL: " + doc.getString("tel"));
			}
	}

}
