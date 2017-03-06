import java.util.Scanner;

class Credentials {
	private String username;
	private String password;
	private String[] oldPasswords;
	private int index;

	public String getPassword() {
		return password;
	}

	public boolean setPassword(String oldPassword, String newPassword) {
		if (oldPassword.equals(this.password)) {
			for (int i = 0; i < index; i++)
				if (oldPasswords[i].equals(newPassword)) {
					return false;
				}
			this.password = newPassword;
			oldPasswords[index] = newPassword;
			index++;
			return true;
		}
		return false;
	}

	public String getUsername() {
		return username;
	}

	Credentials(String username, String password) {
		this.username = username;
		this.password = password;
		oldPasswords = new String[100];
		oldPasswords[0] = password;
		index = 1;
	}
}

class CredentialsManager {
	Credentials[] credentials;
	int index;

	public CredentialsManager() {
		credentials = new Credentials[100];
		index = 0;
	}

	private void enroll(String username, String password) {
		credentials[index] = new Credentials(username, password);
		index++;
		System.out.println("ENROLL success");
	}

	private void chpass(String username, String password, String newPassword) {
		for (int i = 0; i < index; i++) {
			if (credentials[i].getUsername().equals(username)) {
				if (credentials[i].setPassword(password, newPassword)) {
					System.out.println("CHPASS success");
					return;
				}
			}
		}
		System.out.println("CHPASS fail");
	}

	private void auth(String username, String password) {
		for (int i = 0; i < index; i++) {
			if (credentials[i].getUsername().equals(username) && credentials[i].getPassword().equals(password)) {

				System.out.println("AUTH success");
				return;
			}
		}
		System.out.println("AUTH fail");
	}

	public void doCommand(String command) {
		String[] temp = command.split(" ");
		if (temp.length < 3) {
			System.out.println("INVALID COMMAND");
			return;
		}

		String commandName = temp[0];
		String username = temp[1];
		String password = temp[2];
		String newPassword = null;
		if (temp.length == 4) {
			newPassword = temp[3];
		}

		switch (commandName) {
		case "ENROLL": {
			enroll(username, password);
			break;
		}
		case "CHPASS": {
			chpass(username, password, newPassword);
			break;
		}
		case "AUTH":
			auth(username, password);
			break;
		}
	}

}

public class Task2_CredentialsManager {
	public static void main(String[] args) {
		CredentialsManager cm = new CredentialsManager();
		while (true) {
			Scanner sc = new Scanner(System.in);
			cm.doCommand(sc.nextLine());
		}

	}
}