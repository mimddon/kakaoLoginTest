package login.kakaologintest;

import javax.persistence.*;

@Entity
@Table(name = "users") //데이터베이스 테이블 이름
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String email;

    private String kakaoUserId; // 카카오에서 제공하는 사용자 아이디
    private String kakaoProfileImageUrl; // 카카오 프로필 이미지 URL
    private String kakaoAccessToken; // 카카오 인증 토큰 (인증 완료 후 받은 토큰)

}
