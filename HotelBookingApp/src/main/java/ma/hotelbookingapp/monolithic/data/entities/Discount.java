package ma.hotelbookingapp.monolithic.data.entities;

import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;


@Entity
@Table(name = "discount")
public class Discount extends BaseEntity{
    
    @Column(name = "discountname")
    @NotNull
    private String discountName;

    public String getDiscountName() {
        return discountName;
    }

    public void setDiscountName(String discountName) {
        this.discountName = discountName;
    }

    public String getDiscountDescription() {
        return discountDescription;
    }

    public void setDiscountDescription(String discountDescription) {
        this.discountDescription = discountDescription;
    }

    public int getReductionPercentage() {
        return reductionPercentage;
    }

    public void setReductionPercentage(int reductionPercentage) {
        this.reductionPercentage = reductionPercentage;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public List<DiscountLine> getDiscountsOffered() {
        return discountsOffered;
    }

    public void setDiscountsOffered(List<DiscountLine> discountsOffered) {
        this.discountsOffered = discountsOffered;
    }

    @Column(name = "discountdescription")
    private String discountDescription;

    @Column(name = "reductionpercentage")
    @NotNull
    private int reductionPercentage;

    @ManyToOne(fetch=FetchType.LAZY)
    @NotNull
    private Hotel hotel;

    @Column(name="discounts")
    @OneToMany(mappedBy = "discount", fetch = FetchType.LAZY)
    private List<DiscountLine> discountsOffered;

    protected Discount(){ }

    public Discount(String discountName, String discountDescription, int reductionPercentage){
        this.discountName = discountName;
        this.discountDescription = discountDescription;
        this.reductionPercentage = reductionPercentage;
    }
}
