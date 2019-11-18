package Utils

import jodd.util.RandomString

class GeneralUtils {

    static String generateRandomString(int length = DefaultValues.DEFAULT_RANDOM_STRING_LENGTH) {
        return RandomString.instance.randomAlphaNumeric(length)
    }

}
