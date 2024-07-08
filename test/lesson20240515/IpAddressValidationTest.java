package lesson20240515;

import org.junit.jupiter.api.Assertions;

class IpAddressValidationTest {

   @org.junit.jupiter.api.Test
   void isValidIPAddress() {
       boolean isValid = IpAddressValidation.isValidIPAddress("127.0.0.1");
       Assertions.assertTrue(isValid);

       isValid = IpAddressValidation.isValidIPAddress("127.0.0.300");
       Assertions.assertFalse(isValid);

       Assertions.assertFalse(IpAddressValidation.isValidIPAddress(null));
       Assertions.assertFalse(IpAddressValidation.isValidIPAddress(""));
       Assertions.assertFalse(IpAddressValidation.isValidIPAddress("sdkadfbadbfk"));
       Assertions.assertTrue(IpAddressValidation.isValidIPAddress("0.0.0.0"));
       Assertions.assertTrue(IpAddressValidation.isValidIPAddress("255.255.255.255"));
       Assertions.assertFalse(IpAddressValidation.isValidIPAddress("256.255.255.255"));
       Assertions.assertFalse(IpAddressValidation.isValidIPAddress("255.256.255.255"));
       Assertions.assertFalse(IpAddressValidation.isValidIPAddress("255.255.256.255"));
       Assertions.assertFalse(IpAddressValidation.isValidIPAddress("255.255.255.256"));
       Assertions.assertFalse(IpAddressValidation.isValidIPAddress("0000.0.0.0"));
       Assertions.assertFalse(IpAddressValidation.isValidIPAddress("0.0.0"));
       Assertions.assertFalse(IpAddressValidation.isValidIPAddress("0.0.0.0.0"));
       Assertions.assertFalse(IpAddressValidation.isValidIPAddress("0,0.0.0"));
   }
   }
