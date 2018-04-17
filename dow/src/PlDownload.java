public class PlDownload {
    private String filename;
    private String path;
    private String classname;

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getClassname() {
        return classname;
    }

    public void setClassname(String classname) {
        this.classname = classname;
    }

    @Override
    public String toString() {
        return "PlDownload{" +
                "filename='" + filename + '\'' +
                ", path='" + path + '\'' +
                ", classname='" + classname + '\'' +
                '}';
    }
}
