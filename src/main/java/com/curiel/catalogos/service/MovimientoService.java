package com.curiel.catalogos.service;

 import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import com.curiel.catalogos.model.dto.DetalleMovDto;
import com.curiel.catalogos.model.dto.MovimientoDto;
import com.curiel.catalogos.model.dto.ProductoDto;
import com.curiel.catalogos.model.entity.DetalleMov;
import com.curiel.catalogos.model.entity.Movimiento;
import com.curiel.catalogos.model.entity.Producto;
import com.curiel.catalogos.repository.MovimientoRepository;
import com.curiel.catalogos.util.GenericService;

 
@Service
public class MovimientoService implements GenericService<MovimientoDto, Movimiento, Long>{
  @Autowired
  private MovimientoRepository movimientoRepository;
  
  @Autowired
  private ModelMapper modelMapper;

    @Override
    @Transactional(readOnly=true)
    public Set<MovimientoDto> list() {
        Set<MovimientoDto> movimientoDtoList= new HashSet<>();
        movimientoRepository.findAll().forEach(movimiento->movimientoDtoList.add(convertToDto(movimiento)));
        return movimientoDtoList;
    }
    
    @Override
    @Transactional
    public void delete(Long id) {
         movimientoRepository.deleteById(id);
    }
    
    @Override
    @Transactional
    public MovimientoDto save(MovimientoDto dto) {
        Movimiento movimiento=movimientoRepository.save(convertToEntity(dto));
         return convertToDto(movimiento);
    }
    
    @Transactional
    public boolean updateMovimiento(Map<String, Object> updates, Long id) {
    	Movimiento movimientoAntes=movimientoRepository.getOne(id);
    	Movimiento movimiento=modelMapper.map(updates, Movimiento.class);
    	if(movimiento.getStatus() != null){
    		movimientoAntes.setStatus(movimiento.getStatus());
    	}
    	if(movimiento.getTotal() != null){
    		movimientoAntes.setTotal(movimiento.getTotal());
    	}
    	if(movimiento.getDetallesMov() != null){
    		movimientoAntes.setDetallesMov(movimiento.getDetallesMov());
    	} 
    	 movimientoRepository.save(movimientoAntes);
    	return true;
    }
    
    @Override
    @Transactional(readOnly=true)
    public MovimientoDto getById(Long id) {
         Movimiento movimiento=movimientoRepository.getOne(id);
         return convertToDto(movimiento);
    }
    @Transactional(readOnly=true)
    public Page<MovimientoDto> getAllPage(Pageable pageable){
    	List<MovimientoDto> movimientoListDto=new ArrayList<>();
    	Page<Movimiento> movimientoDtoPage;
    	movimientoDtoPage = movimientoRepository.findAllByOrderByIdDesc(pageable);
    	movimientoDtoPage.getContent().forEach(movimientoContent-> movimientoListDto.add(convertToDto(movimientoContent)));
        return new PageImpl<>(movimientoListDto, pageable, movimientoDtoPage.getTotalElements());
    }
    
    @Transactional(readOnly=true)
    public List<MovimientoDto> getByClienteProveedor(String clienteProveedor) {
    	List<MovimientoDto> movimientoDtoList=new ArrayList<>();
        List<Movimiento> movimientos= movimientoRepository.findByClienteProveedorOrderByIdDesc(clienteProveedor);
        MovimientoDto movimientoDto;
        //ProductoDto producto=new ProductoDto();
        for(Movimiento movimiento:movimientos) {
        	movimientoDto = new MovimientoDto();
            movimientoDto.setId(movimiento.getId());
            movimientoDto.setDateCreated(movimiento.getDateCreated());
            movimientoDto.setClienteProveedor(movimiento.getClienteProveedor());
            movimientoDto.setDescripcion(movimiento.getDescripcion());
            movimientoDto.setStatus(movimiento.getStatus());
            movimientoDto.setDateUpdated(movimiento.getDateUpdated());
            Set<DetalleMovDto> detalleMovDtoList=new HashSet();
            DetalleMovDto detalleMovDto ;
            for(DetalleMov detalle:movimiento.getDetallesMov()) {
            	detalleMovDto =new DetalleMovDto();
            	detalleMovDto.setId(detalle.getId());
            	detalleMovDto.setCantidad(detalle.getCantidad());
            	detalleMovDto.setImporte(detalle.getImporte());
                
            	ProductoDto productoDto=new ProductoDto();
            	productoDto.setId(detalle.getProducto().getId());
            	productoDto.setNombre(detalle.getProducto().getNombre());
            	productoDto.setDescripcion(detalle.getProducto().getDescripcion());
            	productoDto.setImagen(detalle.getProducto().getImagen());
            	productoDto.setPrecio(detalle.getProducto().getPrecio());
            	productoDto.setCosto(detalle.getProducto().getCosto());
            	
            	detalleMovDto.setProducto(productoDto);
            	detalleMovDtoList.add(detalleMovDto);
            }
            movimientoDto.setDetallesMov(detalleMovDtoList);
            movimientoDto.setObservacion(movimiento.getObservacion());
            movimientoDto.setTotal(movimiento.getTotal());
            movimientoDtoList.add(movimientoDto);
        }
        return movimientoDtoList;
    }
    
    @Override
    public MovimientoDto convertToDto(Movimiento entity) {
         return modelMapper.map(entity, MovimientoDto.class);
    }
    
    @Override
    public Movimiento convertToEntity(MovimientoDto dto) {
         return modelMapper.map(dto, Movimiento.class);
    }
    
    public ByteArrayInputStream generateExcelMovimientos() throws IOException {
    	Workbook workbook=new HSSFWorkbook(); //create new book
		ByteArrayOutputStream stream=new ByteArrayOutputStream();
		Sheet sheet= workbook.createSheet("Reporte"); // create new sheet 
		Row rowHeaders= sheet.createRow(0);
		String[] Columns= {"Fecha","Cliente","Observaciones","Description","Cantidad","Producto","Clave","Precio","Estatus"};
		for(int i=0;i<Columns.length;i++) {
 			Cell cell=rowHeaders.createCell(i); 
            cell.setCellValue(Columns[i]);
		}
		
		int indexrow=1;
		String pattern = "MM-dd-yyyy HH:mm:ss";
		SimpleDateFormat simpleDateFormat =new SimpleDateFormat(pattern, new Locale("fr", "FR"));
 		BigDecimal importeTotal=new BigDecimal(0);
  		for(int i=0;i<movimientoRepository.findAll().size();i++ ) {
 			Row row = sheet.createRow(indexrow);
 			Cell cellFecha=row.createCell(0); 
 			String fechatime = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss").format(movimientoRepository.findAll().get(i).getDateCreated());

 			//cellFecha.setCellValue(simpleDateFormat.format(movimientoRepository.findAll().get(i).getDateCreated()));
 			cellFecha.setCellValue(fechatime);
 			Cell cellCliente=row.createCell(1); 
 			cellCliente.setCellValue(movimientoRepository.findAll().get(i).getClienteProveedor());	
			Cell cellObservacion=row.createCell(2); 
			cellObservacion.setCellValue(movimientoRepository.findAll().get(i).getObservacion());	
			Cell cellDescripcioon=row.createCell(3); 
			cellDescripcioon.setCellValue(movimientoRepository.findAll().get(i).getDescripcion());
			Cell cellStatus=row.createCell(8); 
			cellStatus.setCellValue(movimientoRepository.findAll().get(i).getStatus().toString());
			
			Set<DetalleMov> detalle=  movimientoRepository.findAll().get(i).getDetallesMov();
				for(DetalleMov detal:detalle) {
					indexrow+=1;
					Row rowDetalle = sheet.createRow(indexrow);
					Cell cellCantidad=rowDetalle.createCell(4); 
		 			cellCantidad.setCellValue(String.valueOf(detal.getCantidad()));
		 			
		 			Cell cellProducto=rowDetalle.createCell(5); 
		 			cellProducto.setCellValue(detal.getProducto().getNombre());
		 			
		 			Cell cellClave=rowDetalle.createCell(6); 
		 			cellClave.setCellValue( detal.getProducto().getId());
		 			
		 			Cell cellPrecio=rowDetalle.createCell(7); 
		 			cellPrecio.setCellValue("$ "+detal.getImporte());
		 			
                 }
			indexrow+=1;
			Row rowTotal= sheet.createRow(indexrow);
			Cell cellTotalEtiqueta=rowTotal.createCell(6); 
			cellTotalEtiqueta.setCellValue("Total $ ");
			Cell cellTotal=rowTotal.createCell(7); 
			cellTotal.setCellValue("$ "+movimientoRepository.findAll().get(i).getTotal());
			indexrow+=1;
			importeTotal=importeTotal.add(movimientoRepository.findAll().get(i).getTotal());
 		} 
  	    indexrow++;
		Row rowImporteTotal= sheet.createRow(indexrow);
		Cell cellTotalEtiqueta=rowImporteTotal.createCell(6); 
		cellTotalEtiqueta.setCellValue("Importe Total $ ");
  	    Cell cellTotal=rowImporteTotal.createCell(7); 
		cellTotal.setCellValue("$ "+importeTotal);
		indexrow++;
		workbook.write(stream);
		workbook.close();
	    return new ByteArrayInputStream(stream.toByteArray());	
    }
    
   
}
