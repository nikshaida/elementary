package com.softserve.elementary.task_04.interfaces;
/**
 * StringSearchable
 *
 * Version 1
 *
 *
 * 06.10.2018
 *
 *
 * IT Academy SoftServe
 **/

import java.io.IOException;

public interface StringSearchable {

    int countString(String path, String findString) throws IOException;
    void replaceString(String path, String findString, String replacmentString) throws IOException;

}
