package com.example.springBootLog.webApi;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/log")
public class LogEndpointsController {

	Logger logger = LoggerFactory.getLogger(this.getClass());

	@GetMapping
	public String getDetails() {
		log.debug("getDetails method started");
		return internalLogDeatil();
	}

	private String internalLogDeatil() {
		try {
			log.debug("internalLogDeatil method started");
			Thread.sleep(1000);
			return "API Message";

		} catch (InterruptedException e) {
			log.error("Error : {}", e);

		}
		return null;
	}

	/*
	 * Loglama da dikkat edilmesi gerekenler, nelere dikkat etmeliyiz? -Loglama
	 * asenkron olmalıdır. Loglamayı asenkron yapmazsak uygulamamızın performansı
	 * kaybediliyor olacak. Asenkron yaparsak request cevap verirken loglama
	 * yüzünden gecikmeyecektir. -printStackTrace ve System.out.println() loglamada
	 * kullanılmamalıdır. Çünkü log formatlarına aykırdır. -Sensitive data
	 * olmamalıdır. -Tüm loglar merkezi bir yerde ve belli bir formatta
	 * toplanmalıdır. -Levellar dikkatli kullanılmalıdır. -Farklı levellar için
	 * farklı appendarlar kullanılabilir.
	 */
}
