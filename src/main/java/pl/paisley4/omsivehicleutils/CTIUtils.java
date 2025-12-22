package pl.paisley4.omsivehicleutils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CTIUtils {

    public static Map<String, Integer> readSetvars(List<String> lines) {
        Map<String, Integer> setvars = new HashMap<>();

        for(int i = 0; i < lines.size(); i++){
            if(lines.get(i).startsWith("[setvar]")){
                setvars.put(lines.get(i + 1), Integer.parseInt(lines.get(i + 2)));
                i += 2;
            }
        }

        return setvars;
    }

}
