package fr.mikaelkrok.springlesson;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import fr.mikaelkrok.springlesson.config.ConfigService;
import fr.mikaelkrok.springlesson.config.VatRate;

/**
 * 
 * @author Mikael KROK
 * 
 *       Spring class containing  methods for unit testing purposes
 */
@Service
public class OperationsService {
	
	@Inject
	private ConfigService configService;

	/**
	 * 
	 * @param numbers
	 * @return
	 */
	public long add(final long... numbers) {
		long result = 0;
		for (final long number : numbers) {
			result += number;
		}
		return result;
	}

	/**
	 * 
	 * @param numbers
	 * @return
	 */
	public long multiply(final long... numbers) {
		long result = 1;
		for (final long number : numbers) {
			result *= number;
		}
		return result;
	}

	/**
	 * 
	 * @param numbers
	 * @return
	 */
	public long divide(final long... numbers) {
		if (numbers.length < 2) {
			throw new IllegalArgumentException("Il faut au moins deux nombres en entrée");
		}
		long result = numbers[0];
		for (int i = 1; i < numbers.length; i++) {
			result /= numbers[i];
		}
		return result;
	}
	
	/**
	 * Calculate the value with the VAT
	 * @param value
	 * @param vatRate
	 * @return
	 */
	public long calculateVAT(final long value, VatRate vatRate){
		return value * configService.getRate(vatRate);
	}

}