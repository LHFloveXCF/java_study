package com.mt.test;

public enum PlayerLimitEnum {
    VIP(1, "vip等级限制"),
    MONTH_CARD(2, "月卡限制"),
    PRIVILEGE_CARD(3, "尊卡限制"),
    ;

    int state;
    String desc;

    public static PlayerLimitEnum getLimitEnum(int state) {
        for (PlayerLimitEnum limitEnum : PlayerLimitEnum.values()) {
            if (limitEnum.state == state) {
                return limitEnum;
            }
        }
        return null;
    }


    PlayerLimitEnum(int state, String desc) {
        this.state = state;
        this.desc = desc;
    }
}
