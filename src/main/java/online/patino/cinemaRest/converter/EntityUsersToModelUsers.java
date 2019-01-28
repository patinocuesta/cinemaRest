package online.patino.cinemaRest.converter;

import online.patino.cinemaRest.entity.UserEntity;
import online.patino.cinemaRest.model.UserModel;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component("EntityUsersToModelUsers")
public class EntityUsersToModelUsers {
    public List<UserModel> converList(List<UserEntity> userEntities) {
        List<UserModel> usersModel = new ArrayList<>();
        for (UserEntity userEntity : userEntities) {
            usersModel.add(new UserModel(userEntity));
        }
        return usersModel;
    }
}
