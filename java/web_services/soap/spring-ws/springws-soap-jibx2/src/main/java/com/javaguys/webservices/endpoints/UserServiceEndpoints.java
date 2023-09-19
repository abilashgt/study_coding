package com.javaguys.webservices.endpoints;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.javaguys.webservices.GetUserRequest;
import com.javaguys.webservices.GetUserResponse;
import com.javaguys.webservices.SaveUserRequest;
import com.javaguys.webservices.SaveUserResponse;
import com.javaguys.webservices.User;

@Endpoint
public class UserServiceEndpoints {

    private static final String GET_TARGET_NAMESPACE = "http://com/javaguys/webservices/getUserServices";
    private static final String SAVE_TARGET_NAMESPACE = "http://com/javaguys/webservices/saveUserServices";
 
    
    @PayloadRoot(localPart = "GetUserRequest", namespace = GET_TARGET_NAMESPACE)
    public @ResponsePayload
    GetUserResponse getUserDetails(@RequestPayload GetUserRequest request) {
        System.out.println("Get User !");
        GetUserResponse response = new GetUserResponse();
        User user = new User();
        user.setUserId("0");
        user.setUserName("name1111");
        user.setUserGender("2222male");
        user.setUserStatus("333status");
        response.setUserDetails(user);
        return response;
    }

    @PayloadRoot(localPart = "SaveUserRequest", namespace = SAVE_TARGET_NAMESPACE)
    public @ResponsePayload
    SaveUserResponse saveUserDetails(@RequestPayload SaveUserRequest request) {
        System.out.println("Save User !");
        SaveUserResponse response = new SaveUserResponse();
        response.setUserId("0");
        return response;
    }

}