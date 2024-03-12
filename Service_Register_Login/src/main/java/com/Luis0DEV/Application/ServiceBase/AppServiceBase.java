package com.Luis0DEV.Application.ServiceBase;

import com.Luis0DEV.Application.Interface.IAppServiceBase;
import com.Luis0DEV.Application.ModelResponse.ResponseModel;
import com.Luis0DEV.Application.Ultius.RestException;
import com.Luis0DEV.Domain.Interface.Services.IServiceBase;

import java.util.List;
import java.util.UUID;
import java.util.function.Predicate;

public class AppServiceBase<T> implements IAppServiceBase<T> {

    private  IServiceBase<T> _serviceBase;
    public AppServiceBase(IServiceBase<T> serviceBase){

        _serviceBase = serviceBase;
    }

    public  T Create(T tabelaGenerica){
        try {
            return _serviceBase.Create(tabelaGenerica);
        }
        catch (Exception e){
            throw e;
        }
    }

    public T GetById(UUID id){
        try{
            return _serviceBase.GetById(id);
        }
        catch (Exception e){
            throw e;
        }
    }

    public List<T> GetByFilter(Predicate<T> filter){
        return _serviceBase.GetByFilter(filter);
    }

    public ResponseModel Update(T tabelaGenerica){
        ResponseModel resposta = new ResponseModel();
        try{
            _serviceBase.Update(tabelaGenerica);
            resposta.Success = true;
            resposta.Error = false;
            resposta.Message = "Atualizado com Sucesso";
        }
        catch (Exception e){
            RestException restExceptions = new RestException(e);
            return restExceptions.tratarErro();
        }
        return resposta;
    }

    public ResponseModel Delete(T tabelaGenerica){

        ResponseModel resposta = new ResponseModel();
        try{
            _serviceBase.Delete(tabelaGenerica);
            resposta.Success = true;
            resposta.Error = false;
            resposta.Message = "Deletado com Sucesso";
        }
        catch (Exception e){
            RestException restExceptions = new RestException(e);
            return restExceptions.tratarErro();
        }
        return resposta;
    }

    public ResponseModel AddRange(List<T> listaTabelasGenericas){

        ResponseModel resposta = new ResponseModel();
        try{
            _serviceBase.AddRange(listaTabelasGenericas);
            resposta.Success = true;
            resposta.Error = false;
            resposta.Message = "Deletado com Sucesso";
        }
        catch (Exception e){
            RestException restExceptions = new RestException(e);
            return restExceptions.tratarErro();
        }
        return resposta;
    }

    public ResponseModel UpdateRange(List<T> listaTabelasGenericas){
        ResponseModel resposta = new ResponseModel();
        try{
            _serviceBase.UpdateRange(listaTabelasGenericas);
            resposta.Success = true;
            resposta.Error = false;
            resposta.Message = "Deletado com Sucesso";
        }
        catch (Exception e){
            RestException restExceptions = new RestException(e);
            return restExceptions.tratarErro();
        }
        return resposta;
    }

    public ResponseModel DeleteRange(List<T> listaTabelasGenericas){
        ResponseModel resposta = new ResponseModel();
        try{
            _serviceBase.DeleteRange(listaTabelasGenericas);
            resposta.Success = true;
            resposta.Error = false;
            resposta.Message = "Deletado com Sucesso";
        }
        catch (Exception e){
            RestException restExceptions = new RestException(e);
            return restExceptions.tratarErro();
        }
        return resposta;
    }
}