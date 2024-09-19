package grushevkaya.onboarding.neoflex;

import grushevkaya.onboarding.neoflex.dto.VacationPayCalcInputTO;
import grushevkaya.onboarding.neoflex.service.IsDayOffService;
import grushevkaya.onboarding.neoflex.service.VacationPayCalcService;
import org.apache.coyote.BadRequestException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

@SpringBootTest
class VacationPayCalculatorApplicationTests {
//	private static final VacationPayCalcService vacationPayCalcService = new VacationPayCalcService(new IsDayOffService());

	@Test
	void contextLoads() {
	}
//
//	@Test
//	void calculateByDates() {
//		// date calculation testing
//		Assertions.assertEquals(58000.0, vacationPayCalcService.calcVacation(
//				new VacationPayCalcInputTO(719200.0, 3,
//						LocalDate.parse("2024-09-16"), LocalDate.parse("2024-10-14"))));
//	}
//
//	// days amount calculation testing
//	@Test
//	void calculateByAmountOfDays1() {
//		Assertions.assertEquals(58000.0, vacationPayCalcService.calcVacation(
//				new VacationPayCalcInputTO(719200.0, 20,
//						null, null)));
//	}
//
//	@Test
//	void calculateByAmountOfDays2() {
//		Assertions.assertEquals(95000.0, vacationPayCalcService.calcVacation(
//				new VacationPayCalcInputTO(471200.0, 50,
//						null, null)));
//	}
//
//	@Test
//	void calculateByAmountOfDays3() {
//		Assertions.assertEquals(9500.0, vacationPayCalcService.calcVacation(
//				new VacationPayCalcInputTO(471200.0, 5,
//						null, null)));
//	}
//
//	// ignoring days amount when dates are identified
//	@Test
//	void testIgnoringDaysAmount() {
//		Assertions.assertEquals(9500.0, vacationPayCalcService.calcVacation(
//				new VacationPayCalcInputTO(471200.0, 15,
//						LocalDate.parse("2024-10-31"), LocalDate.parse("2024-11-07"))));
//	}
//
//	// testing vacation days
//	@Test
//	void testVacationDaysCounting() {
//		Assertions.assertEquals(37700.0, vacationPayCalcService.calcVacation(
//				new VacationPayCalcInputTO(719200.0, 3,
//						LocalDate.parse("2024-12-20"), LocalDate.parse("2025-01-17"))));
//	}
//
//	// testing calculation priority
//	@Test
//	void testingCalculationPriorityWithError() {
//		Assertions.assertEquals(37700.0, vacationPayCalcService.calcVacation(
//				new VacationPayCalcInputTO(719200.0, 13,
//						LocalDate.parse("2024-12-20"), LocalDate.parse("2024-01-17"))));
//
//	}
//
//	@Test
//	void errorTesting() {
//		Assertions.assertEquals(new BadRequestException(), vacationPayCalcService.calcVacation(
//				new VacationPayCalcInputTO(719200.0, null,
//						LocalDate.parse("2024-12-20"), LocalDate.parse("2024-01-17"))));
//	}
}
