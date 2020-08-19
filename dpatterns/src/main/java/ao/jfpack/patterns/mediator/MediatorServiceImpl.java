package ao.jfpack.patterns.mediator;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class MediatorServiceImpl {

    private final InstallationService installationService = new InstallationService(this);
    private final DeviceService deviceService = new DeviceService(this);

    public void findDeviceById(String deviceId) {
        deviceService.findById(deviceId);
    }

    public void findInstallationById(String instId) {
        installationService.findById(instId);
    }
}
