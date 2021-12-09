package uk.ac.reigate.scripts.utils

import org.slf4j.Logger
import org.slf4j.LoggerFactory

class AddressUtils {

	private static final Logger LOGGER = LoggerFactory.getLogger(AddressUtils.class);
	
	static String addressComponentsToAddressString(String houseBuildingNumber, String houseBuildingName, String street, String town, String postcode) {
		String output = '';
		if (houseBuildingName != null && houseBuildingName != '') {
			output += houseBuildingName + ', ';
		}
		if (houseBuildingNumber != null && houseBuildingNumber != '') {
			output += houseBuildingNumber + ' ' + street + ', ';
		} else {
			output += street + ', ';
		}
		if (town != null && town != '') {
			output += town + ', ';
		}
		if (postcode != null && postcode != '') {
			output += postcode;
		}
		return output;
	}
	
}
