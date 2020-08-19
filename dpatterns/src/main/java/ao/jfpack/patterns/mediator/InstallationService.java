package ao.jfpack.patterns.mediator;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class InstallationService {

    private final MediatorServiceImpl mediatorService;

    public void addDeviceToInstallation(String deviceId) {
        mediatorService.findDeviceById(deviceId);
    }

    public void findById(String instId) {
        System.out.println("List of devices for installation " + instId);
    }
}
