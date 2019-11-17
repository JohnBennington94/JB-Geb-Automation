package Utils

import jodd.util.RandomString

class GeneralUtils {

    static String generateRandomString() {
        return RandomString.instance.randomAlphaNumeric(DefaultValues.DEFAULT_RANDOM_STRING_LENGTH)
    }
}
