package pl.paisley4.omsivehicleutils;

import pl.paisley4.omsivehicleutils.attributes.Mesh;
import pl.paisley4.omsivehicleutils.attributes.TextTexture;
import pl.paisley4.omsivehicleutils.attributes.TextTextureEnhanced;

import java.util.ArrayList;
import java.util.List;

public class ConfigUtils {

    public static List<Object> readTextTextures(List<String> lines) {

        List<Object> textures = new ArrayList<>();

        for(int i = 0; i < lines.size(); i++){
            if(lines.get(i).toLowerCase().startsWith("[texttexture]")){
                TextTexture textTexture = new TextTexture();
                textTexture.setStartsAt(i);
                textTexture.setVariable(lines.get(i + 1));
                textTexture.setFontName(lines.get(i + 2));
                textTexture.setWidth(Integer.parseInt(lines.get(i + 3)));
                textTexture.setHeight(Integer.parseInt(lines.get(i + 4)));
                if(lines.get(i + 5).equalsIgnoreCase("0"))
                    textTexture.setFullColor(false);
                else
                    textTexture.setFullColor(true);
                textTexture.setColorR(Integer.parseInt(lines.get(i + 6)));
                textTexture.setColorG(Integer.parseInt(lines.get(i + 7)));
                textTexture.setColorB(Integer.parseInt(lines.get(i + 8)));

                textures.add(textTexture);
                continue;
            }
            if(lines.get(i).toLowerCase().startsWith("[texttexture_enh]")){
                TextTextureEnhanced textTexture = new TextTextureEnhanced();
                textTexture.setStartsAt(i);
                textTexture.setVariable(lines.get(i + 1));
                textTexture.setFontName(lines.get(i + 2));
                textTexture.setWidth(Integer.parseInt(lines.get(i + 3)));
                textTexture.setHeight(Integer.parseInt(lines.get(i + 4)));
                if(lines.get(i + 5).equalsIgnoreCase("0"))
                    textTexture.setFullColor(false);
                else
                    textTexture.setFullColor(true);
                textTexture.setColorR(Integer.parseInt(lines.get(i + 6)));
                textTexture.setColorG(Integer.parseInt(lines.get(i + 7)));
                textTexture.setColorB(Integer.parseInt(lines.get(i + 8)));
                textTexture.setOrientation(Integer.parseInt(lines.get(i + 9)));
                textTexture.setGrid(Integer.parseInt(lines.get(i + 10)));

                textures.add(textTexture);
                continue;
            }
        }

        return textures;

    }

    public static List<Mesh> readMeshes(List<String> lines) {
        List<Mesh> meshes = new ArrayList<>();

        // TODO: All the logic to read meshes.

        return meshes;
    }

}
