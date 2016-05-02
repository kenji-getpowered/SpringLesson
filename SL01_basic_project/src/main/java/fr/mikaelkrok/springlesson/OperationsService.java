package fr.mikaelkrok.springlesson;

import org.springframework.stereotype.Service;

/**
 * 
 * @author Mikael KROK
 * 
 *       Spring class containing  methods for unit testing purposes
 */
@Service
public class OperationsService {

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

}