package com.coderscampus.Assignment3;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class UserService {

	public User[] user_;

	public User inputData(String username, String password) {

		User user = null;
		infoStored();

		if (this.user_ != null) {

			for (int i = 0; (i < this.user_.length && this.user_[i] != null); i++)

			{
				if (this.user_[i].getUsername().equalsIgnoreCase(username)
						&& this.user_[i].getPassword().equals(password))

				{
					user = this.user_[i];
				}
			}
		}
		return user;
	}

	private void infoStored() {

		this.user_ = null;
		int userCount = 0;

		userCount = userCount();

		if (userCount > 0)

		{
			this.user_ = new User[userCount];

			BufferedReader reader = null;

			try {
				FileReader file = new FileReader(
						"C:\\Users\\16476\\git\\Akshay-Assignment3\\src\\com\\coderscampus\\Assignment3\\data.txt");

				reader = new BufferedReader(file);
				String text = null;
				int i = 0;

				while (((text = reader.readLine()) != null) && (i < userCount))

				{
					String[] data = text.split(",");
					this.user_[i] = new User(data[0], data[1], data[2]);
					i++;
				}

			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				if (reader != null) {
					try {
						reader.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
	}

	private int userCount() {

		int userCount = 0;

		BufferedReader reader = null;

		try {
			reader = new BufferedReader(new FileReader(
					"C:\\Users\\16476\\git\\Akshay-Assignment3\\src\\com\\coderscampus\\Assignment3\\data.txt"));

			while (reader.readLine() != null) {
				userCount++;
			}
		}

		catch (FileNotFoundException e) {

			e.printStackTrace();
		}

		catch (IOException e) {

			e.printStackTrace();
		}

		finally {

			if (reader != null) {

				try {
					reader.close();
				}

				catch (IOException e) {

					e.printStackTrace();
				}
			}
		}

		return userCount;
	}
}
