package com.tutorials.spring.device;

import javax.servlet.http.HttpServletRequest;

import org.springframework.mobile.device.Device;
import org.springframework.mobile.device.DeviceUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class DeviceDetectionController {

	@RequestMapping("/detect-device")
	public @ResponseBody String detectDevice(/*Device device*/HttpServletRequest request){
		Device device = DeviceUtils.getCurrentDevice(request);
		String deviceType = "unknown";
        if (device.isNormal()) {
            deviceType = "computer";
        } else if (device.isMobile()) {
            deviceType = "mobile";
        } else if (device.isTablet()) {
            deviceType = "tablet";
        }
        return "Connected on " + deviceType + " browser!";
	}
}
