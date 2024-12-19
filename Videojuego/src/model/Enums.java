package model;

public class Enums {
    public static enum STATE {
        MENU, CHARSEL1, CHARSEL2, CHOOSE, GAME, GANADOR
    }

    public static enum CHOICEP1 {
        GIGANTE, HADA, NOTHING
    }

    public static enum CHOICEP2 {
        GIGANTE, HADA, NOTHING2
    }

    private static STATE currentState = STATE.MENU;

    public static STATE getState() {
        return currentState;
    }

    public static void setState(STATE newState) {
        currentState = newState;
    }
}