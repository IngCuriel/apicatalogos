package com.curiel.catalogos.service;
import java.util.HashSet;
import java.util.Set;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.curiel.catalogos.model.dto.CategoriaDto;
import com.curiel.catalogos.model.entity.Categoria;
import com.curiel.catalogos.repository.CategoriaRespository;
import com.curiel.catalogos.util.GenericService;

@Service
public class CategoriaService implements GenericService<CategoriaDto, Categoria, Long>{
    
	@Autowired
	private CategoriaRespository categoriaRespository;
	
	@Autowired
	private ModelMapper modelmaper;
	
	@Override
	@Transactional(readOnly=true)
	public Set<CategoriaDto> list() {
		Set<CategoriaDto> listCategoriaDto=new HashSet<>();
		categoriaRespository.findAll().forEach(categoria->listCategoriaDto.add(convertToDto(categoria)));
		return listCategoriaDto;
	}
	
	@Transactional(readOnly=true)
	public Set<CategoriaDto> listCategoria(int status) {
		Set<CategoriaDto> listCategoriaDto=new HashSet<>();
		categoriaRespository.findByCategoriaIdIsNullAndStatus(status).forEach(categoria->listCategoriaDto.add(convertToDto(categoria)));
		return listCategoriaDto;
	}
	
	@Transactional(readOnly=true)
	public Set<CategoriaDto> listSubCategoria(Long categoriaId, int status) {
		Set<CategoriaDto> listCategoriaDto=new HashSet<>();
		categoriaRespository.findByCategoriaIdAndStatus(categoriaId,status).forEach(categoria->listCategoriaDto.add(convertToDto(categoria)));
		return listCategoriaDto;
	}

	@Override
	@Transactional
	public void delete(Long id) {
		categoriaRespository.deleteById(id);
	}

	@Override
	@Transactional
	public CategoriaDto save(CategoriaDto dto) {
		Categoria catagoria=categoriaRespository.save(convertToEntity(dto));
		return convertToDto(catagoria);
	}

	@Override
	@Transactional(readOnly=true)
	public CategoriaDto getById(Long id) {
		Categoria catagoria=categoriaRespository.getOne(id);
		return convertToDto(catagoria);
	}

	@Override
	public CategoriaDto convertToDto(Categoria entity) {
 		return modelmaper.map(entity, CategoriaDto.class);
	}

	@Override
	public Categoria convertToEntity(CategoriaDto dto) {
 		return modelmaper.map(dto, Categoria.class);
	}
   
}
