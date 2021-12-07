package ma.hotelbookingapp.monolithic.data.entities;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "discountline")
public class DiscountLine extends BaseEntity{

    private Date expirationDate;
    
    @ManyToOne(fetch=FetchType.LAZY)
    @NotNull
    private Discount discount;


    protected DiscountLine() {}

    public DiscountLine(Date expirationDate,Discount discount){
        this.expirationDate = expirationDate;
        this.discount = discount;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    public Discount getDiscount() {
        return discount;
    }

    public void setDiscount(Discount discount) {
        this.discount = discount;
    }

    
}
