package pl.paisley4.omsivehicleutils;

import java.io.File;
import java.io.IOException;
import java.util.Objects;

public class Main {

    public static void main(String[] args) throws IOException {

        File cfgFile = new File(Objects.requireNonNull(ClassLoader.getSystemClassLoader().getResource("example.cfg")).getFile());
        File ctiFile = new File(Objects.requireNonNull(ClassLoader.getSystemClassLoader().getResource("example.cti")).getFile());

        if(!cfgFile.exists()){
            System.out.println("File not found!");
            return;
        }

        if(!ctiFile.exists()){
            System.out.println("File not found!");
            return;
        }

        VehicleConfig config = new VehicleConfig();
        config.read(cfgFile);

        VehicleCTI cti = new VehicleCTI();
        cti.read(ctiFile);
    }

}
