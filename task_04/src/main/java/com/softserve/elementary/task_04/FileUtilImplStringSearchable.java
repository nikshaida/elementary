package com.softserve.elementary.task_04;
/**
 * FileUtilImplStringSearchable
 *
 * Version 1
 *
 *
 * 06.10.2018
 *
 *
 * IT Academy SoftServe
 **/
import com.softserve.elementary.task_04.interfaces.StringSearchable;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FileUtilImplStringSearchable implements StringSearchable {
    private StringBuilder stringBuilder;

    @Override
    public int countString(String path, String findString) throws IOException {
        stringBuilder = new StringBuilder();
        int res = 0;
        List<String> stringsFromFile = Files.readAllLines(Paths.get(path));
        for (String s : stringsFromFile) {
            stringBuilder.append(s);
        }
        Pattern pattern = Pattern.compile(findString);
        Matcher matcher;
            matcher = pattern.matcher(stringBuilder.toString());
            while (matcher.find()){
                res++;}

        return res;
    }


    @Override
    public void replaceString(String path, String findString, String replacementString) throws IOException {
        List<String> stringsFromFile = Files.readAllLines(Paths.get(path));
         stringBuilder = new StringBuilder();

       String res =  stringBuilder.toString().replaceAll(findString, replacementString);
       FileWriter fw = new FileWriter(path);
            fw.write(res);

        fw.flush();
    }
}
