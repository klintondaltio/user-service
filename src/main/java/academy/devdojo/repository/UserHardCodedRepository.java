package academy.devdojo.repository;

import academy.devdojo.domain.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
@Log4j2
public class UserHardCodedRepository {

    private final UserData userData;


    public List<User> findAll() {
        return userData.getUsers();
    }

//    public Optional<User> findById(Long id) {
//        return userData.getUser().stream().filter(producer -> producer.getId().equals(id)).findFirst();
//    }
//
//    public List<User> findByName(String name) {
//        log.info(connection);
//        return name == null ? userData.getUser()
//                : userData.getUser().stream().filter(producer -> producer.getName().equalsIgnoreCase(name)).toList();
//    }
//
//    public User save(User producer){
//        userData.getUser().add(producer);
//        return producer;
//    }
//
//    public void delete(User producer){
//        userData.getUser().remove(producer);
//    }
//
//    public void update(User producer){
//        userData.getUser().remove(producer);
//        userData.getUser().add(producer);
//    }
}
