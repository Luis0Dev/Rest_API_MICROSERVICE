package com.Luis0DEV.Application.Interface;

import com.Luis0DEV.Application.ModelResponse.ResponseModel;
import com.Luis0DEV.Application.Ultius.RestException;

import java.util.List;
import java.util.UUID;
import java.util.function.Predicate;

public interface IAppServiceBase<T> {

    public T Create(T tabelaGenerica);
    public T GetById(UUID id);
    List<T> GetByFilter(Predicate<T> filter);
    public ResponseModel Update(T tabelaGenerica);
    public ResponseModel  Delete(T tabelaGenerica);

    public ResponseModel AddRange(List<T> listaTabelasGenericas);
    public ResponseModel UpdateRange(List<T> listaTabelasGenericas);
    public ResponseModel DeleteRange(List<T> listaTabelasGenericas);

}