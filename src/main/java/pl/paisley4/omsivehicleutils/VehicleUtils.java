package pl.paisley4.omsivehicleutils;

import pl.paisley4.omsivehicleutils.attributes.Mesh;

import java.io.*;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class VehicleUtils {

    public static void removeUselessMeshes(VehicleConfig config, VehicleCTI cti){
        List<Mesh> meshesToRemove = new ArrayList<>();

        config.getMeshes().forEach(mesh -> {
            if(mesh.getVisibility() != null){
                if(cti.getSetvars().containsKey(mesh.getVisibility().getFirst())){
                    if(cti.getSetvars().get(mesh.getVisibility().getFirst()) != mesh.getVisibility().getSecond()){
                        meshesToRemove.add(mesh);
                    }
                }
            }
        });

        Collections.sort(meshesToRemove);
        Collections.reverse(meshesToRemove);

        meshesToRemove.forEach(m -> {
            for(int i = m.getEndsAt(); i >= m.getStartsAt(); i--){
                config.getLines().remove(i);
            }
        });

        File outputFile = new File("output.cfg");

        try{
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outputFile), Charset.forName(config.getCoding())));
            for(String line : config.getLines()){
                writer.write(line + "\n");
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }

}
