package com.mascotapp.mascotapp.converters;

import java.util.ArrayList;
import java.util.List;

import com.mascotapp.mascotapp.entity.Perro;
import com.mascotapp.mascotapp.exceptions.ConvertionError;
import com.mascotapp.mascotapp.models.PerroModel;
import com.mascotapp.mascotapp.repository.PerroRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import lombok.RequiredArgsConstructor;

@Component("PerroConverter")
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class PerroConverter extends Converter<PerroModel, Perro> {

    private final PerroRepository perroRepository;
    private final FotoConverter fotoConverter;

    public PerroModel entityToModel(Perro entity) {
        PerroModel model = new PerroModel();
        try {

            if (entity.getFotoPerfil() != null) {
                model.setFotoPerfil(fotoConverter.entityToModel(entity.getFotoPerfil()));
            }

            BeanUtils.copyProperties(entity, model);

        } catch (Exception e) {
            throw new ConvertionError("Error al convertir la entidad "+entity.toString()+" a modelo"  );
        }

        return model;
    }

    public Perro modelToEntity(PerroModel model) {

        Perro entity;

        if (model.getId() != null && !model.getId().isEmpty()) {
            entity = perroRepository.getOne(model.getId());
        } else {
            entity = new Perro();
        }

        try {

            if (model.getFotoPerfil() != null) {
                entity.setFotoPerfil(fotoConverter.modelToEntity(model.getFotoPerfil()));
            }

            BeanUtils.copyProperties(model, entity);
        } catch (Exception e) {
            throw new ConvertionError("error al convertir el modelo "+model.toString()+" a entidad");
        }

        return entity;
    }

    public List<PerroModel> entitiesToModels(List<Perro> entities) {
        List<PerroModel> models = new ArrayList<>();
        for (Perro a : entities) {
            models.add(entityToModel(a));
        }
        return models;
    }

    @Override
    public List<Perro> modelsToEntities(List<PerroModel> m) {
        List<Perro> entities = new ArrayList<>();
        for (PerroModel model : m) {
            entities.add(modelToEntity(model));
        }
        return entities;
    }

}