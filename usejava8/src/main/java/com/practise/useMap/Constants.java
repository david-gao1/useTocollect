package com.practise.useMap;

public class Constants {
    public static final String CALL_RESULT_OK = "0";
    public static final String CALL_RESULT_REQUEST_FAILED = "500";
    public static final String CALL_RESULT_FAIL = "1";
    public static final String CALL_RESULT_NOTLOGIN = "403";
    public static final String CALL_RESULT_ERROR = "2";
    public static final String CALL_MESSAGE_OK = "ok";
    public static final String CALL_MESSAGE_SUCCESS = "success";


    public static final String MESSAGE_OPERATE_OK = "ok";
    public static final String MESSAGE_OPERATE_FAIL = "fail";
    public static final String MESSAGE_NAMEEXISTS = "name exits";
    public static final String MESSAGE_ADDUSER_OK = "ok";
    public static final String MESSAGE_ADDUSER_SUCCESS = "success";


    public static final int ADMIN_USER_ID = 1;
    public static final String ADMIN_GROUP_ID = "1";

    public static final String MESSAGE_OLDPWD_ERROR = "old pwd error";
    public static final String MESSAGE_NOT_LOGIN = "not login";
    public static final String MESSAGE_ADDUSER_NAMEEXISTS = "name exits";
    public static final String MESSAGE_GROUPNOTEXISTS = "group not Exits";

    public static final String CLUSTER_TYPE_IDC = "IDC";
    public static final String CLUSTER_TYPE_TCLOUD = "TCLOUD";

    // relation type
    public static final String RELATIONTYPE_U_G = "UG";  // user group
    public static final String RELATIONTYPE_G_F = "GF";  // group function
    public static final String RELATIONTYPE_P_M = "PM"; // project manager
    public static final String RELATIONTYPE_P_L = "PL"; // project leaguer
    public static final String RELATIONTYPE_P_G = "PG"; // project group
    public static final String RELATIONTYPE_F_R = "FR"; // role founctions
    public static final String RELATIONTYPE_U_R = "UR"; // user role
    public static final String RELATIONTYPE_G_R = "GR"; // group role
    public static final String RELATIONTYPE_P_L_R = "PLR"; // project leaguer role
    public static final String RELATIONTYPE_P_G_R = "PGR"; // project leaguer role
    public static final String RELATIONTYPE_P_A = "PA"; // project affiche
    public static final String RELATIONTYPE_U_AP = "UA"; // user aprove
    public static final String RELATIONTYPE_P_QU = "PQU"; // project queue
    public static final String RELATIONTYPE_H_U = "HU"; // hub user
    public static final String RELATIONTYPE_H_P = "HP"; // hub project
    public static final String RELATIONTYPE_HB_HI = "HBHI"; // hubbase hubinterface
    public static final String RELATIONTYPE_HB_HI_BAK = "HBHI_BAK"; // hubbase hubinterface 临时关系
    public static final String RELATIONTYPE_HB_RP = "HBHP"; // hubbase hippo
    public static final String RELATIONTYPE_HB_RT = "HBHT"; // hubbase topology
    public static final String RELATIONTYPE_DB_ORG = "DO"; // db org
    public static final String RELATIONTYPE_B_D = "BD"; // business database
    public static final String RELATIONTYPE_B_D_T = "BDT"; // business database table
    public static final String RELATIONTYPE_USER_DEFAULT_PROJECT = "UDP";

    public static final String UI_SYSTEMGUID = "systemGiud";

    public static final String ROLE_STATUS_1 = "1"; // 预设角色
    public static final String ROLE_STATUS_2 = "2"; // 自定义角色

    public static final String PORTAL_SLAVE_ON = "true";

    public static final String LDAP_OPT_ADD = "add";
    public static final String LDAP_OPT_DEL = "del";

    public static final String AFFICHE_STATUS_ON = "ON";
    public static final String AFFICHE_STATUS_OFF = "OFF";
    public static final String AFFICHE_RECEIVERTYPE_ALL = "ALL";
    public static final String AFFICHE_RECEIVERTYPE_PRO = "PRO";

    public static final String MESSAGE_STATUS_NEW = "new";
    public static final String MESSAGE_STATUS_READ = "read";


    public static final String APPROVE_DETAIL_RESOURCE = "resource";
    public static final String APPROVE_DETAIL_HIVE = "hive";
    public static final String APPROVE_DETAIL_DT = "dt";
    public static final String APPROVE_DETAIL_MW = "middleware";
    public static final String APPROVE_DETAIL_HIPPO = "HIPPO";
    public static final String APPROVE_DETAIL_TASKERROR = "taskerror";
    public static final String APPROVE_DETAIL_TASKTIMEOUT = "tasktimeout";
    public static final int REMOTE_APPROVE_PASS = 1;
    public static final int REMOTE_APPROVE_REJECT = 0;

    public static final String PORTAL_THRIFT_PORT = "12345";
    public static final String PORTAL_GAIA_THRIFT_PORT="12346";

    public static final String QUEUE_METRIC_ALL_QUEUES = "*";
    public static final String QUEUE_METRIC_NAME_VCORE = "vcore";
    public static final String QUEUE_METRIC_NAME_MEMORY = "memory";
    public static final String QUEUE_METRIC_NAME_CAPACITY = "CapacityUsed";
    public static final String QUEUE_METRIC_NAME_USED_SPACE = "usedSpace";

    public static final int RESOURCE_DEFAULT_SAMPLING_COUNT = 360;
    public static final int RESOURCE_DEFAULT_SAMPLING_INTERVAL = 240;
    public static final int RESOURCE_RANKING_DEFAULT_SIZE = 5;

    public static final String ENTITY_YN_Y = "y";
    public static final String ENTITY_YN_N = "n";

    public static final String SEND_NOTICE_PENDING = "0";
    public static final String SEND_NOTICE_FINISH = "1";

    public static final String DIFFERS_STRING = "differs from";
}
