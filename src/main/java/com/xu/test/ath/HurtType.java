package com.xu.test.ath;

public interface HurtType {
	/** miss */
	byte HURT_MISS = 1;
	/** 暴击  */
	byte HURT_STRONG = 2;
	/** 防护  */
	byte HURT_DEFEND = 3;
	/** 威慑  */
	byte HURT_WEISHE = 4;
	/** 残废  */
	byte HURT_CANFEI = 5;
	/** 腐蚀  */
	byte HURT_FUSHI = 6;
	/** 致命  */
	byte HURT_ZHIMIN = 7;
	/** 疾风斩  */
	byte HURT_JFZ = 8;
	/**神圣攻击*/
	byte HURT_HOLYATT=9;
	/**天罡怒斩*/
	byte HURT_TianGangKilled=10;
	/**重伤*/
	byte SERIOUS_INJURY=11;
	/**脆弱*/
	byte FRAGILE=12;
	/**免伤增加*/
	byte DECHURT_ADD=13;
	/**格挡*/
	byte BLOCK=14;
	/**战灵被动*/
	byte VALHALLA_PASSIVE=15;
	/**毁灭*/
	byte RUIN=16;
	/**不灭*/
	byte ATHANASIA=17;
	/**双倍不灭*/
	byte DOUBLE_ATHANASIA=18;
	/**伤害抵抗*/
	byte HURT_RESIST=19;
	/**玄武盾*/
	byte XUNWUDUN=20;
	/**雷霆万钧增伤*/
	byte THUNDER_ADDHURT=21;
	/**传奇一击*/
	byte GODEQUIP_LENGED = 22;
	/**护盾一击*/
	byte GODEQUIP_SHIELD = 23;
	/**震慑一击*/
	byte GODEQUIP_FRIGHTEN = 24;
	/**无敌*/
	byte INVINCIBLE = 25;
	/****神魔降临***/
	byte GODEVIL = 28;
	/****神剑-吸血***/
	byte GOD = 29;
	/****魔甲***/
	byte EVIL = 30;
	/****度灵***/
	byte DULIN = 31;
	/****大梵天***/
	byte DA_FANTIAN = 32;
	/**----------------新的东西----------------------*/
	/****溅射主***/
	byte JIANSHE_MAIN = 1;
	/****火***/
	byte HUO = 2;
	/****土***/
	byte TU = 3;
	/****金***/
	byte JIN = 4;
	/****水***/
	byte SHUI = 5;
	/****木***/
	byte MU = 6;
	/**雷晶一击*/
	byte CRYSTAL_ONE_HIT=7;
	/** 涅槃一击-飘字用*/
	byte PHOENIX_HIT = 8;
	/**魂装减伤*/
	byte SOUL_HURT_INCR = 9;
}
