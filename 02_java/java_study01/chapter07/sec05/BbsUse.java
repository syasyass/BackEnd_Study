package java_study01.chapter07.sec05;

public class BbsUse {

	public static void main(String[] args) {
		Bbs[] bbsPrint = { new Bbs(1, "java", "fun java", "park"), new Bbs(2, "jsp", "fun jsp", "hong"),
				new Bbs(3, "spring", "fun spring", "kim"), };

		System.out.println("게시판");
		System.out.println("--------------------------------------");
		System.out.println("no  title      content        writer");
		System.out.println("--------------------------------------");

		for (Bbs bbs : bbsPrint) {
			System.out.printf("%-3d %-10s %-15s %-10s\n", bbs.getNo(), bbs.getTitle(), bbs.getContent(),
					bbs.getWriter());
		}

	}

}
