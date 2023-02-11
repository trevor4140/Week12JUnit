import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.params.provider.Arguments.arguments;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;
class Test_Demo_Test {
private Test_Demo testDemo;
	@BeforeEach
	void setUp() throws Exception {
		
	
	}

	@ParameterizedTest
	@MethodSource("TestDemoTest#argumentsForAddPositive")
	void assertThatTwoPositiveNumbersAreAddedCorrectly(int a, int b, 
			int expected, boolean expectException) {
		
		
		if(!expectException) {
			assertThat(testDemo.addPositive(a,b)).isEqualTo(expected);
		}
		else {
			assertThatThrownBy(() -> 
			testDemo.addPositive(a,b)).isInstanceOf(IllegalArgumentException.class);
		}
	}
	static Stream<Arguments> argumentsForAddPositive() {
		return Stream.of(
				arguments(2, 4, 6, false),
				arguments(1, 3, 4, false),
				arguments(1, -1, 3, true),
				arguments(-2, -2, -4, true)
				);
	}
	@Test
    void assertThatNumberSquaredIsCorrect() {
		Test_Demo mockDemo = spy(testDemo);
	
		doReturn(5).when(mockDemo).getRandomInt();
	
		int fiveSquared = mockDemo.randomNumberSquared();
		assertThat(fiveSquared).isEqualTo(25);
	
    }
}
