package amerebagatelle.github.io.thresher;

import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;

public class Checker {
    public long maxMemory;

    public void checkMemory() {
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
                        maxMemory = Character.getNumericValue(values[0]) * 1048576;
                        break;
                }
            }
        });
        if(maxMemory < Integer.parseInt(Settings.loadSetting("minimumDedicatedRAM"))*1e+6) {
            System.out.println("Test");
        }
    }
}
