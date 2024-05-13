package academy.devdojo.repository;

import academy.devdojo.commons.UserUtils;
import academy.devdojo.domain.User;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class UserHardCodedRepositoryTest {

    @InjectMocks
    private UserHardCodedRepository repository;
    @Mock
    private UserData userData;
    @Mock
    private List<User> users;
    @InjectMocks
    private UserUtils userUtils;

    @BeforeEach
    void init(){
        users = userUtils.users();
        BDDMockito.when(userData.getUsers()).thenReturn(users);
    }

    @Test
    @DisplayName("findAll return a list with all producers")
    @Order(1)
    void findAll_ReturnAllProducers_WhenSuccessful(){
        var allUsers = repository.findAll();
        org.assertj.core.api.Assertions.assertThat(allUsers).hasSameElementsAs(this.users);
    }
}