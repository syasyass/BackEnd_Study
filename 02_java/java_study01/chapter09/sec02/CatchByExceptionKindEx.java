package java_study01.chapter09.sec02;

public class CatchByExceptionKindEx {

	public static void main(String[] args) {
		try {
			System.out.println(args);
			System.out.println(args.length);
			System.out.println(args[0]);
			System.out.println(args[1]);

			int value1 = Integer.parseInt(args[0]);
			int value2 = Integer.parseInt(args[1]);
			System.out.println(value1 + value2);

		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("실행 매개값의 수가 부족합니다.");
			System.out.println("[실행 방법]");
			System.out.println("Java CatchByExceptionKindEx num1 num2");
			// } catch (NumberFormatException e) {
		} catch (Exception e) {
			// System.err.println("숫자로 변환할 수 없습니다.");
			System.err.println(e);
			e.printStackTrace();
		} finally {
			System.out.println("다시 실행하세요.");
		}

	}

}
