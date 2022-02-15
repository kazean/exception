package hello.exception.api;

import hello.exception.exception.UserException;
import hello.exception.exhandler.ErrorResult;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api2")
public class ApiExceptionV2Controller {

    @GetMapping("/members/{id}")
    public MemberDto getMember(@PathVariable("id") String id){
        if ("ex".equals(id)){
            throw new RuntimeException("잘못된 사용자");
        }
        if ("bad".equals(id)) {
            throw new IllegalArgumentException("잘못된 값 입력");
        }
        if ("user-ex".equals(id)) {
            throw new UserException("사용자오류");
        }
        return new MemberDto(id, "hello " + id);
    }


    @Data
    @AllArgsConstructor
    static class MemberDto{
        private String memberId;
        private String name;
    }
}
