package com.practise.java8.useOOP;

/**
 * @Description 纯sql模式下，dataflow的请求模型
 *                                  1、基础的
 *                                  2、dataflow flink 下job的参数
 *                                  3、sql等需要解析的参数
 * @Author roman.gao
 * @Date 2021/6/22 5:47 下午
 */
public class PureSQLDataflowRequest extends BaseModel {

    /**
     * dataflowId
     */
    private Long id;

    /**
     * 账户id
     */
    private Long accountId;

    /**
     * dataflow名称
     */
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
