package amerebagatelle.github.io.thresher;

import amerebagatelle.github.io.thresher.util.ThresherException;

import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;
import java.util.ArrayList;

public class Checker {
    public long maxMemory;

    public void checkValues() throws ThresherException {
        ArrayList<String[]> listOfWrong = new ArrayList<>();
        if (checkMemory()) listOfWrong.add(new String[]{
                "Not enough RAM.",
                "The modpack author(s) recommended " + Settings.loadSetting("minimumDedicatedRAM") + "MB of RAM, but you have " + maxMemory/1048576 + "MB of RAM.",
                "Please dedicate more RAM to Java."
        });

        if(listOfWrong.size() != 0) throw new ThresherException(listOfWrong);
    }

    public boolean checkMemory() {
        RuntimeMXBean bean = ManagementFactory.getRuntimeMXBean();
        bean.getInputArguments().forEach(argument -> {
            if(argument.matches("-Xmx\\d\\w")) {
                argument = argument.substring(4);
                char[] values = argument.toCharArray();
                switch (values[1]) {
                    case 'G':
                        maxMemory = Character.getNumericValue(values[0]) * (long)1073741824;
                        break;

                    case 'M' :
                        maxMemory = Character.getNumericValue(values[0]) * (long)1048576;
                        break;
                }
            }
        });
        return (maxMemory < Integer.parseInt(Settings.loadSetting("minimumDedicatedRAM")) * 1e+6);
    }
}
