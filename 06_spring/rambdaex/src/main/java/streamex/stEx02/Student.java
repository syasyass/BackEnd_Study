package streamex.stEx02;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Student implements Comparable<Student> { // sorted를 위함. 반드시 Comparable을 상속한 개체여야 soeted 가능

	private String name;
	private int score;
	
	@Override
	public int compareTo(Student o) {
		return Integer.compare(score, o.score);
	}
}
