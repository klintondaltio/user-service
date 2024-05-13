package academy.devdojo.mapper;

import academy.devdojo.domain.User;
import academy.devdojo.request.UserGetResponse;
import academy.devdojo.request.UserPostRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface UserMapper {

    @Mapping(target = "id", expression = "java(java.util.concurrent.ThreadLocalRandom.current().nextLong(100_000))")
    User toUser(UserPostRequest request);

   // UserPostResponse toUserPostResponse(User anime);

    UserGetResponse toUserGetResponse(User user);

    List<UserGetResponse> toUserGetResponseList(List<User> users);


    //User toUser(UserPutRequest request);
}
