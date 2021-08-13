@Component
@EnableConfigurationProperties
@ConfigurationProperties(prefix = "app")
public class AppConfig {
    @NotNull
    private String appUrl;
 
    public String getAppUrl() {
        return appUrl;
    }
}