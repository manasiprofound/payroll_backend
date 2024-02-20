package payrollweb.itprofound.core;


public class BaseRuleImpl<E> implements BaseRule<E> {

	protected ValidationResponse response = new ValidationResponse();

	public ValidationResponse validate(E entity, Character option) {
		return response;
	}

}
