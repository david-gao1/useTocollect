package com.practise.useEnum;



public enum ProjectClusterType {
    YARN(0),
    HDFS(1);

    private final int value;

    private ProjectClusterType(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }

    public static ProjectClusterType findByValue(int value) {
        switch(value) {
            case 0:
                return YARN;
            case 1:
                return HDFS;
            default:
                return null;
        }
    }
}