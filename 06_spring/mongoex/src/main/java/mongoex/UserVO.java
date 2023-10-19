package mongoex;

import org.bson.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserVO {
		private String id;
		private String pw;
		private String name;
		private String tel;
		
		public UserVO(Document doc) {
			
			id = doc.getString("id");
			pw = doc.getString("pw");
			name = doc.getString("name");
			tel = doc.getString("tel");
		}		
}
