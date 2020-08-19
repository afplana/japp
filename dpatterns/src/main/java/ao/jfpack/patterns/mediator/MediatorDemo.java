package ao.jfpack.patterns.mediator;

public class MediatorDemo {

    public static void main(String[] args) {
        MediatorServiceImpl med = new MediatorServiceImpl();
        InstallationService inst = new InstallationService(med);
        DeviceService dev = new DeviceService(med);

        inst.addDeviceToInstallation("DEV_DT_109");
        dev.getDevicesByInstallationId("1532");
    }
}
