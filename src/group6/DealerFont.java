package group6;

import java.awt.*;

public class DealerFont {

    static String FONT_NAME = "Helvetica";
    static int TITLE_FONT_SIZE = 30;
    static int HEADER_FONT_SIZE = 20;
    static int SUB_TITLE_FONT_SIZE = 18;
    static int NORMAL_FONT_SIZE = 14;
    static int DESCRIPTION_FONT_SIZE = 12;

    static Font getHeaderFont() {
        return new Font(FONT_NAME, Font.PLAIN, HEADER_FONT_SIZE);
    }

    static Font getTitleFont() {
        return new Font(FONT_NAME, Font.BOLD, TITLE_FONT_SIZE);
    }

    static Font getSubTitleFont() {
        return new Font(FONT_NAME, Font.PLAIN, SUB_TITLE_FONT_SIZE);
    }

    static Font getDescriptionFont() {
        return new Font(FONT_NAME, Font.PLAIN, DESCRIPTION_FONT_SIZE);
    }

    static Font getNormalFont() {
        return new Font(FONT_NAME, Font.PLAIN, NORMAL_FONT_SIZE);
    }
}
