package br.com.caio.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import br.com.caio.converters.NumberConverter;
import br.com.caio.exceptions.UnsupportedMathOperationException;
import br.com.caio.math.SimpleMath;

@RestController
public class MathController {
	
	private SimpleMath math = new SimpleMath();
	
	@GetMapping("/sum/{numberOne}/{numberTwo}")
	public Double sum(@PathVariable String numberOne, @PathVariable String numberTwo) throws Exception {
		
		if (Boolean.FALSE.equals(NumberConverter.isNumeric(numberOne) && NumberConverter.isNumeric(numberTwo))) {
			throw new UnsupportedMathOperationException("Valor não numérico informado.");
		}
		
		return math.sum(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo));
	}
	
	@GetMapping("/subtraction/{numberOne}/{numberTwo}")
	public Double subtraction(@PathVariable String numberOne, @PathVariable String numberTwo) throws Exception {
		
		if (Boolean.FALSE.equals(NumberConverter.isNumeric(numberOne) && NumberConverter.isNumeric(numberTwo))) {
			throw new UnsupportedMathOperationException("Valor não numérico informado.");
		}
		
		return math.subtraction(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo));
	}
	
	@GetMapping("/multiplication/{numberOne}/{numberTwo}")
	public Double multiplication(@PathVariable String numberOne, @PathVariable String numberTwo) throws Exception {
		
		if (Boolean.FALSE.equals(NumberConverter.isNumeric(numberOne) && NumberConverter.isNumeric(numberTwo))) {
			throw new UnsupportedMathOperationException("Valor não numérico informado.");
		}
		
		return math.multiplication(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo));
	}
	
	@GetMapping("/division/{numberOne}/{numberTwo}")
	public Double division(@PathVariable String numberOne, @PathVariable String numberTwo) throws Exception {
		
		if (Boolean.FALSE.equals(NumberConverter.isNumeric(numberOne) && NumberConverter.isNumeric(numberTwo))) {
			throw new UnsupportedMathOperationException("Valor não numérico informado.");
		}
		
		return math.division(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo));
	}
	
	@GetMapping("/mean/{numberOne}/{numberTwo}")
	public Double mean(@PathVariable String numberOne, @PathVariable String numberTwo) throws Exception {
		
		if (Boolean.FALSE.equals(NumberConverter.isNumeric(numberOne) && NumberConverter.isNumeric(numberTwo))) {
			throw new UnsupportedMathOperationException("Valor não numérico informado.");
		}
		
		return math.mean(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo));
	}
	
	@GetMapping("/squareRoot/{number}")
	public Double squareRoot(@PathVariable String number) throws Exception {
		
		if (Boolean.FALSE.equals(NumberConverter.isNumeric(number))) {
			throw new UnsupportedMathOperationException("Valor não numérico informado.");
		}
		
		return math.squareRoot(NumberConverter.convertToDouble(number));
	}
}
