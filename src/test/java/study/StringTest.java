package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {
    @Test
    void replace() {
        String actual = "abc".replace("b", "d");
        assertThat(actual).isEqualTo("adc");
    }

    @Test
    void split_1() {
        String[] actual = "1,2".split(",");
        assertThat(actual).contains("1", "2");
    }

    @Test
    void split_2() {
        String[] actual = "1".split(",");
        assertThat(actual).containsExactly("1");
    }

    @Test
    void substring() {
        String actual = "(1,2)".substring(1, 4);
        assertThat(actual).isEqualTo("1,2");
    }

    @Test
    @DisplayName("문자열의 0번째 인덱스를 가져오면 정상,값은 문자 a")
    void charAt_success() {
        char actual = "abc".charAt(0);
        assertThat(actual).isEqualTo('a');
    }

    @Test
    @DisplayName("문자열의 문자를 가져올때 위치 값을 벗어나면 에러")
    void charAt_fail() {
        assertThatThrownBy(() -> "abc".charAt(10)).isInstanceOf(StringIndexOutOfBoundsException.class);
    }

}
