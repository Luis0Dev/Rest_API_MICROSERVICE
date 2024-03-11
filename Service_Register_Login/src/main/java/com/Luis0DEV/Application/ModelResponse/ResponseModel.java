package com.Luis0DEV.Application.ModelResponse;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponseModel {

    public  ResponseModel(){

    }

    public ResponseModel(ResponseModel parametro){

        Success = parametro.Success;
        Error = parametro.Error;
        Message = parametro.Message;
    }

    public boolean Success;
    public boolean Error;
    public String Message;
}
