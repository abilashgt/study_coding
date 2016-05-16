package org.koushik.javabrains.dto.crud;

import org.hibernate.annotations.*;
import org.hibernate.annotations.Cache;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@org.hibernate.annotations.Entity(selectBeforeUpdate = true) //depreciated
//@DynamicUpdate // latest replacement for @org.hibernate.annotations.Entity
@Table(name = "crud_user_details")
@NamedQuery(name = "UserDetails.byName", query = "from CRUDUserDetails where UserName = :name")
@NamedNativeQuery(name = "UserDetails.byId", query = "select * from crud_user_details where user_id = :id", resultClass = CRUDUserDetails.class)
public class CRUDUserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private int UserId;

    @Column(name = "user_name")
    private String UserName;

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
}
