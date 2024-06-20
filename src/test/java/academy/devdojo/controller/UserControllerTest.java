package academy.devdojo.controller;

import academy.devdojo.commons.FileUtils;
import academy.devdojo.commons.UserUtils;
import academy.devdojo.service.UserService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Collection;
import java.util.Collections;


@WebMvcTest(UserController.class)
public class UserControllerTest {

    public static final String URL = "/v1/producers";

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private UserService userService;
    @Autowired
    private FileUtils fileUtils;
    @Autowired
    private UserUtils userUtils;

    @Test
    @DisplayName("findAll() return a list with all users")
    @Order(1)
    void findAll_ReturnsAllUsers_WhenSuccessful() throws Exception{
        var response = fileUtils.readResourceFile("user/get-all-users-200.json");
        BDDMockito.when(userService.findAll()).thenReturn(userUtils.users());
        mockMvc.perform(MockMvcRequestBuilders.get("/v1/users"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json(response));
    }

    @Test
    @DisplayName("findAll() return a EMPTY list when no users is found")
    @Order(2)
    void findAll_ReturnsEmptyList_WhenNoUsersAreFound() throws Exception{
        var response = fileUtils.readResourceFile("user/get-all-users-empty-list-200.json");
        BDDMockito.when(userService.findAll()).thenReturn(Collections.emptyList());
        mockMvc.perform(MockMvcRequestBuilders.get("/v1/users"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json(response));
    }

}
