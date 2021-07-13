package com.mt.t_07;

import java.util.HashMap;
import java.util.Map;

/**
 * java_study
 */
public class TestPlay {
    public static void main(String[] args) {
        Map<IPlay, IPlay> map = new HashMap<>();
        FootBall footBall = new FootBall();
        Ball ball = new Ball();
        BasketBall basketBall = new BasketBall();
        map.put(footBall, footBall);
        map.put(ball, ball);
        map.put(basketBall, basketBall);

        try {
            for (IPlay play : map.values()) {
                play.play();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
