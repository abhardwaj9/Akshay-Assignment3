package com.coderscampus.Assignment3;

import java.util.Scanner;

public class UserLoginApplication {

	public static void main(String[] args) {

		Scanner scanner;
		int attempt = 0;
		boolean userMatch = false;
		String usernameInput = null;
		String passwordInput = null;

		UserService service = new UserService();
		User user = null;

		while ((attempt < 5) && (userMatch == false)) {

			System.out.println("Enter your email:");
			scanner = new Scanner(System.in);
			usernameInput = scanner.nextLine();
			System.out.println("Enter your password:");
			passwordInput = scanner.nextLine();

			user = service.inputData(usernameInput, passwordInput);

			if (user == null) {

				System.out.println("Invalid login, please try again.");
			}

			else {

				System.out.println("Welcome, " + user.getName());
				userMatch = true;
			}

			attempt++;

			if (attempt == 5 || userMatch == true) {

				scanner.close();
			}
		}

		if (attempt == 5 && userMatch == false) {

			System.out.println("Too many failed login attempts, you are now locked out");
		}
	}
}
