package com.Luis0DEV.API.Mapper;

import com.Luis0DEV.API.Models.Register_Model;
import com.Luis0DEV.Domain.Entities.tb_rgs_register;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ModelToDomain {

    ModelToDomain INSTANCE = Mappers.getMapper(ModelToDomain.class);

    Register_Model Tb_Register(tb_rgs_register register);
    tb_rgs_register Register(Register_Model registerModel);

}
