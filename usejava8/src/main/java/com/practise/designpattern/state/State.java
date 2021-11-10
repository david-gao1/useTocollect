package com.practise.designpattern.state;

/**
 * 状态抽象类
 * <p>
 * 有扣除积分、抽奖和发放奖品的过程
 */
public abstract class State {
    /**
     * 扣除积分：不同的状态，对应是否能扣除积分
     * 可抽奖状态：因为已经扣除积分了，所以不能再扣除
     */
    public abstract void deductMoney();
    // 是否抽中奖品
    public abstract boolean raffle();
    // 发放奖品
    public abstract void dispensePrize();
}
