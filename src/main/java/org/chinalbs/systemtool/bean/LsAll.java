package org.chinalbs.systemtool.bean;

import java.util.List;

/*
Create by jiangyun on 2018/2/12
*/
public class LsAll implements BasicReturn {


    private List<String> allDirectoryFile;

    public LsAll() {
    }

    public LsAll(List<String> allDirectoryFile) {
        this.allDirectoryFile = allDirectoryFile;
    }

    public List<String> getAllDirectoryFile() {
        return allDirectoryFile;
    }

    public void setAllDirectoryFile(List<String> allDirectoryFile) {
        this.allDirectoryFile = allDirectoryFile;
    }
}
