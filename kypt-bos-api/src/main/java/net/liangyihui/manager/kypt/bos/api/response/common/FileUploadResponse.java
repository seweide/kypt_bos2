package net.liangyihui.manager.kypt.bos.api.response.common;

import java.io.Serializable;

public class FileUploadResponse implements Serializable {
    private String path;
    private String fileName;

    public FileUploadResponse(String path, String fileName) {
        this.path = path;
        this.fileName = fileName;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
}
