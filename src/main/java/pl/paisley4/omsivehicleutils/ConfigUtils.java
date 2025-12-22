package pl.paisley4.omsivehicleutils;

import pl.paisley4.omsivehicleutils.attributes.*;
import pl.paisley4.omsivehicleutils.objects.Pair;
import pl.paisley4.omsivehicleutils.objects.TripleStruct;

import java.util.ArrayList;
import java.util.List;

public class ConfigUtils {

    public static List<CTCTexture> readCTCTextures(List<String> lines) {
        List<CTCTexture> ctcTextures = new ArrayList<>();

        for(int i = 0; i < lines.size(); i++){
            if(lines.get(i).startsWith("[CTCTexture]")){
                CTCTexture ctcTexture = new CTCTexture(lines.get(i + 1), lines.get(i + 2));
                ctcTextures.add(ctcTexture);
                i += 2;
            }
        }

        return ctcTextures;
    }

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
                i += 10;
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
                i += 8;
                continue;
            }
        }

        return textures;

    }

    public static List<Mesh> readMeshes(List<String> lines) {
        List<Mesh> meshes = new ArrayList<>();

        for(int i = 0; i < lines.size(); i++){
            if(lines.get(i).equalsIgnoreCase("[mesh]")){
                Mesh mesh = readMesh(lines, i);
                meshes.add(mesh);
                // To prevent reading the same file part twice, skip to the end of the mesh.
                i = mesh.getEndsAt();
            }
        }

        return meshes;
    }

    public static Mesh readMesh(List<String> lines, int index) {
        Mesh mesh = new Mesh();
        mesh.setStartsAt(index);
        mesh.setMesh(lines.get(index+1));
        for(int i = index+2; i < lines.size(); i++){
            if(lines.get(i).equalsIgnoreCase("[mesh]")){
                mesh.setEndsAt(i - 1);
                return mesh;
            }
            if(lines.get(i).toLowerCase().startsWith("[illumination_interior]")){
                List<Integer> illuminationInterior = new ArrayList<>();
                illuminationInterior.add(Integer.parseInt(lines.get(i + 1)));
                illuminationInterior.add(Integer.parseInt(lines.get(i + 2)));
                illuminationInterior.add(Integer.parseInt(lines.get(i + 3)));
                illuminationInterior.add(Integer.parseInt(lines.get(i + 4)));
                mesh.setIlluminationInterior(illuminationInterior);
                continue;
            }
            if(lines.get(i).toLowerCase().startsWith("[mouseevent]")){
                mesh.setMouseEvent(lines.get(i + 1));
                continue;
            }
            if(lines.get(i).toLowerCase().startsWith("[newanim]")){
                // TODO: Finish Animation class and write logic to read it.
                continue;
            }
            if(lines.get(i).toLowerCase().startsWith("[viewpoint]")){
                mesh.setViewPoint(Integer.parseInt(lines.get(i + 1)));
                i += 1;
                continue;
            }
            if(lines.get(i).toLowerCase().startsWith("[visible]")){
                mesh.setVisibility(new Pair<>(lines.get(i + 1), Integer.parseInt(lines.get(i + 2))));
                i += 2;
                continue;
            }
            if(lines.get(i).toLowerCase().startsWith("[matl]")){
                Pair<Integer, Matl> matl = readMatl(lines, i);
                mesh.getMaterials().put(matl.getFirst(), matl.getSecond());
            }
        }
        mesh.setEndsAt(lines.size() - 1);
        return mesh;
    }

    public static Pair<Integer, Matl> readMatl(List<String> lines, int index){
        int matlIndex = Integer.parseInt(lines.get(index+2));
        Matl matl = new Matl();
        matl.setMaterial(lines.get(index+1));
        for(int i = index+3; i < lines.size(); i++){
            if(lines.get(i).toLowerCase().startsWith("[matl]") ||
                lines.get(i).toLowerCase().startsWith("[mesh]") ||
                lines.get(i).toLowerCase().startsWith("[illumination_interior]") ||
                lines.get(i).toLowerCase().startsWith("[mouseevent]") ||
                lines.get(i).toLowerCase().startsWith("[newanim]") ||
                lines.get(i).toLowerCase().startsWith("[viewpoint]") ||
                lines.get(i).toLowerCase().startsWith("[visible]")){
                return new Pair<>(matlIndex, matl);
            }
            if(lines.get(i).startsWith("[matl_envmap]")){
                Pair<String, Double> envMap = new Pair<>(lines.get(i + 1), Double.parseDouble(lines.get(i + 2)));
                matl.setEnvMap(envMap);
                i += 2;
                continue;
            }
            if(lines.get(i).startsWith("[matl_change]")){
                TripleStruct<String, Integer, String> change = new TripleStruct<>(lines.get(i + 1), Integer.parseInt(lines.get(i + 2)), lines.get(i + 3));
                matl.setChange(change);
                i += 3;
                continue;
            }
            if(lines.get(i).startsWith("[matl_freetex]")){
                Pair<String, String> freetex = new Pair<>(lines.get(i + 1), lines.get(i + 2));
                matl.setFreetex(freetex);
                i += 2;
                continue;
            }
            if(lines.get(i).startsWith("[matl_lightmap]")){
                matl.setLightMap(lines.get(i + 1));
                i += 1;
                continue;
            }
            if(lines.get(i).startsWith("[matl_nightmap]")){
                matl.setNightMap(lines.get(i + 1));
                i += 1;
                continue;
            }
            if(lines.get(i).startsWith("[useTextTexture]")){
                matl.setTextTexture(Integer.parseInt(lines.get(i + 1)));
                i += 1;
                continue;
            }
            if(lines.get(i).startsWith("[matl_noZcheck]")){
                matl.setNoZCheck(true);
                continue;
            }
            if(lines.get(i).startsWith("[matl_noWrite]")){
                matl.setNoZWrite(true);
                continue;
            }
            if(lines.get(i).startsWith("[matl_alpha]")){
                matl.setAlpha(Integer.parseInt(lines.get(i + 1)));
                i += 1;
                continue;
            }
        }

        // End of the file, return matl

        return new Pair<>(matlIndex, matl);
    }

}
