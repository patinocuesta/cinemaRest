package online.patino.cinemaRest.converter;

import online.patino.cinemaRest.entity.ReviewEntity;
import online.patino.cinemaRest.model.ReviewModel;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component("EntitiyReviewsToModelReviews")
public class EntitiyReviewsToModelReviews {
    public List<ReviewModel> converList(List<ReviewEntity> reviewEntities) {
        List<ReviewModel> reviewsModel = new ArrayList<>();
        for (ReviewEntity reviewEntity : reviewEntities) {
            reviewsModel.add(new ReviewModel(reviewEntity));
        }
        return reviewsModel;
    }
}
