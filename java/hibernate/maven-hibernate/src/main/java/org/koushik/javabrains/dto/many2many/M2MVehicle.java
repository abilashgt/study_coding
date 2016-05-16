package org.koushik.javabrains.dto.many2many;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@Table(name = "m2m_vehicle")
public class M2MVehicle {
    @Id
    @GeneratedValue
    private int vehicleId;
    private String vehicleName;

    @ManyToMany(mappedBy = "vehicles")
    private Collection<M2MUserDetails> users = new ArrayList<M2MUserDetails>();

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

    public Collection<M2MUserDetails> getUsers() {
        return users;
    }

    public void setUsers(Collection<M2MUserDetails> users) {
        this.users = users;
    }
}
