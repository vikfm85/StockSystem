package ar.edu.iue.est.stocksystem.validator;

import org.apache.commons.validator.routines.EmailValidator;
import ar.edu.iue.est.stocksystem.model.CustomerInfo;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 * Clase utilizada para validar los campos del cliente
 * 
 * @author vikfm1985
 *
 */
@Component
public class CustomerInfoValidator implements Validator {

	private EmailValidator emailValidator = EmailValidator.getInstance();

	// Este validador soporta la clase CustomerInfo.
	@Override
	public boolean supports(Class<?> clazz) {
		return clazz == CustomerInfo.class;
	}

	@Override
	public void validate(Object target, Errors errors) {
		CustomerInfo custInfo = (CustomerInfo) target;

		// Verigico los campos de la clase CustomerInfo.
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "NotEmpty.customerForm.name");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "NotEmpty.customerForm.email");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "address", "NotEmpty.customerForm.address");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "phone", "NotEmpty.customerForm.phone");

		if (!emailValidator.isValid(custInfo.getEmail())) {
			errors.rejectValue("email", "Pattern.customerForm.email");
		}
	}

}