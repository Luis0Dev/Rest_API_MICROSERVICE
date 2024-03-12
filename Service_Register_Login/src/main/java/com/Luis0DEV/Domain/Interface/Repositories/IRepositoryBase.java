package com.Luis0DEV.Domain.Interface.Repositories;

import java.util.List;
import java.util.UUID;
import java.util.function.Predicate;

public interface IRepositoryBase<T> {

    public T Create(T tabelaGenerica);
    public T GetById(UUID id);
    List<T> GetByFilter(Predicate<T> filter);
    public boolean Update(T tabelaGenerica);
    public void  Delete(T tabelaGenerica);

    public boolean AddRange(List<T> listaTabelasGenericas);
    public boolean UpdateRange(List<T> listaTabelasGenericas);
    public boolean DeleteRange(List<T> listaTabelasGenericas);

}
