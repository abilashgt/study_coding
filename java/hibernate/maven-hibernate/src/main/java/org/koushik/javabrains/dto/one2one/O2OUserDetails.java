package org.koushik.javabrains.dto.one2one;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@Table(name = "o2o_user_details")
public class O2OUserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private int UserId;

    @Column(name = "user_name")
    private String UserName;

    @OneToOne
    @JoinColumn(name = "vehicle_id")
    private O2OVehicle vehicle;

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

    public O2OVehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(O2OVehicle vehicle) {
        this.vehicle = vehicle;
    }
}
