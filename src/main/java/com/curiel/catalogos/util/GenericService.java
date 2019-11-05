package com.curiel.catalogos.util;

import java.util.Set;

public interface GenericService<T,E,PK> {
 
   Set<T> list();
  
   void  delete(PK id);
  
   T save (T dto);
   
   T getById(PK id);
      
   T convertToDto(E entity);
   
   E convertToEntity(T dto);
   
   
}
