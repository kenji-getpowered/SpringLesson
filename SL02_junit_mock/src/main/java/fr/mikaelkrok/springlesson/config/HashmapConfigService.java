package fr.mikaelkrok.springlesson.config;

import java.util.HashMap;
import java.util.Map;
import fr.mikaelkrok.springlesson.config.*;

import org.springframework.stereotype.Service;

/**
 * 
 * @author Mikael KROK
 * 
 *         Basic configuration interface
 */
@Service
public class HashmapConfigService implements ConfigService {

	private Map<String, Long> params = new HashMap<String, Long>();
	// instance initializer
	{
		params.put(VatRate.SPECIFIC.toString(), 0l);
		params.put(VatRate.REDUCED.toString(), 5l);
		params.put(VatRate.STANDARD.toString(), 20l);
	}

	public Long getRate(VatRate param) {
		Long result = 1l;
		if (param != null && params.containsKey(param.toString())) {
			result = params.get(param.toString());
		}
		return result;
	}
}