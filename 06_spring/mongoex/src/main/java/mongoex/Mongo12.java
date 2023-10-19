package mongoex;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;
import org.bson.conversions.Bson;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Updates;

public class Mongo12 {

	public static void main(String[] args) {
		try (MongoClient client = new MongoClient(
				new MongoClientURI("mongodb://admin:1234@localhost:27017/admin"))) {
		// ----------- Connecting DataBase --------------------- //

		// ----------- Creating DataBase ----------------------- //
		MongoDatabase database = client.getDatabase("shop2");
		// ----------- Creating Collection ----------------------- //
		MongoCollection<Document> collection = database.getCollection("memo");
		
//		Bson filter2 = new Document("name", 1);
//		
		Document filter = new Document("age", "602");
		
		FindIterable<Document> result = collection.find(filter);
		
		// ----------- Creating Document ----------------------- //
		// insertOne(document)			
		Document doc = new Document();
		doc.append("age", "601");
		doc.append("name", "solo01");
		doc.append("office", "seoul1");
		doc.append("phone", "011");
		
		Document doc2 = new Document();
		doc2.append("age", "602");
		doc2.append("name", "solo02");
		doc2.append("office", "seoul2");
		doc2.append("phone", "012");
		
		List<Document> list = new ArrayList<Document>();
		list.add(doc);
		list.add(doc2);
		
		collection.insertMany(list);
		System.out.println("insertMany 성공");

		for (Document docu : result) {
			System.out.println("AGE: " + doc.getString("age") + ", ");
			System.out.println("NAME: " + doc.getString("name") + ", ");
			System.out.println("OFFICE: " + doc.getString("office") + ", ");
			System.out.println("PHONE: " + doc.getString("phone"));
		}
		
		System.out.println("==== 검색 성공 ====");	
		
		Document filter2 = new Document();
		filter2.append("name", "solo1");
		
		Bson update = Updates.set("name", "hello1");
		List<Bson> list2 = new ArrayList<>();
		list2.add(update);
		Bson all = Updates.combine(list2);
		collection.updateOne(filter2, all);		
		System.out.println("==== updateOne 성공 ====");
		
		Document doc3 = new Document();
		doc.append("name", "solo02");	
		
		collection.deleteOne(doc3); // 빈 조건을 주면 모두 삭제 됨				
		System.out.println("==== deleteOne 성공 ====");

		
		} catch (Exception e) {
			System.out.println(e);
		}

	}

}
