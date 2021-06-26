package game;

/**
 * java_study
 */
public class StateTest {
    public static void main(String[] args) {
        int state = 130;
        state |= 8;
        System.out.println(state);


        int[] roundState = {516, 1040, 2112, 4224};
        int[] sessionId = {512,1024,2048,4096};
        int[] nextSessionId = {8192,16384};

        for (int i=0; i<roundState.length; i++) {
            int now = roundState[i];
            int next = getNextSessionId(roundState[i], sessionId, nextSessionId);
            now |= next;

            System.out.println(roundState[i] + "======" + now);
        }




    }

    public static int getNextSessionId(int nowSessionId, int[] sessionId, int[] nextSessionId) {
        int index = 0;
        for (int i=0; i<sessionId.length; i++) {
            if ((nowSessionId & sessionId[i]) > 0) {
                index = i;
            }
        }
        if (index % 2 == 0) {
            return nextSessionId[index / 2];
        } else {
            return nextSessionId[(index - 1) / 2];
        }
    }
}
