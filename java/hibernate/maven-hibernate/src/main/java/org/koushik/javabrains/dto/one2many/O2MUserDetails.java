package org.koushik.javabrains.dto.one2many;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@Table(name = "o2m_user_details")
public class O2MUserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private int UserId;

    @Column(name = "user_name")
    private String UserName;

    @OneToMany(
            //mappedBy = "user",
            cascade = CascadeType.PERSIST
    )
    //@JoinColumn(name = "vehicle_id")
    //@JoinTable(name = "o2m_user_vehicle",joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "vehicle_id"))
    private Collection<O2MVehicle> vehicle = new ArrayList<O2MVehicle>();

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

    public Collection<O2MVehicle> getVehicle() {
        return vehicle;
    }

    public void setVehicle(Collection<O2MVehicle> vehicle) {
        this.vehicle = vehicle;
    }
}
