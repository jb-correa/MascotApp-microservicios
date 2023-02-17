package com.mascotapp.mascotapp.service;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.mascotapp.mascotapp.exceptions.ValidationError;
import com.mascotapp.mascotapp.converters.UsuarioConverter;
import com.mascotapp.mascotapp.entity.Usuario;
import com.mascotapp.mascotapp.models.UsuarioModel;
import com.mascotapp.mascotapp.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class UsuarioService implements ServiceInterface<UsuarioModel, Usuario>{

    private final UsuarioRepository usuarioRepository;
    private final UsuarioConverter usuarioConverter;

    @Override
    public Usuario guardar(UsuarioModel m) throws Exception {

        validar(m);

        Usuario entidad = usuarioConverter.modelToEntity(m);

        if (entidad.getAlta() == null) {

            entidad.setActivo(true);
            entidad.setAlta(new Date());
        }

        return usuarioRepository.save(entidad);
    }

    @Override
    public void eliminar(String id) throws Exception {
        Usuario entidad = usuarioRepository.getById(id);
        usuarioRepository.delete(entidad);
    }

    @Override
    public Usuario alta(String id) throws Exception {
        Usuario entidad = usuarioRepository.getById(id);
        entidad.setActivo(true);
        return usuarioRepository.save(entidad);
    }

    @Override
    public Usuario baja(String id) throws Exception {
        Usuario entidad = usuarioRepository.getById(id);
        entidad.setActivo(false);
        return usuarioRepository.save(entidad);
    }

    @Override
    public List<Usuario> listarTodos() {
        return usuarioRepository.findAll();
    }

    @Override
    public List<Usuario> listarActivos() {
        return usuarioRepository.searchAssets();
    }

    @Override
    public Page<Usuario> listarActivos(Pageable paginable) {
        return usuarioRepository.searchAssets(paginable);
    }

    @Override
    public Page<Usuario> buscarPorParametro(Pageable paginable, String q) {
        return usuarioRepository.searchByParam(paginable, q);
    }

    @Override
    public List<Usuario> buscarPorParametro(String q) {
        return usuarioRepository.searchByParam(q);
    }

    @Override
    public Optional<Usuario> buscarPorId(String id) {
        return usuarioRepository.findById(id);
    }

    @Override
    public Usuario getOne(String id) {
        return usuarioRepository.findById(id);
    }

    @Override
    public void validar(UsuarioModel m) throws ValidationError {

        if (m.getNombre() == null || m.getNombre().isEmpty() || m.getNombre().equals("")) {
            throw new ValidationError("El Usuario tiene que tener un nombre");
        }

        if (m.getNombre() == null || m.getNombre().isEmpty() || m.getNombre().equals("")) {
            throw new ValidationError("El Usuario tiene que tener un apellido");
        }

        if (m.getFotoDePerfil() == null) {
            throw new ValidationError("El Usuario tiene que tener una Foto de perfil");
        }
    }

    @Override
    public UsuarioModel pasarAtributos(UsuarioModel source, UsuarioModel target) {

        BeanUtils.copyProperties(source, target, "id", "alta", "activo");

        return target;
    }

}
