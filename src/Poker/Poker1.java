package Poker;

import java.util.Random;

public class Poker1 {
	public Poker1() {
		String name;
		System.out.println("歡迎來到梭哈");
	}

	public String name;

	public static void handcard(int[] computer, int[] player) {

		int number = 0;
		computer = new int[5];
		player = new int[5];
		int[] check = new int[10];
		boolean checkcard = true;
		String color;
		Random random = new Random();
		for (int i = 0; i < 10; i++) {
			number = random.nextInt(52) + 1;
			for (int j = 0; j < i; j++) {
				while (check[j] == number) {
					number = random.nextInt(52) + 1;
				}
			}
			check[i] = number;
			if (i % 2 == 0) {
				int a;
				a = i / 2;
				computer[a] = number;
				checkcard = true;
			} else {
				if (i % 2 == 1) {
					int b;
					if (i == 1) {
						b = 0;
					} else {
						b = (i / 2);
					}
					player[b] = number;
					checkcard = true;
				}
			}

		}
		System.out.println("Computer");
		print(computer);
		System.out.println("Player");
		print(player);
		win(computer, player);

	}

	public static void win(int[] b, int[] c) {
		int count = 0;

		for (int j = 0; j < 5; j++) {

			for (int i = 1; i <= 4 - j; i++) {
				if (b[j] % 13 == b[i + j] % 13) {
					count++;
				}

			}
		}
		System.out.println(count);
		int count1 = count;
		count = 0;
		for (int j = 0; j < 5; j++) {

			for (int i = 1; i <= 4 - j; i++) {
				if (c[j] % 13 == c[i + j] % 13) {
					count++;
				}

			}
		}
		System.out.println(count);
		int count2 = count;
		int computer = 0;
		int player = 0;
		if (count1 > count2) {
			System.out.print("computer win");
			computer++;
		} else if (count1 < count2) {
			System.out.print("player win");
			player++;
		} else {
			System.out.print("平手");
		}
		if (computer == 3) {
			System.out.print("computer is the final winner");
			
		} else if (player == 3) {
			System.out.print("player is the final winner");
		}
	}

	public static void print(int[] a) {

		for (int i = 0; i <= 3; i++) {
			for (int j = i + 1; j < 5; j++) {
				if (a[i] > a[j]) {
					int tmp = a[i];
					a[i] = a[j];
					a[j] = tmp;
				}
			}
		}
		for (int i = 0; i < 5; i++) {
			// System.out.println(a[i]);
			System.out.print(color(a[i]) + ((a[i] % 13) + 1) + "\t");
		}

		System.out.println();
	}

	public static String color(int x) {
		String color = "";
		switch (x % 4) {
		case 0:
			color = "黑桃";
			break;
		case 1:
			color = "紅心";
			break;
		case 2:
			color = "方塊";
			break;
		case 3:
			color = "梅花";
			break;
		}
		return color;
	}

}
	
	


