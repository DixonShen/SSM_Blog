import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by Z003R98D on 4/5/2017.
 */

@RunWith(SpringJUnit4ClassRunner.class)     // spring的单元测试
@ContextConfiguration({"classpath:spring/spring-*.xml"})    // 上下文配置
public class BaseTest {
}
