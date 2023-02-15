package com.mascotapp.mascotapp.converters;

import java.util.ArrayList;
import java.util.List;

import com.mascotapp.mascotapp.entity.Perro;
import com.mascotapp.mascotapp.entity.Usuario;
import com.mascotapp.mascotapp.exceptions.ConvertionError;
import com.mascotapp.mascotapp.models.PerroModel;
import com.mascotapp.mascotapp.models.UsuarioModel;
import com.mascotapp.mascotapp.repository.PerroRepository;
import com.mascotapp.mascotapp.repository.UsuarioRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;

@Component("UsuarioConverter")
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class UsuarioConverter extends Converter<UsuarioModel, Usuario> {

    private final UsuarioRepository usuarioRepository;
    private final PerroRepository perroRepository;
    private final PerroConverter perroConverter;
    private final FotoConverter fotoConverter;

    public UsuarioModel entityToModel(Usuario entity) {
        UsuarioModel model = new UsuarioModel();
        try {

            if (entity.getFotoDePerfil() != null) {
                model.setFotoDePerfil(fotoConverter.entityToModel(entity.getFotoDePerfil()));
            }

            if (entity.getPerros() != null) {
                StringBuilder seleccionada = new StringBuilder();
                List<PerroModel> subModels = new ArrayList<>();

                for (Perro objeto : entity.getPerros()) {

                    subModels.add(perroConverter.entityToModel(objeto));
                    model.getPerrosId().add(objeto.getId());
                    seleccionada.append(objeto.getId()).append(",");

                }

                model.setPerros(subModels);
            }

            BeanUtils.copyProperties(entity, model);

        } catch (Exception e) {
            throw new ConvertionError("Error al convertir la entidad " + entity.toString() + " a modelo");
        }

        return model;
    }

    public Usuario modelToEntity(UsuarioModel model) {

        Usuario entity;

        if (model.getId() != null && !model.getId().isEmpty()) {
            entity = usuarioRepository.getById(model.getId());
        } else {
            entity = new Usuario();
        }

        try {

            BeanUtils.copyProperties(model, entity);

            if (model.getFotoDePerfil() != null) {
                entity.setFotoDePerfil(fotoConverter.modelToEntity(model.getFotoDePerfil()));
            }

            if ( model.getPerrosId() != null && model.getPerrosId().size() > 0) {

                List<Perro> list = new ArrayList<>();
                for (String id : model.getPerrosId()) {

                    Perro subEntity = perroRepository.getOne(id);
                    list.add(subEntity);

                }

                entity.setPerros(list);
            }

        } catch (Exception e) {
            throw new ConvertionError("error al convertir el modelo " + model.toString() + " a entidad");
        }

        return entity;
    }

    public List<UsuarioModel> entitiesToModels(List<Usuario> entities) {
        List<UsuarioModel> models = new ArrayList<>();
        for (Usuario a : entities) {
            models.add(entityToModel(a));
        }
        return models;
    }

    @Override
    public List<Usuario> modelsToEntities(List<UsuarioModel> m) {
        List<Usuario> entities = new ArrayList<>();
        for (UsuarioModel model : m) {
            entities.add(modelToEntity(model));
        }
        return entities;
    }

}
