package com.practise.useEnum;

import com.practise.useEnum.moduleTest.Module;
import com.practise.useEnum.moduleTest.ModuleNameDTO;
import com.sun.javafx.sg.prism.NGText;
import com.sun.org.slf4j.internal.Logger;
import com.sun.org.slf4j.internal.LoggerFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class useEnums {


    public static void main(String[] args) {
//----------------------------------------------------------------------------------------------
        final ProjectClusterType hdfs = ProjectClusterType.valueOf("HDFS");//1、字符串转枚举
        ProjectClusterType.HDFS.equals(hdfs.name());
        System.out.println(ProjectClusterType.HDFS.equals(ProjectClusterType.valueOf("HDFS")));
        System.out.println(ProjectClusterType.HDFS.name());        //2、get名称
        System.out.println(hdfs.getValue());        //3、get value字段
        System.out.println(ApproveInfoType.USER_REGISTRATION.name());
        System.out.println(getALLModulesWithNameAndDesc());

    }

    static List<ModuleNameDTO> getALLModulesWithNameAndDesc() {
        //1、使用的values返回的是数组
        List<ModuleNameDTO> modules = new ArrayList<ModuleNameDTO>() {
            {
                this.addAll(Stream.of(Module.DataPlanning.values()).map(m -> new ModuleNameDTO(m.getName(), m.getDesc())).collect(Collectors.toList()));
                this.addAll(Stream.of(Module.DataIntegration.values()).map(m -> new ModuleNameDTO(m.getName(), m.getDesc())).collect(Collectors.toList()));
                this.addAll(Stream.of(Module.DataDevelopment.values()).map(m -> new ModuleNameDTO(m.getName(), m.getDesc())).collect(Collectors.toList()));
                this.addAll(Stream.of(Module.DataGovernance.values()).map(m -> new ModuleNameDTO(m.getName(), m.getDesc())).collect(Collectors.toList()));
                this.addAll(Stream.of(Module.DataApplication.values()).map(m -> new ModuleNameDTO(m.getName(), m.getDesc())).collect(Collectors.toList()));
                this.addAll(Stream.of(Module.PlatformOps.values()).map(m -> new ModuleNameDTO(m.getName(), m.getDesc())).collect(Collectors.toList()));
                this.addAll(Stream.of(Module.Custom.values()).map(m -> new ModuleNameDTO(m.getName(), m.getDesc())).collect(Collectors.toList()));
                this.addAll(Stream.of(Module.PersonalCenter.values()).map(m -> new ModuleNameDTO(m.getName(), m.getDesc())).collect(Collectors.toList()));
            }
        };
        return modules;
    }


}
