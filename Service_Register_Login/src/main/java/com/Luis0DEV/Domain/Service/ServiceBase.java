package com.Luis0DEV.Domain.Service;

import com.Luis0DEV.Domain.Interface.Repositories.IRepositoryBase;
import com.Luis0DEV.Domain.Interface.Services.IServiceBase;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;
import java.util.UUID;
import java.util.function.Predicate;

public class ServiceBase<T> implements IServiceBase<T> {

    private IRepositoryBase<T> _repositoryBase;

    public ServiceBase (IRepositoryBase repositoryBase){

        _repositoryBase = repositoryBase;
    }
    public T Create(T tabelaGenerica){

        try{
            return _repositoryBase.Create(tabelaGenerica);
        }
        catch (Exception e){
            throw e;
        }
    }
    public T GetById(UUID id){

        try{
            return _repositoryBase.GetById(id);
        }
        catch (Exception e){
            throw e;
        }
    }

    public List<T> GetByFilter(Predicate<T> filter){
        try{
            return _repositoryBase.GetByFilter(filter);
        }
        catch (Exception e){
            throw e;
        }
    }
    public boolean Update(T tabelaGenerica){
        try{
            return _repositoryBase.Update(tabelaGenerica);
        }
        catch (Exception e){
            throw e;
        }
    }
    public void  Delete(T tabelaGenerica){
        try{
             _repositoryBase.Delete(tabelaGenerica);
        }
        catch (Exception e){
            throw e;
        }
    }

    public boolean AddRange(List<T> listaTabelasGenericas){
        try{
           return _repositoryBase.AddRange(listaTabelasGenericas);
        }
        catch (Exception e){
            throw e;
        }
    }
    public boolean UpdateRange(List<T> listaTabelasGenericas){
        try{
            return _repositoryBase.UpdateRange(listaTabelasGenericas);
        }
        catch (Exception e){
            throw e;
        }
    }
    public boolean DeleteRange(List<T> listaTabelasGenericas){
        try{
            return _repositoryBase.DeleteRange(listaTabelasGenericas);
        }
        catch (Exception e){
            throw e;
        }
    }
}
