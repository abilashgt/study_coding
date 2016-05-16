package org.koushik.javabrains.dto.one2many;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;

@Entity
@Table(name = "o2m_vehicle")
public class O2MVehicle {
    @Id
    @GeneratedValue
    private int vehicleId;
    private String vehicleName;

    //reverse relationship
    @ManyToOne
    @JoinColumn(name = "user_id")
    @NotFound(action = NotFoundAction.IGNORE)
    private O2MUserDetails user;

    public int getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(int vehicleId) {
        this.vehicleId = vehicleId;
    }

    public String getVehicleName() {
        return vehicleName;
    }

    public void setVehicleName(String vehicleName) {
        this.vehicleName = vehicleName;
    }

    public O2MUserDetails getUser() {
        return user;
    }

    public void setUser(O2MUserDetails user) {
        this.user = user;
    }
}
