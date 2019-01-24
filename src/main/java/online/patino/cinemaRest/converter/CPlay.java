package online.patino.cinemaRest.converter;

import online.patino.cinemaRest.entity.PlayEntity;
import online.patino.cinemaRest.model.PlayModel;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component("CPlay")
public class CPlay {
    public List<PlayModel> converList(List<PlayEntity> playEntities) {
        List<PlayModel> mplays = new ArrayList<>();
        for (PlayEntity playEntity : playEntities) {
            mplays.add(new PlayModel(playEntity));
        }
        return mplays;
    }
}
