package edu.mum.cs.cs525.labs.exercises.project.console.credit;

import edu.mum.cs.cs525.labs.exercises.project.console.framework.CreditCardFactory;

import java.util.HashMap;
import java.util.Map;

public class CreditCardFactoryProvider {
    private static final Map<String, CreditCardFactory> factories = new HashMap<>();

    // This is a static initializer block. It is executed when the class is loaded.
    static {
        factories.put("Gold", new GoldCreditCardFactory());
        factories.put("Silver", new SilverCreditCardFactory());
        factories.put("Bronze", new BronzeCreditCardFactory());
    }

    public static CreditCardFactory getFactory(String type) {
        CreditCardFactory factory = factories.get(type);
        if (factory == null) {
            throw new IllegalArgumentException("Unknown credit card type");
        }
        return factory;
    }

    public static void registerFactory(String type, CreditCardFactory factory) {
        factories.put(type, factory);
    }
}
