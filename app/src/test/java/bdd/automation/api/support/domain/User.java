package bdd.automation.api.support.domain;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class User {

    @Builder.Default
    private int id = 10;
    @Builder.Default
    private String username = "rafalima" ;
    @Builder.Default
    private String firstName = "Rafael";
    @Builder.Default
    private String lastName = "Lima";
    @Builder.Default
    private String email = "rafael@gmail.com";
    @Builder.Default
    private String password = "12345";
    @Builder.Default
    private String phone = "819999999";
    @Builder.Default
    private int userStatus = 1;
}
