import java.util.List;
import java.util.Scanner;

import repository.UserRepository;
import entity.User;
import util.MD5;

public class Main {
    public static void main(String[] args) {
        showMenu();
    }

    private static void showMenu() {
        Scanner s = new Scanner(System.in);
        boolean isActive = true;
        while (isActive) {
            System.out.println("1. add user");
            System.out.println("2. edit user");
            System.out.println("3. delete user");
            System.out.println("4. all users");
            System.out.println("5. exit");
            int command = s.nextInt();
            switch (command) {
                case 1:
                    addUser();
                    break;
                case 2:
                    editUser();
                    break;
                case 3:
                    deleteUser();
                    break;
                case 4:
                    allUsers();
                    break;
                case 5:
                    isActive = false;
                    System.out.println("----end----");
                    break;
                default:
                    System.out.println("invalid command");
                    break;
            }

        }
    }

    private static void addUser() {
        System.out.println("---- add user ----");
        Scanner s = new Scanner(System.in);
        System.out.println("enter login");
        String login = s.next();
        System.out.println("enter password");
        String pass = s.next();
        System.out.println("enter email");
        String email = s.next();
        System.out.println("enter birthday");
        int birthday = s.nextInt();
        User user = new User(login, MD5.make(pass), email, birthday);
        UserRepository db = new UserRepository();
        db.addUser(user);
        System.out.println("--------------");
    }

    private static void editUser() {
        System.out.println("---- edit user ----");
        UserRepository db = new UserRepository();
        List<User> allUsers = db.getAllUsers();
        if (allUsers.size() == 0) {
            System.out.println("no users in db");
            return;
        }
        System.out.println("select user number you want to edit");
        for (int i = 0; i < allUsers.size(); i++) {
            System.out.println((i + 1) + ". " + allUsers.get(i).info());
        }
        Scanner s = new Scanner(System.in);
        int number = s.nextInt();
        if (number > 0 && number <= allUsers.size()) {
            System.out.println("enter login");
            String login = s.next();
            System.out.println("enter password");
            String pass = s.next();
            System.out.println("enter email");
            String email = s.next();
            System.out.println("enter birthday");
            int birthday = s.nextInt();
            allUsers.get(number - 1).setLogin(login);
            allUsers.get(number - 1).setPassword(MD5.make(pass));
            allUsers.get(number - 1).setBirthday(birthday);
            allUsers.get(number - 1).setEmail(email);
            db.editUser(allUsers.get(number - 1));
        }
        System.out.println("--------------");
    }

    private static void deleteUser() {
        System.out.println("---- delete user ----");
        UserRepository db = new UserRepository();
        List<User> allUsers = db.getAllUsers();
        if (allUsers.size() == 0) {
            System.out.println("no users in db");
            return;
        }
        System.out.println("select user number you want to delete");
        for (int i = 0; i < allUsers.size(); i++) {
            System.out.println((i + 1) + ". " + allUsers.get(i).info());
        }
        Scanner s = new Scanner(System.in);
        int number = s.nextInt();
        if (number > 0 && number <= allUsers.size()) {
            db.deleteUser(allUsers.get(number - 1).getId());
        }
        System.out.println("-------------------");
    }

    private static void allUsers() {
        System.out.println("---- all users ----");

        UserRepository db = new UserRepository();
        List<User> allUsers = db.getAllUsers();
        if (allUsers.size() == 0) {
            System.out.println("no users in db");
            return;
        }
        for (int i = 0; i < allUsers.size(); i++) {
            System.out.println((i + 1) + ". " + allUsers.get(i).info());
        }
        System.out.println("-------------------");
    }
}
