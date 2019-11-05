package com.curiel.catalogos.util;
import java.util.Set;
import org.springframework.http.ResponseEntity;

public interface GenericController<T,PK> {
    ResponseEntity<Set<T>> list();
    
    ResponseEntity<T> delete(PK id);
   
    ResponseEntity<T> save(T dto);
    
    ResponseEntity<T> update(T dto);
    
    ResponseEntity<T> getById(PK id);
    
 
}
