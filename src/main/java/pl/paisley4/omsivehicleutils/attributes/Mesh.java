package pl.paisley4.omsivehicleutils.attributes;

import pl.paisley4.omsivehicleutils.objects.Pair;

import java.util.*;

public class Mesh implements Comparable<Mesh> {

    private int startsAt, endsAt;
    private String mesh;
    private Pair<String, Integer> visibility;
    private int viewPoint;
    // Always expected only 4 values
    private List<Integer> illuminationInterior;
    private Map<Integer, Matl> materials;
    private String mouseEvent;
    private List<Animation> animations;

    public Mesh() {
        this.illuminationInterior = new ArrayList<>();
        this.materials = new HashMap<>();
        this.animations = new ArrayList<>();
    }

    public Mesh(int startsAt, int endsAt, String mesh, Pair<String, Integer> visibility,
                int viewPoint, List<Integer> illuminationInterior, Map<Integer, Matl> materials,
                String mouseEvent, List<Animation> animations) {
        this.startsAt = startsAt;
        this.endsAt = endsAt;
        this.mesh = mesh;
        this.visibility = visibility;
        this.viewPoint = viewPoint;
        this.illuminationInterior = illuminationInterior;
        this.materials = materials;
        this.mouseEvent = mouseEvent;
        this.animations = animations;
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

    public Pair<String, Integer> getVisibility() {
        return visibility;
    }

    public void setVisibility(Pair<String, Integer> visibility) {
        this.visibility = visibility;
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

    public String getMouseEvent() {
        return mouseEvent;
    }

    public void setMouseEvent(String mouseEvent) {
        this.mouseEvent = mouseEvent;
    }

    public List<Animation> getAnimations() {
        return animations;
    }

    public void setAnimations(List<Animation> animations) {
        this.animations = animations;
    }

    @Override
    public int compareTo(Mesh o) {
        return Comparator.comparingInt(Mesh::getStartsAt).compare(this, o);
    }
}
