import org.junit.jupiter.api.Test;

import java.time.ZonedDateTime;

/**
 * @Author cheems
 * @Date 2022/12/30 0:11
 */
public class Test1 {

    @Test
    public void timeTest(){
        ZonedDateTime zbj = ZonedDateTime.now(); // 默认时区
        System.out.println(zbj);
    }
}
