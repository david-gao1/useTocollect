package com.practise.java8.useEnum;

public enum ApproveInfoType {
    DT_HIVE_DB("HIVE数据库"),
    DT_HIVE_TABLE("HIVE表"),
    DT_THIVE_TABLE("TDWHIVE表"),
    DT_THIVE_DB("THIVE数据库"),
    DT_HBASE_TABLE("HABSE表"),
    DT_HBASE_DB("HABSE命名空间"),
    DT_KAFKA_TABLE("KAFKA TOPIC"),
    DT_TABLE_CHOWN("表归属"),
    MW_HIPPO_PRODUCE("HIPPO生产"),
    MW_HIPPO_CONSUME("HIPPO消费"),
    TASK_RUN("任务运行"),
    LINK_ACCESS("链接访问"),
    OCEANUS_RUNAPP("OCEANUS启动任务"),
    HUB_INTERFACE_COMMIT("接入接口变更"),
    HUB_TOPO_COMMIT("接入资源变更"),
    HUB_COMMIT("接入申请"),
    HDFS_FILE_AUTH("HDFS权限申请"),
    TDBANK_BUSINESS_COMMIT("接入业务申请"),
    TDBANK_TUBE_CONSUME("TUBE消费"),
    TESLA_DEPLOY("TESLA服务部署"),
    IDEX_EXPORT("IDEX导出"),
    USER_REGISTRATION("用户注册"),
    PROJECT_REGISTRATION("项目注册"),
    PROJECT_ROLE_APPLY("项目角色申请")
    ;

    private String disPlayName;

    public String getDisPlayName() {
        return disPlayName;
    }

    public void setDisPlayName(String disPlayName) {
        this.disPlayName = disPlayName;
    }

    ApproveInfoType(String disPlayName) {
        this.disPlayName = disPlayName;
    }

    public static ApproveInfoType getType(String name) {
        for (ApproveInfoType type : ApproveInfoType.values()) {
            if (type.name().equals(name)) {
                return type;
            }
        }
        return null;
    }
}
