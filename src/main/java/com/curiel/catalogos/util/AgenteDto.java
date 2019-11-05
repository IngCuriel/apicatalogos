package com.curiel.catalogos.util;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public abstract class AgenteDto {
   Long id;
   String name;
   String email;
}
