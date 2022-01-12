package com.week9.week9_restapi_blogapp.dto;

import com.week9.week9_restapi_blogapp.model.UserModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseDTO {
    public UserModel user;
    public String message;
    public boolean status;
}
