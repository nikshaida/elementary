package com.softserve.elementary.task_04;
/**
 * FileUtilImplStringSearchable
 * <p>
 * Version 1
 * <p>
 * <p>
 * 06.10.2018
 * <p>
 * <p>
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
        Pattern pattern = Pattern.compile(findString.toLowerCase());
        Matcher matcher;
        matcher = pattern.matcher(stringBuilder.toString().toLowerCase());
        while (matcher.find()) {
            res++;
        }
        return res;
    }

    @Override
    public void replaceString(String path, String findString, String replacementString) throws IOException {


        List<String> stringsFromFile = Files.readAllLines(Paths.get(path));
        stringBuilder = new StringBuilder();
        stringsFromFile.forEach(s -> stringBuilder.append(s));
        String res = stringBuilder.toString().replaceAll("\n", "").replaceAll(findString, replacementString);
        FileWriter fw = new FileWriter(path);
        fw.write(res);
        fw.flush();
        fw.close();
    }


}
