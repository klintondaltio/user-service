package academy.devdojo.service;

import academy.devdojo.commons.UserUtils;
import academy.devdojo.domain.User;
import academy.devdojo.repository.UserHardCodedRepository;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class UserServiceTest {
    @InjectMocks
    private UserService service;
    @Mock
    private UserHardCodedRepository repository;
    private List<User> users = new ArrayList<>();
    @InjectMocks
    private UserUtils userUtils;

    @BeforeEach
    void init(){
        users = userUtils.users();
    }

    @Test
    @DisplayName("findAll return a list with all users")
    @Order(1)
    void findAll_ReturnAllUsers_WhenSuccessful(){
        BDDMockito.when(repository.findAll()).thenReturn(this.users);
        var users = service.findAll();
        org.assertj.core.api.Assertions.assertThat(users).hasSameElementsAs(this.users);
    }


}