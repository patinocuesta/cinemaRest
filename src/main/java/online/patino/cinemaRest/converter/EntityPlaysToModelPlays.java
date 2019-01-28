package online.patino.cinemaRest.converter;

import online.patino.cinemaRest.entity.PlayEntity;
import online.patino.cinemaRest.model.PlayModel;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component("EntityPlaysToModelPlays")
public class EntityPlaysToModelPlays {
    public List<PlayModel> converList(List<PlayEntity> playEntities) {
        List<PlayModel> playsModel = new ArrayList<>();
        for (PlayEntity playEntity : playEntities) {
            playsModel.add(new PlayModel(playEntity));
        }
        return playsModel;
    }
}
