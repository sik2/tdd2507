package com.ll;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class RqTest {
    @Test
    @DisplayName("수정?id=1")
    void t1() {
        Rq rq = new Rq("수정?id=1");

        String actionName= rq.getActionName();

//        assertEquals("수정", actionName);
        assertThat(actionName).isEqualTo("수정");
    }

    @Test
    @DisplayName("삭제?id=1")
    void t2() {
        Rq rq = new Rq("삭제?id=1");

        String actionName= rq.getActionName();

//        assertEquals("삭제", actionName);
        assertThat(actionName).isEqualTo("삭제");
    }

    @Test
    @DisplayName("\"등록?이름=홍길동\" : rq.getActionName()")
    void t3() {
        Rq rq = new Rq("등록?이름=홍길동");

        String paramValue = rq.getParam("이름", "");

//        assertEquals("홍길동", paramValue);
        assertThat(paramValue).isEqualTo("홍길동");
    }

    @Test
    @DisplayName("\"등록?고향=남원\" : rq.getParam(\"고향\", \"\")")
    void t4() {
        Rq rq = new Rq("등록?고향=남원");

        String paramValue = rq.getParam("고향", "");

//        assertEquals("남원", paramValue);
        assertThat(paramValue).isEqualTo("남원");
    }

    @Test
    @DisplayName("\"등록?이름=홍길동&고향=남원\" : rq.getParam(\"이름\", \"\")")
    void t5() {
        Rq rq = new Rq("등록?이름=홍길동&고향=남원");

        String paramValue = rq.getParam("이름", "");

//        assertEquals("홍길동", paramValue);
        assertThat(paramValue).isEqualTo("홍길동");
    }

    @Test
    @DisplayName("\"등록?이름=홍길동&고향=남원\" : rq.getParam(\"고향\", \"\")")
    void t6() {
        Rq rq = new Rq("등록?이름=홍길동&고향=남원");

        String paramValue = rq.getParam("고향", "");

//        assertEquals("남원", paramValue);
        assertThat(paramValue).isEqualTo("남원");
    }

    @Test
    @DisplayName("\"등록?이름=홍길동&고향=남원&성별=남성\" : rq.getParam(\"성별\", \"\")")
    void t7() {
        Rq rq = new Rq("등록?이름=홍길동&고향=남원&성별=남성");

        String paramValue = rq.getParam("성별", "");

//        assertEquals("남성", paramValue);
        assertThat(paramValue).isEqualTo("남성");
    }

    @Test
    @DisplayName("\"등록?성별=\" : rq.getParam(\"성별\", \"모름\")")
    void t8() {
        Rq rq = new Rq("등록?성별=");

        String paramValue = rq.getParam("성별", "모름");

//        assertEquals("모름", paramValue);
        assertThat(paramValue).isEqualTo("모름");
    }

    @Test
    @DisplayName("\"등록?성별\" : rq.getParam(\"성별\", \"모름\")")
    void t9() {
        Rq rq = new Rq("등록?성별");

        String paramValue = rq.getParam("성별", "모름");

//        assertEquals("모름", paramValue);
        assertThat(paramValue).isEqualTo("모름");
    }

    @Test
    @DisplayName("\"등록\" : rq.getParam(\"성별\", \"모름\")")
    void t10() {
        Rq rq = new Rq("등록");

        String paramValue = rq.getParam("성별", "모름");

//        assertEquals("모름", paramValue);
        assertThat(paramValue).isEqualTo("모름");
    }

    @Test
    @DisplayName("\"목록?page=2\" : rq.getParamAsInt(\"page\", 1)")
    void t11() {
        Rq rq = new Rq("목록?page=2");

        int value = rq.getParamAsInt("page", 1);

        assertThat(value).isEqualTo(2);
    }

}
