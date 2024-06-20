package academy.devdojo.commons;

import academy.devdojo.domain.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class UserUtils {
    public List<User> users()
    {
        User ex1 = User.builder().id(1L).firstName("Luffy").lastName("Monkey D").email("Luffy@gmail.com").build();
        User ex2 = User.builder().id(1L).firstName("Franky").lastName("Kentaurus").email("Franky@gmail.com").build();
        User ex3 = User.builder().id(1L).firstName("Kuzan").lastName("Aokiji").email("Kuzan@gmail.com").build();
        return new ArrayList<>(List.of(ex1,ex2,ex3));
    }
    public User newUserToSave(){
        return User.builder().id(99l).firstName("Luffy").lastName("Monkey D").email("Luffy@gmail.com").build();
    }
}
