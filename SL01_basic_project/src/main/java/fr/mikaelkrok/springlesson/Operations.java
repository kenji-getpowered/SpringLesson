package fr.mikaelkrok.springlesson;

/**
 * 
 * @author Mikael KROK
 * 
 *         Class containing static methods for unit testing purposes
 */
public class Operations {

	/**
	 * 
	 * @param numbers
	 * @return
	 */
	public static long add(final long... numbers) {
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
	public static long multiply(final long... numbers) {
		long result = 0;
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
	public static long divide(final long... numbers) {
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