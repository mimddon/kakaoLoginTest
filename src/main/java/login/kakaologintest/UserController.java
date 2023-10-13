package login.kakaologintest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/kakao")
    public String handleKakaoCallback(@RequestParam("code") String code, Model model) {
        // 카카오로부터 받은 인증 코드를 사용하여 사용자 정보를 요청
        User user = userService.getUserInfo(code);

        if (user != null) {
            // 사용자 정보를 모델에 추가하여 템플릿에서 사용할 수 있게 함
            model.addAttribute("user", user);
            return "kakao_success"; // 카카오 로그인 성공 페이지로 이동
        } else {
            return "kakao_error"; // 오류 발생 시 오류 페이지로 이동
        }
    }



}
