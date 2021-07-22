package com.practise.java8.useEnum.moduleTest;

public class ModuleNameDTO {
    private String moduleName;
    private String moduleDesc;


    public ModuleNameDTO() {
    }

    public ModuleNameDTO(String moduleName, String moduleDesc) {
        this.moduleName = moduleName;
        this.moduleDesc = moduleDesc;
    }

    public String getModuleName() {
        return moduleName;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }

    public String getModuleDesc() {
        return moduleDesc;
    }

    public void setModuleDesc(String moduleDesc) {
        this.moduleDesc = moduleDesc;
    }

    @Override
    public String toString() {
        return "ModuleNameDTO{" +
                "moduleName='" + moduleName + '\'' +
                ", moduleDesc='" + moduleDesc + '\'' +
                '}';
    }
}