package org.jason.test;

import org.jason.commons.CommonUtils;
import org.junit.Test;

import java.util.UUID;

/**
 * Created by JTrancender on 2017/3/2.
 */
public class UUIDTest {
    @Test
    public void func() {
        UUID uuid = UUID.randomUUID();
        String string = uuid.toString();
        string = string.replace("-", "");
        string = string.toUpperCase();
        System.out.println(string);

        System.out.println(CommonUtils.uuid());
    }
}
