package cmsc420.utils;

import cmsc420.drawing.CanvasPlus;


/**
 * Graphical representation of spatial map
 **/

public class Canvas {
    public static CanvasPlus instance;

    private Canvas(){}

    public static synchronized CanvasPlus getInstance() {
        if (instance == null) {
            instance = new CanvasPlus();
        }
        return instance;
    }

    public static boolean isEnabled() {
        return instance != null;
    }

    public static void setEnabled() {
        instance = new CanvasPlus("MeeshQuest");
    }

    public static void setDisabled() {
        instance = null;
    }

    public static void dispose() {
        if (instance != null) {
            instance.dispose();
        }
    }
}