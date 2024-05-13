package academy.devdojo.repository;

import academy.devdojo.domain.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserData {
    private final List<User> users = new ArrayList<>();
    {
        User ex1 = User.builder().id(1L).firstName("Goku").lastName("Son").email("goku.son@gmail.com").build();
        User ex2 = User.builder().id(1L).firstName("Gohan").lastName("").email("gohan.son@gmail.com").build();
        User ex3 = User.builder().id(1L).firstName("Goten").lastName("").email("goten.son@gmail.com").build();
        users.addAll(List.of(ex1, ex2, ex3));
    }

    public List<User> getUsers() {
        return users;
    }
}
