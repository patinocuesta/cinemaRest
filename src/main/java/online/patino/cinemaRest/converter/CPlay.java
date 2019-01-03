package online.patino.cinemaRest.converter;

import online.patino.cinemaRest.entity.Play;
import online.patino.cinemaRest.model.MPlay;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component("CPlay")
public class CPlay {
    public List<MPlay> converList(List<Play> plays) {
        List<MPlay> mplays = new ArrayList<>();
        for (Play play : plays) {
            mplays.add(new MPlay(play));
        }
        return mplays;
    }
}
