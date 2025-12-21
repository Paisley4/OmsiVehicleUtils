package pl.paisley4.omsivehicleutils;

public class TextTextureEnhanced extends TextTexture {

    private int orientation;
    private int grid;

    public TextTextureEnhanced() {}

    public TextTextureEnhanced(int startsAt, String variable, String fontName, int width, int height, boolean fullColor, int colorR, int colorG, int colorB, int orientation, int grid) {
        super(startsAt, variable, fontName, width, height, fullColor, colorR, colorG, colorB);
        this.orientation = orientation;
        this.grid = grid;
    }

    public int getOrientation() {
        return orientation;
    }

    public void setOrientation(int orientation) {
        this.orientation = orientation;
    }

    public int getGrid() {
        return grid;
    }

    public void setGrid(int grid) {
        this.grid = grid;
    }
}
