package com.curiel.catalogos.controller.mercado.pago;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.curiel.catalogos.service.mercado.pago.PreferenciaMercadoPagoService;

@RestController
@RequestMapping("api/v1/mercado.pago/references")
public class PreferenceMercadoPagoController {
   
	@Autowired
	private PreferenciaMercadoPagoService preferenciaMercadoPagoService;
 	
	@PostMapping
	public ResponseEntity<String> generarReferencia(@RequestBody String sss) {
		String respuesta = preferenciaMercadoPagoService.create();
		return new ResponseEntity<>(respuesta, HttpStatus.OK);
	}
}
