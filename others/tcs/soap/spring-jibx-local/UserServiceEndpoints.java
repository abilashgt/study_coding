package com.javaguys.webservices.endpoints;

import com.javaguys.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.javaguys.webservices.GetUserRequest;
import com.javaguys.webservices.GetUserResponse;
import com.javaguys.webservices.SaveUserRequest;
import com.javaguys.webservices.SaveUserResponse;

@Endpoint
public class UserServiceEndpoints {

    private static final String GET_TARGET_NAMESPACE = "http://com/javaguys/webservices/getUserServices";
    private static final String SAVE_TARGET_NAMESPACE = "http://com/javaguys/webservices/saveUserServices";

    @Autowired  
    private UserService userService;  
    
    @PayloadRoot(localPart = "GetUserRequest", namespace = GET_TARGET_NAMESPACE)
    public @ResponsePayload
    GetUserResponse getUserDetails(@RequestPayload GetUserRequest request) {
        System.out.println("Get User !");
        GetUserResponse response = new GetUserResponse();
        response.setUserDetails(userService.getUserDetails(request.getUserId()));
        return response;
    }

    @PayloadRoot(localPart = "SaveUserRequest", namespace = SAVE_TARGET_NAMESPACE)
    public @ResponsePayload
    SaveUserResponse saveUserDetails(@RequestPayload SaveUserRequest request) {
        System.out.println("Save User !");
        SaveUserResponse response = new SaveUserResponse();
        response.setUserId(userService.saveUserDetails(request.getUserDetails()));
        return response;
    }

    public void setUserService(UserService userService_i) {
        this.userService = userService_i;
    }

}