package pl.paisley4.omsivehicleutils.attributes;

import pl.paisley4.omsivehicleutils.objects.Pair;
import pl.paisley4.omsivehicleutils.objects.TripleStruct;

public class Matl {

    private String material;
    private Pair<String, Double> envMap;
    private TripleStruct<String, Integer, String> change;
    private Pair<String, String> freetex;
    private String lightMap, nightMap;
    private int textTexture;
    private int alpha;
    private boolean noZCheck, noZWrite;

    public Matl() {}

    public Matl(String material, Pair<String, Double> envMap, TripleStruct<String, Integer, String> change, Pair<String, String> freetex, String lightMap, String nightMap, int textTexture, int alpha, boolean noZCheck, boolean noZWrite) {
        this.material = material;
        this.envMap = envMap;
        this.change = change;
        this.freetex = freetex;
        this.lightMap = lightMap;
        this.nightMap = nightMap;
        this.textTexture = textTexture;
        this.alpha = alpha;
        this.noZCheck = noZCheck;
        this.noZWrite = noZWrite;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public Pair<String, Double> getEnvMap() {
        return envMap;
    }

    public void setEnvMap(Pair<String, Double> envMap) {
        this.envMap = envMap;
    }

    public TripleStruct<String, Integer, String> getChange() {
        return change;
    }

    public void setChange(TripleStruct<String, Integer, String> change) {
        this.change = change;
    }

    public Pair<String, String> getFreetex() {
        return freetex;
    }

    public void setFreetex(Pair<String, String> freetex) {
        this.freetex = freetex;
    }

    public String getLightMap() {
        return lightMap;
    }

    public void setLightMap(String lightMap) {
        this.lightMap = lightMap;
    }

    public String getNightMap() {
        return nightMap;
    }

    public void setNightMap(String nightMap) {
        this.nightMap = nightMap;
    }

    public int getTextTexture() {
        return textTexture;
    }

    public void setTextTexture(int textTexture) {
        this.textTexture = textTexture;
    }

    public int getAlpha() {
        return alpha;
    }

    public void setAlpha(int alpha) {
        this.alpha = alpha;
    }

    public boolean isNoZCheck() {
        return noZCheck;
    }

    public void setNoZCheck(boolean noZCheck) {
        this.noZCheck = noZCheck;
    }

    public boolean isNoZWrite() {
        return noZWrite;
    }

    public void setNoZWrite(boolean noZWrite) {
        this.noZWrite = noZWrite;
    }
}
