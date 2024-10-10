package br.com.caio.converters;

public final class NumberConverter {

	private NumberConverter() {}
	
	public static boolean isNumeric(String string) {
		if (string == null) return false;
		
		string = string.replaceAll(",", ".");
		
		return string.matches("[-+]?[0-9]*\\.?[0-9]+");
	}
	
	public static Double convertToDouble(String string) {
		if (string == null) throw new IllegalArgumentException("Valor nulo informado");
		
		string = string.replaceAll(",", ".");
		
		if (isNumeric(string)) return Double.parseDouble(string);
		
		return 0D;
	}
	
}
