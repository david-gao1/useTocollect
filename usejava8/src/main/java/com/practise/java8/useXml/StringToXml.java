package com.practise.java8.useXml;

import org.w3c.dom.Document;
import org.xml.sax.InputSource;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.ByteArrayOutputStream;
import java.io.StringReader;

public class StringToXml {
    public static void main(String[] args) throws Exception {
        //字符转xml
        String xmlStr="<?xml version=\"1.0\" encoding=\"UTF-8\"?><workflows><workflow><workflowId>38969b33-3dfe-44a2-be4d-f3da2a59c3e0</workflowId><workflowName>测试用例-误删</workflowName><projectId>1</projectId><projectIdent>g_teg_test</projectIdent><projectName>g_teg_test</projectName><ownerId>4</ownerId><owner>jakowen</owner><createTime>2019-10-14 20:10:27</createTime><modifyTime>2019-10-14 20:10:27</modifyTime><tasks><task><taskId>11f53df8-8569-42f7-8daa-36e68ff2816e</taskId><taskName>test_api</taskName><taskTypeId>81</taskTypeId><taskTypeName>python sql thive</taskTypeName><selfDepend>2</selfDepend><taskStatus>5</taskStatus><webCanvas>left: 696.5px; top: 189.5px;</webCanvas><category>lhotse</category><ownerId>1</ownerId><owner>admin</owner><createTime>2020-5-26 16:04:19</createTime><modifyTime>2020-5-26 16:05:53</modifyTime><dataStartTime>2020-5-26 00:00:00</dataStartTime><endTime>2022-5-26 08:00:00</endTime><startDay>0</startDay><startMin>0</startMin><startHour>0</startHour><cycle>H</cycle><properties>{\"task.main.timeout\":\"480\",\"retriable\":\"1\",\"endDate\":\"2022-05-26\",\"gaia_id\":\"1386\",\"file_name\":\"/ftp/admin/all/test.zip\",\"brokerIp\":\"any\",\"cycleNum\":\"1\",\"special_para\":\"set hive.exec.parallel = true;set hive.execute.engine=spark;set hive.multi.join.use.hive=false;\",\"tryLimit\":\"5\",\"source_server\":\"hive_server_g_teg_test_1\",\"params\":\"\"}</properties></task><task><taskId>12ef0017-5d5d-41ae-a39e-b199e76d82b2</taskId><taskName>test_codm_min_测试</taskName><taskTypeId>81</taskTypeId><taskTypeName>python sql thive</taskTypeName><selfDepend>2</selfDepend><taskStatus>5</taskStatus><webCanvas>left: 20px; top: 328px;</webCanvas><category>lhotse</category><ownerId>70</ownerId><owner>kaiboli</owner><createTime>2019-11-07 13:18:41</createTime><modifyTime>2020-5-21 20:29:58</modifyTime><dataStartTime>2019-11-07 00:00:00</dataStartTime><endTime>2021-11-07 00:00:00</endTime><startDay>0</startDay><startMin>0</startMin><startHour>0</startHour><cycle>I</cycle><properties>{\"task.main.timeout\":\"10\",\"retriable\":\"1\",\"endDate\":\"2021-11-07\",\"gaia_id\":\"1386\",\"file_name\":\"/ftp/kaiboli/all/test2.py\",\"brokerIp\":\"any\",\"cycleNum\":\"10\",\"special_para\":\"set hive.exec.parallel = true;set hive.execute.engine=spark;set hive.multi.join.use.hive=false;\",\"tryLimit\":\"1\",\"source_server\":\"hive_server_g_teg_test_1\",\"params\":\"\"}</properties><alarm><alarmStatus>true</alarmStatus><alarmType>overtime,failure</alarmType><alarmWay>Email,SMS,Tel</alarmWay><alarmRecipientId>70</alarmRecipientId><alarmRecipient>kaiboli</alarmRecipient><properties><property><name>hours</name><value>0</value></property><property><name>minutes</name><value>2</value></property></properties></alarm></task><task><taskId>25940a8a-e6d8-44b6-a401-7c6ac716ab5a</taskId><taskName>test_codm_hour_测试</taskName><taskTypeId>81</taskTypeId><taskTypeName>python sql thive</taskTypeName><selfDepend>2</selfDepend><taskStatus>3</taskStatus><webCanvas>left: -37px; top: 151px;</webCanvas><category>lhotse</category><ownerId>70</ownerId><owner>kaiboli</owner><createTime>2019-11-07 13:17:41</createTime><modifyTime>2019-11-07 13:18:29</modifyTime><dataStartTime>2019-11-07 00:00:00</dataStartTime><endTime>2021-11-07 00:00:00</endTime><startDay>0</startDay><startMin>0</startMin><startHour>0</startHour><cycle>H</cycle><properties>{\"task.main.timeout\":\"10\",\"retriable\":\"1\",\"endDate\":\"2021-11-07\",\"gaia_id\":\"1386\",\"file_name\":\"/ftp/kaiboli/all/test2.py\",\"brokerIp\":\"any\",\"cycleNum\":\"1\",\"special_para\":\"set hive.exec.parallel = true;set hive.execute.engine=spark;set hive.multi.join.use.hive=false;\",\"tryLimit\":\"1\",\"source_server\":\"hive_server_g_teg_test_1\",\"params\":\"\"}</properties><alarm><alarmStatus>true</alarmStatus><alarmType>overtime,failure</alarmType><alarmWay>Email,SMS,Tel</alarmWay><alarmRecipientId>70</alarmRecipientId><alarmRecipient>kaiboli</alarmRecipient><properties><property><name>hours</name><value>0</value></property><property><name>minutes</name><value>2</value></property></properties></alarm></task><task><taskId>2c23e921-b0e8-4e6f-b8a1-b86efcfd1a6c</taskId><taskName>新建任务</taskName><taskTypeId>70</taskTypeId><taskTypeName>HIVE SQL脚本</taskTypeName><selfDepend>0</selfDepend><taskStatus>0</taskStatus><webCanvas>left:966px;top:221px</webCanvas><category>lhotse</category><ownerId>1</ownerId><owner>admin</owner><createTime>2020-3-25 21:30:51</createTime><modifyTime>2020-3-25 21:30:51</modifyTime><startDay>0</startDay><startMin>0</startMin><startHour>0</startHour><properties>{\"retriable\":\"1\",\"task_priority\":\"6\",\"sql.file.name\":null,\"endDate\":\"2022-03-25\",\"brokerIp\":\"any\",\"cycleNum\":\"1\",\"tryLimit\":\"5\",\"source_server\":null}</properties></task><task><taskId>34045032-dd78-46df-a22b-0dafe81c008b</taskId><taskName>jako_test_py_2</taskName><taskTypeId>81</taskTypeId><taskTypeName>python sql thive</taskTypeName><selfDepend>3</selfDepend><taskStatus>2</taskStatus><webCanvas>left: 255px; top: 95px;</webCanvas><category>lhotse</category><ownerId>4;70</ownerId><owner>jakowen;kaiboli</owner><createTime>2019-10-14 20:11:01</createTime><modifyTime>2020-8-24 21:15:24</modifyTime><dataStartTime>2019-10-14 00:00:00</dataStartTime><endTime>2021-10-14 00:00:00</endTime><startDay>0</startDay><startMin>0</startMin><startHour>0</startHour><cycle>H</cycle><properties>{\"task.main.timeout\":\"480\",\"retriable\":\"1\",\"endDate\":\"2021-10-14\",\"gaia_id\":\"1386\",\"file_name\":\"/ftp/jakowen/all/test11.py;/ftp/jakowen/all/create.py;/ftp/jakowen/all/insert.py;/ftp/jakowen/all/test11.py\",\"brokerIp\":\"any\",\"cycleNum\":\"1\",\"special_para\":\"set hive.exec.parallel = true;set hive.execute.engine=spark;set hive.multi.join.use.hive=false;\",\"tryLimit\":\"3\",\"source_server\":\"thive\",\"params\":\"${YYYYMMDDHH}\"}</properties><alarm><alarmStatus>true</alarmStatus><alarmType>overtime,failure</alarmType><alarmWay>Email,SMS</alarmWay><alarmRecipientId>4;70</alarmRecipientId><alarmRecipient>jakowen;kaiboli</alarmRecipient><properties><property><name>hours</name><value>0</value></property><property><name>minutes</name><value>20</value></property></properties></alarm></task><task><taskId>58f2d304-9744-4607-b052-f21a7a49c0e9</taskId><taskName>新建任务</taskName><taskTypeId>86</taskTypeId><taskTypeName>thive to hdfs</taskTypeName><selfDepend>0</selfDepend><taskStatus>0</taskStatus><webCanvas>left:1012.5px;top:592.5px</webCanvas><category>lhotse</category><ownerId>1</ownerId><owner>admin</owner><createTime>2020-3-25 21:31:24</createTime><modifyTime>2020-3-25 21:31:24</modifyTime><startDay>0</startDay><startMin>0</startMin><startHour>0</startHour><properties>{\"filterSQL\":null,\"destFilePath\":null,\"destCheckFileName\":null,\"databaseName\":null,\"endDate\":\"2022-03-25\",\"tryLimit\":\"5\",\"destFileDelimiter\":\"9\",\"destCheckFilePath\":null,\"task.main.timeout\":\"480\",\"retriable\":\"1\",\"gaia_id\":\"1386\",\"brokerIp\":\"any\",\"cycleNum\":\"1\",\"special_para\":\"set hive.exec.parallel = true;\",\"distcp_special_para\":null,\"source_server\":null,\"target_server\":null}</properties></task><task><taskId>5d3f35a8-0db2-4a1a-8d43-3bef8c501d9b</taskId><taskName>jako_test_py_1</taskName><taskTypeId>81</taskTypeId><taskTypeName>python sql thive</taskTypeName><selfDepend>3</selfDepend><taskStatus>2</taskStatus><webCanvas>left:230px;top:-75px</webCanvas><category>lhotse</category><ownerId>4</ownerId><owner>jakowen</owner><createTime>2019-10-14 20:10:49</createTime><modifyTime>2020-2-15 12:09:44</modifyTime><dataStartTime>2019-10-14 00:00:00</dataStartTime><endTime>2021-10-14 00:00:00</endTime><startDay>0</startDay><startMin>1</startMin><startHour>0</startHour><cycle>H</cycle><properties>{\"task.main.timeout\":\"30\",\"retriable\":\"1\",\"endDate\":\"2021-10-14\",\"gaia_id\":\"1386\",\"file_name\":\"/ftp/jakowen/all/test11.py;/ftp/jakowen/all/create.py;/ftp/jakowen/all/insert.py;/ftp/jakowen/all/test11.py\",\"brokerIp\":\"any\",\"cycleNum\":\"1\",\"special_para\":\"set hive.exec.parallel = true;set hive.execute.engine=spark;set hive.multi.join.use.hive=false;\",\"tryLimit\":\"3\",\"source_server\":\"thive\",\"params\":\"${YYYYMMDDHH}\"}</properties><alarm><alarmStatus>true</alarmStatus><alarmType>overtime,failure</alarmType><alarmWay>Email,SMS</alarmWay><alarmRecipientId>4</alarmRecipientId><alarmRecipient>jakowen</alarmRecipient><properties><property><name>hours</name><value>0</value></property><property><name>minutes</name><value>20</value></property></properties></alarm></task><task><taskId>751fe736-1598-4cbf-ba80-ff111277149d</taskId><taskName>test_api_3</taskName><taskTypeId>81</taskTypeId><taskTypeName>python sql thive</taskTypeName><selfDepend>2</selfDepend><taskStatus>5</taskStatus><webCanvas>left: 674px; top: 95px;</webCanvas><category>lhotse</category><ownerId>1</ownerId><owner>admin</owner><createTime>2020-5-26 16:12:04</createTime><modifyTime>2020-5-26 16:13:24</modifyTime><dataStartTime>2020-5-25 00:00:00</dataStartTime><endTime>2022-5-26 08:00:00</endTime><startDay>0</startDay><startMin>0</startMin><startHour>0</startHour><cycle>O</cycle><properties>{\"task.main.timeout\":\"480\",\"retriable\":\"1\",\"endDate\":\"2022-05-26\",\"gaia_id\":\"1386\",\"file_name\":\"/ftp/admin/all/test.zip\",\"brokerIp\":\"any\",\"cycleNum\":\"1\",\"special_para\":\"set hive.exec.parallel = true;set hive.execute.engine=spark;set hive.multi.join.use.hive=false;\",\"tryLimit\":\"5\",\"source_server\":\"hive_server_g_teg_test_1\",\"params\":\"\"}</properties></task><task><taskId>7fe3c111-c14b-46f6-809c-d8246a998781</taskId><taskName>fasfsadfad</taskName><taskTypeId>81</taskTypeId><taskTypeName>python sql thive</taskTypeName><selfDepend>2</selfDepend><taskStatus>1</taskStatus><webCanvas>left: 611px; top: 608px;</webCanvas><category>lhotse</category><ownerId>1</ownerId><owner>admin</owner><createTime>2020-3-25 21:31:36</createTime><modifyTime>2020-3-25 21:33:12</modifyTime><dataStartTime>2020-3-25 00:00:00</dataStartTime><endTime>2022-3-25 08:00:00</endTime><startDay>0</startDay><startMin>0</startMin><startHour>0</startHour><cycle>O</cycle><properties>{\"task.main.timeout\":\"480\",\"retriable\":\"1\",\"endDate\":\"2022-03-25\",\"gaia_id\":\"1386\",\"file_name\":\"/ftp/admin/all/test.zip;/ftp/admin/all/test-1000.zip\",\"brokerIp\":\"any\",\"cycleNum\":\"1\",\"special_para\":\"set hive.exec.parallel = true;set hive.execute.engine=spark;set hive.multi.join.use.hive=false;\",\"tryLimit\":\"5\",\"source_server\":\"thive\",\"params\":\"fdas\"}</properties></task><task><taskId>b083dafe-a4d9-434c-879b-08eca2886ca8</taskId><taskName>testfsdfdss</taskName><taskTypeId>38</taskTypeId><taskTypeName>SHELL脚本</taskTypeName><selfDepend>2</selfDepend><taskStatus>1</taskStatus><webCanvas>left: 953px; top: 29px;</webCanvas><category>lhotse</category><ownerId>1</ownerId><owner>admin</owner><createTime>2020-3-25 21:28:26</createTime><modifyTime>2020-3-25 21:29:58</modifyTime><dataStartTime>2020-3-25 00:00:00</dataStartTime><endTime>2022-3-25 08:00:00</endTime><startDay>0</startDay><startMin>0</startMin><startHour>0</startHour><cycle>O</cycle><properties>{\"retriable\":\"1\",\"task_priority\":\"6\",\"endDate\":\"2022-03-25\",\"brokerIp\":\"any\",\"cycleNum\":\"1\",\"ftp.file.name\":\"/ftp/admin/all/test-1000.zip\",\"tryLimit\":\"5\",\"shell.cmd\":\"test.sh\",\"shell.args\":\"\"}</properties></task><task><taskId>c1efa602-442d-4c1e-a852-94158529d3e0</taskId><taskName>test_codm_hour_测试_11_14</taskName><taskTypeId>81</taskTypeId><taskTypeName>python sql thive</taskTypeName><selfDepend>2</selfDepend><taskStatus>5</taskStatus><webCanvas>left: 77px; top: 465px;</webCanvas><category>lhotse</category><ownerId>70</ownerId><owner>kaiboli</owner><createTime>2019-11-14 14:44:39</createTime><modifyTime>2019-11-14 14:45:29</modifyTime><dataStartTime>2019-11-14 00:00:00</dataStartTime><endTime>2021-11-14 00:00:00</endTime><startDay>0</startDay><startMin>0</startMin><startHour>0</startHour><cycle>H</cycle><properties>{\"task.main.timeout\":\"480\",\"retriable\":\"1\",\"endDate\":\"2021-11-14\",\"gaia_id\":\"1386\",\"file_name\":\"/ftp/kaiboli/all/test2.py\",\"brokerIp\":\"any\",\"cycleNum\":\"1\",\"special_para\":\"set hive.exec.parallel = true;set hive.execute.engine=spark;set hive.multi.join.use.hive=false;\",\"tryLimit\":\"1\",\"source_server\":\"hive_server_g_teg_test_1\",\"params\":\"\"}</properties><alarm><alarmStatus>true</alarmStatus><alarmType>overtime,failure</alarmType><alarmWay>Email,SMS,Tel</alarmWay><alarmRecipientId>70</alarmRecipientId><alarmRecipient>kaiboli</alarmRecipient><properties><property><name>minutes</name><value>2</value></property><property><name>hours</name><value>0</value></property></properties></alarm></task><task><taskId>d9db69fd-0dc3-4090-bcd5-66dedfde2db8</taskId><taskName>test_job_1</taskName><taskTypeId>81</taskTypeId><taskTypeName>python sql thive</taskTypeName><selfDepend>2</selfDepend><taskStatus>5</taskStatus><webCanvas>left:1106px;top:291px</webCanvas><category>lhotse</category><ownerId>1</ownerId><owner>admin</owner><createTime>2020-3-09 14:47:18</createTime><modifyTime>2020-3-25 22:17:36</modifyTime><dataStartTime>2020-3-08 00:00:00</dataStartTime><endTime>2022-3-09 08:00:00</endTime><startDay>0</startDay><startMin>0</startMin><startHour>0</startHour><cycle>D</cycle><properties>{\"task.main.timeout\":\"480\",\"retriable\":\"1\",\"endDate\":\"2022-03-09\",\"gaia_id\":\"1386\",\"file_name\":\"/ftp/admin/all/test.zip;/ftp/admin/all/create.py;/ftp/admin/all/test.zip.20191229164630\",\"brokerIp\":\"any\",\"cycleNum\":\"1\",\"special_para\":\"set hive.exec.parallel = true;set hive.execute.engine=spark;set hive.multi.join.use.hive=false;\",\"tryLimit\":\"5\",\"source_server\":\"hive_server_g_teg_test_1\",\"params\":\"\"}</properties></task><task><taskId>f4778e84-b242-4683-8412-d93ef1105b3b</taskId><taskName>test_codm_hour_测试_11_19</taskName><taskTypeId>81</taskTypeId><taskTypeName>python sql thive</taskTypeName><selfDepend>2</selfDepend><taskStatus>3</taskStatus><webCanvas>left: -13px; top: 646px;</webCanvas><category>lhotse</category><ownerId>70</ownerId><owner>kaiboli</owner><createTime>2019-11-19 15:52:34</createTime><modifyTime>2019-11-19 15:53:22</modifyTime><dataStartTime>2019-11-19 00:00:00</dataStartTime><endTime>2021-11-19 00:00:00</endTime><startDay>0</startDay><startMin>0</startMin><startHour>0</startHour><cycle>H</cycle><properties>{\"task.main.timeout\":\"480\",\"retriable\":\"1\",\"endDate\":\"2021-11-19\",\"gaia_id\":\"1386\",\"file_name\":\"/ftp/kaiboli/all/test2.py\",\"brokerIp\":\"any\",\"cycleNum\":\"1\",\"special_para\":\"set hive.exec.parallel = true;set hive.execute.engine=spark;set hive.multi.join.use.hive=false;\",\"tryLimit\":\"1\",\"source_server\":\"thive\",\"params\":\"\"}</properties><alarm><alarmStatus>true</alarmStatus><alarmType>overtime,failure</alarmType><alarmWay>Email,SMS,Tel</alarmWay><alarmRecipientId>70</alarmRecipientId><alarmRecipient>kaiboli</alarmRecipient><properties><property><name>hours</name><value>0</value></property><property><name>minutes</name><value>2</value></property></properties></alarm></task><task><taskId>f4e46708-d53e-47e0-9263-4847bae1747a</taskId><taskName>test_api_2</taskName><taskTypeId>81</taskTypeId><taskTypeName>python sql thive</taskTypeName><selfDepend>2</selfDepend><taskStatus>5</taskStatus><webCanvas>left:418px;top:200px</webCanvas><category>lhotse</category><ownerId>1</ownerId><owner>admin</owner><createTime>2020-5-26 16:08:35</createTime><modifyTime>2020-5-26 16:09:07</modifyTime><dataStartTime>2020-5-26 00:00:00</dataStartTime><endTime>2022-5-26 08:00:00</endTime><startDay>0</startDay><startMin>0</startMin><startHour>0</startHour><cycle>O</cycle><properties>{\"task.main.timeout\":\"480\",\"retriable\":\"1\",\"endDate\":\"2022-05-26\",\"gaia_id\":\"1386\",\"file_name\":\"/ftp/admin/all/test.zip\",\"brokerIp\":\"any\",\"cycleNum\":\"1\",\"special_para\":\"set hive.exec.parallel = true;set hive.execute.engine=spark;set hive.multi.join.use.hive=false;\",\"tryLimit\":\"5\",\"source_server\":\"hive_server_g_teg_test_1\",\"params\":\"\"}</properties></task></tasks><edges><edge><bridgeType>lhotse_lhotse</bridgeType><originId>5d3f35a8-0db2-4a1a-8d43-3bef8c501d9b</originId><targetId>34045032-dd78-46df-a22b-0dafe81c008b</targetId></edge></edges></workflow></workflows>";
        final StringReader stringReader = new StringReader(xmlStr);
        final InputSource inputSource = new InputSource(stringReader);
        final DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        final DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
        final Document parse = documentBuilder.parse(inputSource);
        final String xmlFileLength = getXmlFileString(parse);
        System.out.println(xmlFileLength);
        System.out.println(xmlFileLength.length());


    }

    private static String getXmlFileLength(Document doc) throws Exception {
        TransformerFactory formerFactory = TransformerFactory.newInstance();
        Transformer transformer = formerFactory.newTransformer();
        transformer.setOutputProperty(OutputKeys.INDENT, "YES");
        transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");


        transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");

        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        transformer.transform(new DOMSource(doc), new StreamResult(bos));
        String docString = bos.toString();
        return docString;
    }

    private static String getXmlFileString(Document doc) {
        String docString = null;
        try (ByteArrayOutputStream bos = new ByteArrayOutputStream()) {
            TransformerFactory formerFactory = TransformerFactory.newInstance();
            Transformer transformer = formerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "YES");
            transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
            transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
            transformer.transform(new DOMSource(doc), new StreamResult(bos));
            docString = bos.toString();
            //LOG.info("[getXmlFileLength]:docString'length={}", docString.length());
        } catch (Exception e) {
            //LOG.error("[getXmlFileLength]", e);
            //throw new DeployPortalException("计算工作流文件大小失败");
        }
        return docString;
    }
}