package org.example.JavaGuide.generic;

public class GenericInterfaceImpl<T> implements GenericInterface<String> {
    @Override
    public String genericMethod() {
        return "GenericInterfaceImpl.genericMethod";
    }
}
