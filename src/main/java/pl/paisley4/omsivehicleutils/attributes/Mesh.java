package pl.paisley4.omsivehicleutils.attributes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Mesh {

    private int startsAt, endsAt;
    private String mesh;
    private String visibilityVariable;
    private int visibilityValue;
    private int viewPoint;
    // Always expected only 4 values
    private List<Integer> illuminationInterior;
    private Map<Integer, Matl> materials;
    private String mouseEvent;
    private Animation animation;

    public Mesh() {
        this.illuminationInterior = new ArrayList<>();
        this.materials = new HashMap<>();
    }

    public Mesh(int startsAt, int endsAt, String mesh, String visibilityVariable,
                int visibilityValue, int viewPoint, List<Integer> illuminationInterior,
                Map<Integer, Matl> materials) {
        this.startsAt = startsAt;
        this.endsAt = endsAt;
        this.mesh = mesh;
        this.visibilityVariable = visibilityVariable;
        this.visibilityValue = visibilityValue;
        this.viewPoint = viewPoint;
        this.illuminationInterior = illuminationInterior;
        this.materials = materials;
    }

    public int getStartsAt() {
        return startsAt;
    }

    public void setStartsAt(int startsAt) {
        this.startsAt = startsAt;
    }

    public int getEndsAt() {
        return endsAt;
    }

    public void setEndsAt(int endsAt) {
        this.endsAt = endsAt;
    }

    public String getVisibilityVariable() {
        return visibilityVariable;
    }

    public void setVisibilityVariable(String visibilityVariable) {
        this.visibilityVariable = visibilityVariable;
    }

    public int getVisibilityValue() {
        return visibilityValue;
    }

    public void setVisibilityValue(int visibilityValue) {
        this.visibilityValue = visibilityValue;
    }

    public String getMesh() {
        return mesh;
    }

    public void setMesh(String mesh) {
        this.mesh = mesh;
    }

    public int getViewPoint() {
        return viewPoint;
    }

    public void setViewPoint(int viewPoint) {
        this.viewPoint = viewPoint;
    }

    public List<Integer> getIlluminationInterior() {
        return illuminationInterior;
    }

    public void setIlluminationInterior(List<Integer> illuminationInterior) {
        this.illuminationInterior = illuminationInterior;
    }

    public Map<Integer, Matl> getMaterials() {
        return materials;
    }

    public void setMaterials(Map<Integer, Matl> materials) {
        this.materials = materials;
    }
}
