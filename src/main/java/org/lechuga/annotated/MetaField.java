package org.lechuga.annotated;

public class MetaField<E, T> {

    protected final String propertyName;

    public MetaField(String propertyName) {
        super();
        this.propertyName = propertyName;
    }

    public String getPropertyName() {
        return propertyName;
    }

}