package com.gao.tabletodata


import org.apache.flink.table.api.{EnvironmentSettings, Table, TableEnvironment}

/**
 * 使用Table Api和sql
 *
 */
object TableAPIAndSQLOpScala {
  def main(args: Array[String]): Unit = {
    //1\创建env
    val streamSetting = EnvironmentSettings.newInstance().useBlinkPlanner().inStreamingMode().build()
    val streamEnv = TableEnvironment.create(streamSetting)

    //2\创建输入表
    /**
     * connector.type：指定connector的类型
     * connector.path：指定文件或者目录地址 会读取文件的内容加载到表里
     * format.type：文件数据格式化类型，现在只支持csv格式
     * 注意：SQL语句如果出现了换行，行的末尾可以添加空格或者\n都可以，最后一行不用添加
     */
    streamEnv.executeSql("" +
      "create table myTable(\n" +
      "id int,\n" +
      "name string\n" +
      ") with (\n" +
      "'connector.type' = 'filesystem',\n" +
      "'connector.path' = 'D:\\data\\source',\n" +
      "'format.type' = 'csv'\n" +
      ")")

    //3.1\使用table api进行数据的查询和过滤操作
    /*    import org.apache.flink.table.api._
        val result: Table = streamEnv.from("myTable")
          .select($"id", $"name")
          .filter($"id" > 1)
        result.execute().print()*/

    //3.2\使用sql执行数据的查询和过滤操作
    val result: Table = streamEnv.sqlQuery("select id,name from myTable where id > 2")
    //result.execute().print()

    //创建输出表
    streamEnv.executeSql("" +
      "create table myNewTable(\n" +
      "id int,\n" +
      "name string\n" +
      ") with (\n" +
      "'connector.type' = 'filesystem',\n" +
      "'connector.path' = 'D:\\data\\source',\n" +
      "'format.type' = 'csv'\n" +
      ")")

    result.executeInsert("myNewTable")//一条数据存到一个文件,还有可能有空数据
  }
}
