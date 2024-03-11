package com.Luis0DEV.Application.Ultius;

import com.Luis0DEV.Application.ModelResponse.ResponseModel;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RestException extends Exception{

    public String nome;

    public Exception innerException;

}
