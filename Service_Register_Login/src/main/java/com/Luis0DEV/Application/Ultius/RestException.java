package com.Luis0DEV.Application.Ultius;

import com.Luis0DEV.Application.ModelResponse.ResponseModel;

import org.springframework.dao.DataIntegrityViolationException;

public class RestException extends Exception {

    private String name;
    private Exception innerException;

    public RestException(Exception innerException) {
        this.innerException = innerException;
    }
    public ResponseModel tratarErro() {
        ResponseModel model = new ResponseModel();

        if (innerException instanceof DataIntegrityViolationException) {
            DataIntegrityViolationException dataEx = (DataIntegrityViolationException) innerException;
            if (dataEx.getCause() != null) {
                String message = dataEx.getCause().getMessage();
                if (message.contains("REFERENCE Constraint")) {
                    model.setMessage("O objeto possui vínculos e não pode ser removido ou alterado");
                } else if (message.contains("Cannot insert duplicate key")) {
                    model.setMessage("O objeto já existe");
                }
            }
            model.setSuccess(false);
            model.setError(false);
        } else {
            model.setMessage(innerException.getMessage());
            model.setSuccess(false);
            model.setError(true);
        }

        return model;
    }
}
