package com.practise.designpattern.state;

/**
 * ״̬������
 * <p>
 * �п۳����֡��齱�ͷ��Ž�Ʒ�Ĺ���
 */
public abstract class State {
    /**
     * �۳����֣���ͬ��״̬����Ӧ�Ƿ��ܿ۳�����
     * �ɳ齱״̬����Ϊ�Ѿ��۳������ˣ����Բ����ٿ۳�
     */
    public abstract void deductMoney();
    // �Ƿ���н�Ʒ
    public abstract boolean raffle();
    // ���Ž�Ʒ
    public abstract void dispensePrize();
}
