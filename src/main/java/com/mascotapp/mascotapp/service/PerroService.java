package com.mascotapp.mascotapp.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.mascotapp.mascotapp.converters.PerroConverter;
import com.mascotapp.mascotapp.entity.Perro;
import com.mascotapp.mascotapp.exceptions.ValidationError;
import com.mascotapp.mascotapp.models.PerroModel;
import com.mascotapp.mascotapp.repository.PerroRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class PerroService implements ServiceInterface<PerroModel, Perro> {

    private final PerroRepository perroRepository;
    private final PerroConverter perroConverter;

    @Override
    public Perro guardar(PerroModel m) throws Exception {

        validar(m);

        Perro entidad = perroConverter.modelToEntity(m);

        if (entidad.getAlta() == null) {

            entidad.setActivo(true);
            entidad.setAlta(new Date());
        }

        return perroRepository.save(entidad);
    }

    @Override
    public void eliminar(String id) throws Exception {
        Perro entidad = perroRepository.getOne(id);
        perroRepository.delete(entidad);
    }

    @Override
    public Perro alta(String id) throws Exception {
        Perro entidad = perroRepository.getOne(id);
        entidad.setActivo(true);
        return perroRepository.save(entidad);
    }

    @Override
    public Perro baja(String id) throws Exception {
        Perro entidad = perroRepository.getOne(id);
        entidad.setActivo(false);
        return perroRepository.save(entidad);
    }

    @Override
    public List<Perro> listarTodos() {
        return perroRepository.findAll();
    }

    @Override
    public List<Perro> listarActivos() {
        return perroRepository.searchAssets();
    }

    @Override
    public Page<Perro> listarActivos(Pageable paginable) {
        return perroRepository.searchAssets(paginable);
    }

    @Override
    public Page<Perro> buscarPorParametro(Pageable paginable, String q) {
        return perroRepository.searchByParam(paginable, q);
    }

    @Override
    public List<Perro> buscarPorParametro(String q) {
        return perroRepository.searchByParam(q);
    }

    @Override
    public Optional<Perro> buscarPorId(String id) {
        return perroRepository.findById(id);
    }

    @Override
    public Perro getOne(String id) {
        return perroRepository.getOne(id);
    }

    @Override
    public void validar(PerroModel m) throws ValidationError {

        if (m.getNombre() == null || m.getNombre().isEmpty() || m.getNombre().equals("")) {
            throw new ValidationError("El Perro tiene que tener un Nombre");
        }

        if (m.getRaza() == null || m.getRaza().equals("")) {
            throw new ValidationError("El Perro tiene que tener una Raza");
        }

        if (m.getFotoPerfil() == null) {
            throw new ValidationError("El Perro tiene que tener una Foto de perfil");
        }

    }

    @Override
    public PerroModel pasarAtributos(PerroModel source, PerroModel target) {

        BeanUtils.copyProperties(source, target, "id", "creado", "editado", "activo");

        return target;
    }

}
