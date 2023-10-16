package mongoex;

import org.bson.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MemoVO {
	private String age;
	private String name;
	private String office;
	private String phone;
	
	public MemoVO(Document doc) {
		
		age = doc.getString("age");
		name = doc.getString("name");
		office = doc.getString("office");
		phone = doc.getString("phone");
	}

}
