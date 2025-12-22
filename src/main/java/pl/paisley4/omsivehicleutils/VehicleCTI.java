package pl.paisley4.omsivehicleutils;

import com.ibm.icu.text.CharsetDetector;
import com.ibm.icu.text.CharsetMatch;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class VehicleCTI {

    private Path path;
    private List<String> lines;
    private Map<String, Integer> setvars;

    public VehicleCTI() {
        this.setvars = new HashMap<>();
        this.lines = new ArrayList<>();
    }

    public VehicleCTI(Path path) {
        this.read(path);
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

            String[] encoded = match.getString().split("\n");
            // Clear all \r characters from the file.
            for(int i = 0; i < encoded.length; i++){
                encoded[i] = encoded[i].replace("\r", "");
            }
            this.lines.addAll(List.of(encoded));
        }catch (IOException e) {
            e.printStackTrace();
        }

        this.setvars = CTIUtils.readSetvars(lines);
    }

    public List<String> getLines() {
        return lines;
    }

    public void setLines(List<String> lines) {
        this.lines = lines;
    }

    public Map<String, Integer> getSetvars() {
        return setvars;
    }

    public void setSetvars(Map<String, Integer> setvars) {
        this.setvars = setvars;
    }
}