package ma.hotelbookingapp.monolithic.data.entities;

import java.util.List;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
@Entity
@Table(name="ServiceType")
public class ServiceType extends BaseEntity {
 
    @Column(name="servicename")
    @NotNull
    protected String serviceName;

    
    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public List<ServiceOffered> getAvailablities() {
        return availablities;
    }

    public void setAvailablities(List<ServiceOffered> availablities) {
        this.availablities = availablities;
    }

    @Column(name="availability")
    @OneToMany(mappedBy = "serviceType")
    private List<ServiceOffered> availablities;

    protected ServiceType() { }

    public ServiceType(String serviceName){
        this.serviceName = serviceName;
    }

}
