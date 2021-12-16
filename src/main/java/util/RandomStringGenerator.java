package util;

import java.util.Random;
import org.apache.commons.lang3.RandomStringUtils;

public class RandomStringGenerator {

    public static String generateString() {
        Random random = new Random();
        int length = random.ints(8, 20)
                .findFirst()
                .getAsInt();
        return RandomStringUtils.random(length, true, true);
    }
}
