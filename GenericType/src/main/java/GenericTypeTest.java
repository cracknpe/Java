import bean.Animal;
import bean.People;
import configuration.Config;
import configuration.spec.LinuxConfig;
import configuration.spec.WindowsConfig;

public class GenericTypeTest {
    public static void main(String[] args) {
        Config<LinuxConfig> configConfig =
                new Config<>("linuxConfig","linux-x333",new LinuxConfig());
        Config<WindowsConfig> configConfig1 =
                new Config<>("windowsConfig","win-x555",new WindowsConfig());
    }
}
