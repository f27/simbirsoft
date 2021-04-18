package endpoints;

public enum Endpoints {
    MAIN(""), PORTFOLIO("/portfolio"), HELP("/help"), AGREEMENT("/agreement");
    String path;

    Endpoints(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }

    public String getPath(String locale) {
        switch (locale) {
            case ("ru"):
                return path;
            case ("en"):
                return "/en" + path;
            default:
                return path;
        }

    }

    public String addPath(String additionalPath) {
        return path + additionalPath;
    }

    public String addPath(String additionalPath, String locale) {
        return getPath(locale) + additionalPath;
    }
}