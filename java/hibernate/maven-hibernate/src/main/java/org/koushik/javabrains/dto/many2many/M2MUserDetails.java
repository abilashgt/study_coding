package org.koushik.javabrains.dto.many2many;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@Table(name = "m2m_user_details")
public class M2MUserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private int UserId;

    @Column(name = "user_name")
    private String UserName;

    @ManyToMany
    @JoinTable(
            name = "m2m_user_details_vehicle",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "vehicle_id")
    )
    private Collection<M2MVehicle> vehicles = new ArrayList<M2MVehicle>();

    public int getUserId() {
        return UserId;
    }

    public void setUserId(int userId) {
        UserId = userId;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public Collection<M2MVehicle> getVehicles() {
        return vehicles;
    }

    public void setVehicles(Collection<M2MVehicle> vehicles) {
        this.vehicles = vehicles;
    }
}
