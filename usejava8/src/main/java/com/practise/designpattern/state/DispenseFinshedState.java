package com.practise.designpattern.state;

/**
 * ��Ʒ�������״̬
 * ˵����������activity �ı�� DispenseOutState�� �齱�����
 * @author Administrator
 *
 */
public class DispenseFinshedState extends State {
    RaffleActivity activity;

    public DispenseFinshedState(RaffleActivity activity) {
        this.activity = activity;
    }
    @Override
    public void deductMoney() {
        System.out.println("��Ʒ�������ˣ����´��ٲμ�");
    }

    @Override
    public boolean raffle() {
        System.out.println("��Ʒ�������ˣ����´��ٲμ�");
        return false;
    }

    @Override
    public void dispensePrize() {
        System.out.println("��Ʒ�������ˣ����´��ٲμ�");
    }
}
