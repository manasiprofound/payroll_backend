package payrollweb.itprofound.core;


public interface BaseRule<E>{	
	public ValidationResponse validate(E entity, Character option);
}

