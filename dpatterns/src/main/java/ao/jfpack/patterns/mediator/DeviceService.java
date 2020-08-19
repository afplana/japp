package ao.jfpack.patterns.mediator;

public class DeviceService {

    private final MediatorServiceImpl mediatorService;

    public DeviceService(MediatorServiceImpl mediatorService) {
        this.mediatorService = mediatorService;
    }

    public void findById(String deviceId) {
        System.out.println("New Device registered id: " + deviceId);
    }

    public void getDevicesByInstallationId(String instId) {
        mediatorService.findInstallationById(instId);
    }
}
