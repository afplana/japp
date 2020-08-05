package ao.jfpack.patterns.bridge;

public class BridgeDemo {
        public static void main(String[] args) {
            SaveService device = new SaveServiceImpl(null, new DeviceSaveService());
            SaveService installation = new SaveServiceImpl(null, new InstallationSaveService());

            device.save();
            installation.save();
        }
}
