package com.Luis0DEV.Domain.Interface.Services;

import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;
import java.util.UUID;
import java.util.function.Predicate;

public interface IServiceBase<T> {

    public T Create(T tabelaGenerica);
    public  T GetById(UUID id);
    List<T> GetByFilter(Predicate<T> filter);
    public boolean Update(T tabelaGenerica);
    public void  Delete(T tabelaGenerica);

    public boolean AddRange(List<T> listaTabelasGenericas);
    public boolean UpdateRange(List<T> listaTabelasGenericas);
    public boolean DeleteRange(List<T> listaTabelasGenericas);

}
