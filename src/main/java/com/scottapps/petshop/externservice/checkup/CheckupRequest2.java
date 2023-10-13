package com.scottapps.petshop.externservice.checkup;

public class CheckupRequest2 extends CheckupRequest {
    private String additionalField;

    public CheckupRequest2() {
        super();
    }

    public CheckupRequest2(String someSharedField, String additionalField) {
        super(someSharedField);
        this.additionalField = additionalField;
    }

    public String getAdditionalField() {
        return additionalField;
    }

    public void setAdditionalField(String additionalField) {
        this.additionalField = additionalField;
    }

    @Override
    public String toString() {
        return "CheckupRequest2{" +
                "additionalField='" + additionalField + '\'' +
                "} " + super.toString();
    }
}
