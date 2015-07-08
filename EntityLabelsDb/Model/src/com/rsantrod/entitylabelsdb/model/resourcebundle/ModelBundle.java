package com.rsantrod.entitylabelsdb.model.resourcebundle;

public class ModelBundle extends DBResourceBundle {

    private static final Object[][] contents = {
        { "com.rsantrod.entitylabelsdb.model.Departments.DepartmentId_LABEL", "Identificador" } };

    public ModelBundle() {
        super();
    }

    @Override
    public String getLocaleCode() {
        return "es";
    }
}
