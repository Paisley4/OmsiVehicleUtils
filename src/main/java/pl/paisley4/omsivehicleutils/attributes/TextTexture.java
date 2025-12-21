package pl.paisley4.omsivehicleutils;

public class TextTexture {

    private int startsAt;

    private String variable;
    private String fontName;
    private int width, height;
    private boolean fullColor;
    private int colorR, colorG, colorB;

    public TextTexture() {}

    public TextTexture(int startsAt, String variable, String fontName, int width, int height, boolean fullColor, int colorR, int colorG, int colorB) {
        this.startsAt = startsAt;
        this.variable = variable;
        this.fontName = fontName;
        this.width = width;
        this.height = height;
        this.fullColor = fullColor;
        this.colorR = colorR;
        this.colorG = colorG;
        this.colorB = colorB;
    }

    public int getStartsAt() {
        return startsAt;
    }

    public void setStartsAt(int startsAt) {
        this.startsAt = startsAt;
    }

    public String getVariable() {
        return variable;
    }

    public void setVariable(String variable) {
        this.variable = variable;
    }

    public String getFontName() {
        return fontName;
    }

    public void setFontName(String fontName) {
        this.fontName = fontName;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public boolean isFullColor() {
        return fullColor;
    }

    public void setFullColor(boolean fullColor) {
        this.fullColor = fullColor;
    }

    public int getColorR() {
        return colorR;
    }

    public void setColorR(int colorR) {
        this.colorR = colorR;
    }

    public int getColorG() {
        return colorG;
    }

    public void setColorG(int colorG) {
        this.colorG = colorG;
    }

    public int getColorB() {
        return colorB;
    }

    public void setColorB(int colorB) {
        this.colorB = colorB;
    }
}
