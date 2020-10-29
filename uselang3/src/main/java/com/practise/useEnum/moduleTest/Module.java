package com.practise.useEnum.moduleTest;



import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public interface Module {
    List<Module> modules = new ArrayList<Module>() {
        {
            this.addAll(Arrays.asList(Module.DataPlanning.values()));
            this.addAll(Arrays.asList(Module.DataIntegration.values()));
            this.addAll(Arrays.asList(Module.DataDevelopment.values()));
            this.addAll(Arrays.asList(Module.DataGovernance.values()));
            this.addAll(Arrays.asList(Module.DataApplication.values()));
            this.addAll(Arrays.asList(Module.PlatformOps.values()));
            this.addAll(Arrays.asList(Module.Custom.values()));
            this.addAll(Arrays.asList(Module.PersonalCenter.values()));
        }
    };

    static Module getByName(String name) {
        Module result = null;
        Iterator var2 = modules.iterator();

        while(var2.hasNext()) {
            Module module = (Module)var2.next();
            if (module.getName().equals(name)) {
                result = module;
                break;
            }
        }

        return result;
    }

    static List<String> getAllModuleDescriptions() {
        return (List)modules.stream().map(Module::getDesc).collect(Collectors.toList());
    }

    String getDesc();

    String getName();

    public static enum PersonalCenter implements Module {
        PERSONAL_CENTER("个人中心");

        private String desc;

        private PersonalCenter(String desc) {
            this.desc = desc;
        }

        @Override
        public String getDesc() {
            return this.desc;
        }

        @Override
        public String getName() {
            return this.name();
        }
    }

    public static enum Custom implements Module {
        CUSTOM_MODULE("自定义模块");

        private String desc;

        private Custom(String desc) {
            this.desc = desc;
        }

        @Override
        public String getDesc() {
            return this.desc;
        }

        @Override
        public String getName() {
            return this.name();
        }
    }

    public static enum PlatformOps implements Module {
        OPS_CENTER("运维中心"),
        PLATFORM_MANAGEMENT("平台管理");

        private String desc;

        private PlatformOps(String desc) {
            this.desc = desc;
        }

        @Override
        public String getDesc() {
            return this.desc;
        }

        @Override
        public String getName() {
            return this.name();
        }
    }

    public static enum DataApplication implements Module {
        DATA_VISUALIZATION("数据可视化"),
        MULTIDIMENSIONAL_ANALYSIS("多维分析");

        private String desc;

        private DataApplication(String desc) {
            this.desc = desc;
        }

        @Override
        public String getDesc() {
            return this.desc;
        }

        @Override
        public String getName() {
            return this.name();
        }
    }

    public static enum DataGovernance implements Module {
        DATA_ASSETS("数据资产"),
        DATA_QUALITY("数据质量");

        private String desc;

        private DataGovernance(String desc) {
            this.desc = desc;
        }

        @Override
        public String getDesc() {
            return this.desc;
        }

        @Override
        public String getName() {
            return this.name();
        }
    }

    public static enum DataDevelopment implements Module {
        TASK_SCHEDULING("任务调度"),
        REAL_TIME_COMPUTING("实时计算"),
        DATA_EXPLORATION("数据探索"),
        MACHINE_LEARNING("机器学习");

        private String desc;

        private DataDevelopment(String desc) {
            this.desc = desc;
        }

        @Override
        public String getDesc() {
            return this.desc;
        }

        @Override
        public String getName() {
            return this.name();
        }
    }

    public static enum DataIntegration implements Module {
        REAL_TIME_DATA_ACCESS("实时数据接入"),
        OFFLINE_DATA_INTEGRATION("离线数据集成");

        private String desc;

        private DataIntegration(String desc) {
            this.desc = desc;
        }

        @Override
        public String getDesc() {
            return this.desc;
        }

        @Override
        public String getName() {
            return this.name();
        }
    }

    public static enum DataPlanning implements Module {
        DATA_MANAGEMENT("数据管理");

        private String desc;

        private DataPlanning(String desc) {
            this.desc = desc;
        }

        @Override
        public String getDesc() {
            return this.desc;
        }

        @Override
        public String getName() {
            return this.name();
        }
    }
}

