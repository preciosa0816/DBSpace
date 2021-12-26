package p06.mvc_other;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class ScanChecker {
	Scanner sc;

	public int ScanInt() {
		int Num = 0;
		while (true) {
			try {
				sc = new Scanner(System.in);
				Num = sc.nextInt();
				break;
			} catch (InputMismatchException e) {
//				System.out.println("(InputMismatchException 발생)");
				System.out.print("숫자(정수)를 입력해 주세요 : ");
			} catch (NoSuchElementException e) {
//				System.out.println("(NoSuchElementException 발생)");
			} catch (Exception e) {
//				System.out.println("(Exception 발생)");
			}
		}
		return Num;
	}

	public double ScanDouble() {
		double dou = 0.0;
		while (true) {
			try {
				sc = new Scanner(System.in);
				dou = sc.nextDouble();
				break;
			} catch (InputMismatchException e) {
//				System.out.println("(InputMismatchException 발생)");
				System.out.print("숫자를 입력해 주세요 : ");
			} catch (NoSuchElementException e) {
//				System.out.println("(NoSuchElementException 발생)");
			} catch (Exception e) {
//				System.out.println("(Exception 발생)");
			}
		}
		return dou;
	}

	public String ScanString() {
		String str = null;
		while (true) {
			try {
				sc = new Scanner(System.in);
				str = sc.next();
				break;
			} catch (InputMismatchException e) {
//				System.out.println("(InputMismatchException 발생)");
			} catch (NoSuchElementException e) {
//				System.out.println("(NoSuchElementException 발생)");
			} catch (Exception e) {
//				System.out.println("(Exception 발생)");
			}
		}
		return str;
	}

	public void close() {
		if (sc != null) {
			sc.close();
		}
	}
}
