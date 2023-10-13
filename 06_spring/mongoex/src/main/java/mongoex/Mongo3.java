package mongoex;

import java.util.Scanner;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class Mongo3 {

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
			// insertOne(document)
			Scanner sc = new Scanner(System.in);
			System.out.println("id 입력>> ");
			String id = sc.next();
			System.out.println("pw 입력>> ");
			String pw = sc.next();
			System.out.println("name 입력>> ");
			String name = sc.next();
			System.out.println("tel 입력>> ");
			String tel = sc.next();
			sc.close();			
			
			Document doc = new Document();
			doc.append("id", id);
			doc.append("pw", pw);
			doc.append("name", name);
			doc.append("tel", tel);
			
			// ----------- Inserting Data ----------------------- //
			System.out.println(doc);
			collection.insertOne(doc);
			System.out.println(doc);
			
			System.out.println("insertOne 성공");
			
		} catch (Exception e) {
			System.out.println(e);
		}

	}

}