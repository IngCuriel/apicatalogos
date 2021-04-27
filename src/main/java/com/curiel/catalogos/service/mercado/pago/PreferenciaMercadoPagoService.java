package com.curiel.catalogos.service.mercado.pago;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

//SDK de Mercado Pago
import com.mercadopago.MercadoPago;
import com.mercadopago.exceptions.MPException;
import com.mercadopago.resources.Preference;
import com.mercadopago.resources.datastructures.preference.Address;
import com.mercadopago.resources.datastructures.preference.BackUrls;
import com.mercadopago.resources.datastructures.preference.Item;
import com.mercadopago.resources.datastructures.preference.Payer;
import com.mercadopago.resources.datastructures.preference.Phone;
 
@Service
public class PreferenciaMercadoPagoService {
    private static final Logger LOGGER = LoggerFactory.getLogger(PreferenciaMercadoPagoService.class);
    
	public String create () {
		LOGGER.info("generatePrefence -->");
		try {
			 MercadoPago.SDK.setAccessToken("TEST-5133510306749950-121902-f1a316f3ba3e5c89b2dcfb5ede014fde-261326988");
			 Preference preference = new Preference();
			
			 Item item = new Item();
			 item.setTitle("Mi productos mioS  ")
			    .setQuantity(1)
			    .setUnitPrice((float) 75.56);
			 preference.appendItem(item);
			 
			 Payer payer = new Payer();
			 payer.setName("Charles")
		     .setSurname("Luevano")
		     .setEmail("eleazar.isc@gmail.com")
		     .setDateCreated("2018-06-02T12:58:41.425-04:00")
		     .setPhone(new Phone()
		        .setAreaCode("")
		        .setNumber("949 128 866"))
		      
		     .setAddress(new Address()
		        .setStreetName("Cuesta Miguel Armendáriz")
		        .setStreetNumber(1004)
		        .setZipCode("11020"));
			 
			 preference.setNotificationUrl("http://apiventascurielqa.herokuapp.com/api/v1/mercado.pago/notificaciones/");
			 BackUrls backUrls = new BackUrls();
			 backUrls.setSuccess("https://tiendacuriel.com");
			 backUrls.setPending("https://tiendacuriel.com/productos");
			 backUrls.setFailure("https://ingcuriel.com");
			 
			 preference.setBackUrls(backUrls);
			 preference.setPayer(payer);
			 preference.save();
			
			
			LOGGER.info("Response preference mercado pago {}", preference.getId());
			LOGGER.info("Response preference sandbox_init_point {}", preference.getSandboxInitPoint());
			LOGGER.info("Response preference init_point {}", preference.getInitPoint());
		} catch (MPException e) {
 			e.printStackTrace();
		}
		LOGGER.info("generatePreference //>");
		return "Create preferencia";
	}
}
