package com.kiranCapstone.ia.constant;

import java.util.HashMap;
import java.util.Map;

public enum SupportedTechnology {

	JAVA(100), DOTNET(90), PYTHON(80), C(80), GO(110), ANGULAR(100), REACT(90), SCRUM_MASTER(120);

	int invoiceAmount;
	private static final Map<String, Integer> invoiceAmountByName = new HashMap<>();
	static {
		for (SupportedTechnology technology : SupportedTechnology.values()) {
			invoiceAmountByName.put(technology.name(), technology.getInvoiceAmount());
		}
	}

	private SupportedTechnology(int invoiceAmount) {
		this.invoiceAmount = invoiceAmount;
	}

	public int getInvoiceAmount() {
		return invoiceAmount;
	}

	public static int getInvoiceAmountByName(String name) {
		return invoiceAmountByName.get(name.toUpperCase());
	}

}
