package org.koushik.javabrains.dto;

import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.lang.model.element.Name;
import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "user_details2")
public class UserDetails2 {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private int UserId;

    @Column(name = "user_name")
    private String UserName;

    @ElementCollection
    @JoinTable(name = "user_addresses2",
            joinColumns = @JoinColumn(name = "user_id")
    )
    @GenericGenerator(name = "hilo-gen", strategy = "hilo")
    @CollectionId(columns = {@Column(name = "address_id")}, generator = "hilo-gen", type = @Type(type = "int"))
    private Collection<Address> listOfAddresses = new ArrayList<Address>();

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

    public Collection<Address> getListOfAddresses() {
        return listOfAddresses;
    }

    public void setListOfAddresses(Collection<Address> listOfAddresses) {
        this.listOfAddresses = listOfAddresses;
    }
}
