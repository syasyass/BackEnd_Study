package mongoex;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class Mongo2 {

	public static void main(String[] args) {
		// Unchecked Exception : 컴파일러가 오류를 체크해주지 않는 경우
		// 0으로 나누기, 배열/리스트의 인덱스 오류 등
		
		// Checked Exception --> 반드시 try 처리 필요

		try {
			// ----------- Connecting DataBase --------------------- //
			MongoClient client = new MongoClient(
					new MongoClientURI("mongodb://winner:1234@localhost:27017/shop2"));
			// ----------- Creating DataBase ----------------------- //
			MongoDatabase database = client.getDatabase("shop2");
			// ----------- Creating Collection ----------------------- //
			MongoCollection<Document> collection = database.getCollection("member");
			// ----------- Creating Document ----------------------- //
			Document doc = new Document();
			doc.append("id", "apple");
			doc.append("pw", "1234");
			doc.append("name", "apple");
			doc.append("tel", "011");
			
			// ----------- Inserting Data ----------------------- //
			collection.insertOne(doc);
			System.out.println("insertOne 성공");
			
		} catch (Exception e) {
			System.out.println(e);
		}

	}

}
