package mongoex;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class Mongo4 {

	public static void main(String[] args) {
		// Unchecked Exception : 컴파일러가 오류를 체크해주지 않는 경우
		// 0으로 나누기, 배열/리스트의 인덱스 오류 등
		
		// Checked Exception --> 반드시 try 처리 필요

		try (MongoClient client = new MongoClient(
					new MongoClientURI("mongodb://winner:1234@localhost:27017/shop2"))) {
			// ----------- Connecting DataBase --------------------- //

			// ----------- Creating DataBase ----------------------- //
			MongoDatabase database = client.getDatabase("shop2");
			// ----------- Creating Collection ----------------------- //
			MongoCollection<Document> collection = database.getCollection("member");
			// ----------- Creating Document ----------------------- //
			// insertOne(document)			
			Document doc = new Document();
			doc.append("id", "apple3");
			doc.append("pw", "1234");
			doc.append("name", "apple3");
			doc.append("tel", "013");
			
			Document doc2 = new Document();
			doc.append("id", "apple4");
			doc.append("pw", "1234");
			doc.append("name", "apple4");
			doc.append("tel", "014");
			
			// ----------- Inserting Data ----------------------- //
			List<Document> list = new ArrayList<Document>();
			list.add(doc);
			list.add(doc2);
			
			collection.insertMany(list);
// client.close(); // 원래 finally에서 해 줘야 하는데, 그러면 후속처리가 더 필요.
			
			System.out.println("insertMany 성공");
			
		} catch (Exception e) {
			System.out.println(e);
		}

	}

}