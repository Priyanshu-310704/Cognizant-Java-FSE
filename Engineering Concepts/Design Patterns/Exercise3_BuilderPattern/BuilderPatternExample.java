class Computer {
    private final String cpu;
    private final String ram;
    private final String storage;
    private final String graphicsCard;
    private final boolean bluetoothEnabled;

    private Computer(Builder builder) {
        this.cpu = builder.cpu;
        this.ram = builder.ram;
        this.storage = builder.storage;
        this.graphicsCard = builder.graphicsCard;
        this.bluetoothEnabled = builder.bluetoothEnabled;
    }

    public static class Builder {
        private String cpu;
        private String ram;
        private String storage;
        private String graphicsCard;
        private boolean bluetoothEnabled;

        public Builder cpu(String cpu) {
            this.cpu = cpu;
            return this;
        }

        public Builder ram(String ram) {
            this.ram = ram;
            return this;
        }

        public Builder storage(String storage) {
            this.storage = storage;
            return this;
        }

        public Builder graphicsCard(String graphicsCard) {
            this.graphicsCard = graphicsCard;
            return this;
        }

        public Builder bluetoothEnabled(boolean bluetoothEnabled) {
            this.bluetoothEnabled = bluetoothEnabled;
            return this;
        }

        public Computer build() {
            return new Computer(this);
        }
    }

    public String toString() {
        return "Computer{" +
                "cpu='" + cpu + '\'' +
                ", ram='" + ram + '\'' +
                ", storage='" + storage + '\'' +
                ", graphicsCard='" + graphicsCard + '\'' +
                ", bluetoothEnabled=" + bluetoothEnabled +
                '}';
    }
}

public class BuilderPatternExample {
    public static void main(String[] args) {
        Computer officeComputer = new Computer.Builder()
                .cpu("Intel i5")
                .ram("16 GB")
                .storage("512 GB SSD")
                .build();

        Computer gamingComputer = new Computer.Builder()
                .cpu("Intel i9")
                .ram("32 GB")
                .storage("1 TB SSD")
                .graphicsCard("RTX 4070")
                .bluetoothEnabled(true)
                .build();

        System.out.println(officeComputer);
        System.out.println(gamingComputer);
    }
}
