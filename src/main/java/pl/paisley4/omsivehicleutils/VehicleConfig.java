package pl.paisley4.omsivehicleutils;

import com.ibm.icu.text.CharsetDetector;
import com.ibm.icu.text.CharsetMatch;
import pl.paisley4.omsivehicleutils.attributes.CTCTexture;
import pl.paisley4.omsivehicleutils.attributes.Mesh;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class VehicleConfig {

    private Path path;
    private String coding;
    private List<String> lines;
    private List<CTCTexture> ctcTextures;
    private List<Object> textTextures;
    private List<Mesh> meshes;

    public VehicleConfig() {
        this.lines = new ArrayList<>();
        this.ctcTextures = new ArrayList<>();
        this.textTextures = new ArrayList<>();
        this.meshes = new ArrayList<>();
    }

    public VehicleConfig(Path path) {
        this.read(path);
    }

    public VehicleConfig(Path path, List<CTCTexture> ctcTextures, List<Object> textTextures, List<Mesh> meshes) {
        this.path = path;
        this.ctcTextures = ctcTextures;
        this.textTextures = textTextures;
        this.meshes = meshes;
    }

    public Path getPath() {
        return path;
    }

    public void read(File file) {
        this.read(file.toPath());
    }

    public void read(Path path) {
        this.path = path;

        try {
            byte[] bytes = Files.readAllBytes(path);

            this.lines = new ArrayList<>();

            CharsetDetector detector = new CharsetDetector();
            detector.setText(bytes);

            CharsetMatch match = detector.detect();
            this.coding = match.getName();

            String[] encoded = match.getString().split("\n");
            // Clear all \r characters from the file.
            for(int i = 0; i < encoded.length; i++){
                encoded[i] = encoded[i].replace("\r", "");
            }
            this.lines.addAll(List.of(encoded));
        }catch (IOException e) {
            e.printStackTrace();
        }

        this.ctcTextures = ConfigUtils.readCTCTextures(lines);
        this.textTextures = ConfigUtils.readTextTextures(lines);
        this.meshes = ConfigUtils.readMeshes(lines);
    }

    public List<String> getLines() {
        return lines;
    }

    public String getCoding() {
        return coding;
    }

    public void setLines(List<String> lines) {
        this.lines = lines;
    }

    public List<CTCTexture> getCtcTextures() {
        return ctcTextures;
    }

    public void setCtcTextures(List<CTCTexture> ctcTextures) {
        this.ctcTextures = ctcTextures;
    }

    public List<Object> getTextTextures() {
        return textTextures;
    }

    public void setTextTextures(List<Object> textTextures) {
        this.textTextures = textTextures;
    }

    public List<Mesh> getMeshes() {
        return meshes;
    }

    public void setMeshes(List<Mesh> meshes) {
        this.meshes = meshes;
    }
}
