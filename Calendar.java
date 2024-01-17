/** 
 * Prints the calendars of  the requisted year.
 */
public class Calendar {
    // Starting the calendar on 1/1/1900
	static int dayOfWeek = 2;     // 1.1.1900 was a Monday
	static int countForSunday = 0; // Number of days in January
	static int dayOfMonth = 1;
	static int month = 1;
	static int year = 1900;

	/**
	 * Prints the calendars of all the years in the 20th century. Also prints the
	 * number of Sundays that occured on the first day of the month during this period.
	 */
	public static void main(String args[]) {
		int NewYear = Integer.parseInt(args[0]);
		while (year < NewYear) {
			advance();
		}
		while (year == NewYear) {
			for (month = 1; month <= 12; month++) { // Runs 12 times for months
				for (dayOfMonth = 1; dayOfMonth <= nDaysInMonth(month, NewYear); dayOfMonth++) {// Runs as the days in month.
					if (dayOfWeek == 0) {
					System.out.println(dayOfMonth + "/" + month + "/" + NewYear + " Sunday");
						dayOfWeek = ((dayOfWeek + 1) % 7);
					}else {
						System.out.println(dayOfMonth + "/" + month + "/" + NewYear);
						dayOfWeek = ((dayOfWeek + 1) % 7); // update the week of the day and still in range (1-7).
					}
				}
			}
				year++;
		}
	}
	// Advances the date (day, month, year) and the day-of-the-week.
	 // If the month changes, sets the number of days in this month.
	 // Side effects: changes the static variables dayOfMonth, month, year, dayOfWeek, nDaysInMonth.
	 private static void advance() {

		for (month = 1; month <= 12; month++) { // Runs 12 times for months
			 for (dayOfMonth = 1; dayOfMonth <= nDaysInMonth(month, year); dayOfMonth++) { // Runs as the days in month.
			 dayOfWeek = ((dayOfWeek + 1) % 7); // update the week of the day and still in range (1-7).
			 }
		 }
		 	year++;
	 }
		 
    // Returns true if the given year is a leap year, false otherwise.
	private static boolean isLeapYear(int year) {
		if ((year % 4 == 0) && (year % 100 != 0)){
			return true;
		}else{
			return false;
		}
	}

	 
	// Returns the number of days in the given month and year.
	// April, June, September, and November have 30 days each.
	// February has 28 days in a common year, and 29 days in a leap year.
	// All the other months have 31 days.
	private static int nDaysInMonth(int month, int year) {
		int numOfdays = 31;
		if (isLeapYear(year)) {
			switch (month) {
				case 2: numOfdays = 29;
					break;
				case 4: numOfdays = 30;
					break;
				case 6: numOfdays = 30;
					break;
				case 9: numOfdays = 30;
					break;
				case 11: numOfdays = 30;
					break;
				default:numOfdays = 31;
					break;
			}
		}else{
			switch (month) {
				case 2: numOfdays = 28;
					break;
				case 4: numOfdays = 30;
					break;
				case 6: numOfdays = 30;
					break;
				case 9: numOfdays = 30;
					break;
				case 11: numOfdays = 30;
					break;
				default:numOfdays = 31;
			}

		}
		return numOfdays;
	}
}