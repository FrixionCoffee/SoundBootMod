package jp.sugarcoffee.soundboot;

public enum JavaVersion {
    JAVA8,
    JAVA11_ENVIRONMENT_OVER,
    JAVA16,
    JAVA17_FUTURE,
    ELSE;

    public static JavaVersion getJavaVersion() {
        String versionString = System.getProperty("java.specification.version");
        if ("1.8".equals(versionString)) {
            return JavaVersion.JAVA8;
        }

        try {
            final int versionInt = Integer.parseInt(versionString);
            if (versionInt >= 17) {
                return JAVA17_FUTURE;
            }

            if (versionInt == 16) {
                return JAVA16;
            }

            if (versionInt >= 11) {
                return JAVA11_ENVIRONMENT_OVER;
            }

            return ELSE;

        } catch (NumberFormatException e) {
            throw new IllegalJavaEnvironmentException(e);
        }
    }
}
