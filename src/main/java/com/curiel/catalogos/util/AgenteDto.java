package com.curiel.catalogos.util;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public abstract class AgenteDto {
   Long id;
   String name;
   String email;
   Date createAt;

}
