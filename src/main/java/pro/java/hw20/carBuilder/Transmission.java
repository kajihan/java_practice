package pro.java.hw20.carBuilder;

public enum Transmission {
    AUTOMATIC("Automatic"),
    MANUAL("Manual");

    private final String displayName;

    Transmission(String displayName) {
        this.displayName = displayName;
    }

    @Override
    public String toString() {
        return displayName;
    }
}
