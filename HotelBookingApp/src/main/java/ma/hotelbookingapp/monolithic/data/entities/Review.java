package ma.hotelbookingapp.monolithic.data.entities;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;


@Entity

@Table(name="Review")
public class Review extends BaseEntity {

    //@Id
    //@GeneratedValue(strategy=GenerationType.AUTO)

    
    @Column(name="reviewtext")
    protected String reviewText;

    
    //@Column(name="hotelreviewed")
    @ManyToOne(fetch=FetchType.LAZY)
    private Hotel hotelReviewed;

    
    @Column(name="rating")
    @NotNull
    protected int rating;

    public String getReviewText() {
        return reviewText;
    }

    public Hotel getHotelReviewed() {
        return hotelReviewed;
    }

    public void setHotelReviewed(Hotel hotelReviewed) {
        this.hotelReviewed = hotelReviewed;
    }

    public int getRating() {
        return rating;
    }

    protected Review() { }

    public Review(String reviewText, int rating, Hotel hotelReviewed){
        this.reviewText = reviewText;
        this.rating = rating;
        this.hotelReviewed = hotelReviewed;
    }
    
    public boolean setRating(int rating){
        if(rating < 6 && rating > -1){
            this.rating = rating;
            return true;
        }
        else{
            return false;
        }   
    }

    public void setReviewText(String reviewText){
        this.reviewText = reviewText;
        return;
    }
}
