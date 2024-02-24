// 231RDB152 Artjoms Fomins 8

import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		System.out.println("231RDB152 Artjoms Fomins 8. grupa");

		String fileName;
		System.out.println("input file name:");
		fileName = sc.nextLine();
		sc.close();

		FileReader fr = new FileReader(fileName);
		sc = new Scanner(fr);

		LinkedList<String> badStudents = new LinkedList<String>();

		while (sc.hasNext()) {
			String str = sc.nextLine();
			String[] arr = str.split(" ");
			int studentMark = 0;
			int markCount = 0;
			int badMarksCount = 0;
			String studentName = "";

			for (int i = 0; i < arr.length; i++) {
				try {
					int mark = Integer.parseInt(arr[i]);
					if (mark < 4) {
						badMarksCount++;
					}
					studentMark += mark;
					markCount++;
				} catch (Exception NumberFormatException) {
					studentName += arr[i] + " ";
					continue;
				}
			}
			if (studentMark / markCount <= 5) {
				badStudents.add(studentName + " " + badMarksCount);
			}
		}
		sc.close();

		System.out.println("result:");

		for (String student : badStudents) {
			System.out.println(student);
		}
	}

}