package jm.task.core.jdbc;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;

import java.util.List;



public class Main {
    public static void main(String[] args) {
        // реализуйте алгоритм здесь
        UserService userService = new UserServiceImpl();
        userService.createUsersTable();

        userService.saveUser("Salavat", "Kamaletdinov", (byte) 28);
        userService.saveUser("Oleg", "Petrov", (byte) 27);
        userService.saveUser("Ivan", "Ivanov", (byte) 26);

        List<User> list = userService.getAllUsers();
        for (User user : list){
            System.out.println(user.toString());
        }

        userService.cleanUsersTable();
        userService.dropUsersTable();

    }
}
