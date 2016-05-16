package org.koushik.javabrains.dto;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "user_details")
public class UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private int UserId;

    @Column(name = "user_name")
    private String UserName;

    @Column(name = "join_date")
    @Temporal(TemporalType.DATE)
    private Date JoinDate;

    @Embedded
    private Address address;

    @Embedded
    @AttributeOverrides({
        @AttributeOverride(name="street", column=@Column(name="office_street")),
        @AttributeOverride(name="city", column=@Column(name="office_city")),
        @AttributeOverride(name="state", column=@Column(name="office_state")),
        @AttributeOverride(name="pin", column=@Column(name="office_pin_code"))
    })
    private Address officeAddress;

    @Lob
    private String desciption;

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

    public Date getJoinDate() {
        return JoinDate;
    }

    public void setJoinDate(Date joinDate) {
        JoinDate = joinDate;
    }

    public String getDesciption() {
        return desciption;
    }

    public void setDesciption(String desciption) {
        this.desciption = desciption;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Address getOfficeAddress() {
        return officeAddress;
    }

    public void setOfficeAddress(Address officeAddress) {
        this.officeAddress = officeAddress;
    }
}
