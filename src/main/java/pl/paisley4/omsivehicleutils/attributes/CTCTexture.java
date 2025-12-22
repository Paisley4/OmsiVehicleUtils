package pl.paisley4.omsivehicleutils.attributes;

public class CTCTexture {

    private String variable;
    private String texture;

    public CTCTexture() {}

    public CTCTexture(String variable, String texture) {
        this.variable = variable;
        this.texture = texture;
    }

    public String getVariable() {
        return variable;
    }

    public void setVariable(String variable) {
        this.variable = variable;
    }

    public String getTexture() {
        return texture;
    }

    public void setTexture(String texture) {
        this.texture = texture;
    }
}
