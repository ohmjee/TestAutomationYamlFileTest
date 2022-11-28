package UIAutomation.CommonUtilities;


import org.yaml.snakeyaml.Yaml;

import java.io.*;
import java.util.Map;
import java.util.Properties;

public class ReadValueFromCucumberYmlFile {
    public String propFile(String Input) {
        String filePath=System.getProperty("user.dir") + "/src/test/resources/cucumber.yml";
        File file = new File(filePath);
        FileInputStream fileInput = null;
        try {
            fileInput = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Properties prop = new Properties();
        try {
            prop.load(fileInput);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return prop.getProperty(Input);

    }
}