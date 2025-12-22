package pl.paisley4.omsivehicleutils;

import com.ibm.icu.text.CharsetDetector;
import com.ibm.icu.text.CharsetMatch;
import pl.paisley4.omsivehicleutils.attributes.CTCTexture;
import pl.paisley4.omsivehicleutils.attributes.Mesh;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Main {

    public static void main(String[] args) throws IOException {

        File file = new File(Objects.requireNonNull(ClassLoader.getSystemClassLoader().getResource("example.cfg")).getFile());

        if(!file.exists()){
            System.out.println("File not found!");
            return;
        }

        byte[] readFile = Files.readAllBytes(file.toPath());

        List<String> lines = new ArrayList<>();

        {
            CharsetDetector detector = new CharsetDetector();
            detector.setText(readFile);

            CharsetMatch match = detector.detect();

            String[] encoded = match.getString().split("\n");
            lines.addAll(Arrays.asList(encoded));
            for(int i = 0; i < lines.size(); i++){
                lines.set(i, lines.get(i).replace("\r", ""));
            }
        }

        List<CTCTexture> ctcTextures = ConfigUtils.readCTCTextures(lines);

        List<Object> textTextures = ConfigUtils.readTextTextures(lines);

        List<Mesh> meshes = ConfigUtils.readMeshes(lines);

        System.out.println("CTC Textures: " + ctcTextures.size());
        System.out.println("Text Textures: " + textTextures.size());
        System.out.println("Meshes: " + meshes.size());
    }

}
