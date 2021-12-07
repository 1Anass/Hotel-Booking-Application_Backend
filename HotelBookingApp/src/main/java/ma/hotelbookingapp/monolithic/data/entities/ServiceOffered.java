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
@Table(name="ServiceOffered")
public class ServiceOffered extends BaseEntity {


    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public ServiceType getServiceType() {
        return serviceType;
    }

    public void setServiceType(ServiceType serviceType) {
        this.serviceType = serviceType;
    }

    @NotNull
    @ManyToOne(fetch=FetchType.LAZY)
    private Room room;

    
    //@Column(name="servicetype")
    @NotNull
    @ManyToOne(fetch=FetchType.LAZY)
    private ServiceType serviceType;

    protected ServiceOffered() { }

    public ServiceOffered(Room room, ServiceType serviceType){
        this.room = room;
        this.serviceType = serviceType;
    }
    
}
