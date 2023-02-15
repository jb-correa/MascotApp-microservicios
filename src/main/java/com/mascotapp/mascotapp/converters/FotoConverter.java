package com.mascotapp.mascotapp.converters;
import java.util.ArrayList;
import java.util.List;

import com.mascotapp.mascotapp.entity.Foto;
import com.mascotapp.mascotapp.exceptions.ConvertionError;
import com.mascotapp.mascotapp.models.FotoModel;
import com.mascotapp.mascotapp.repository.FotoRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;

@Component("FotoConverter")
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class FotoConverter extends Converter<FotoModel, Foto> {

    private final FotoRepository fotoRepository;

    public FotoModel entityToModel(Foto entity) {
        FotoModel model = new FotoModel();
        try {
            BeanUtils.copyProperties(entity, model);
        } catch (Exception e) {
            throw new ConvertionError("Error al convertir la entidad "+entity.toString()+" a modelo"  );
        }

        return model;
    }

    public Foto modelToEntity(FotoModel model){
        Foto entity;
        if (model.getId() != null && !model.getId().isEmpty()) {
            entity = fotoRepository.getById(model.getId());
        } else {
            entity = new Foto();
        }

        try {
            BeanUtils.copyProperties(model, entity);
        } catch (Exception e) {
            throw new ConvertionError("error al convertir el modelo "+model.toString()+" a entidad");
        }

        return entity;
    }

    public List<FotoModel> entitiesToModels(List<Foto> entities) {
        List<FotoModel> models = new ArrayList<>();
        for (Foto a : entities) {
            models.add(entityToModel(a));
        }
        return models;
    }

    @Override
    public List<Foto> modelsToEntities(List<FotoModel> m) {
        List<Foto> entities = new ArrayList<>();
        for (FotoModel model : m) {
            entities.add(modelToEntity(model));
        }
        return entities;
    }

}
