/*
---------------------------------------------- Structure: ----------------------------------------------
Object
 ├── java.util.Date
 ├── java.util.Calendar (abstract)
 │    └── java.util.GregorianCalendar
 ├── java.text.DateFormat (abstract)
 │    └── java.text.SimpleDateFormat
 └── java.time.*
      ├── LocalDate
      ├── LocalTime
      ├── LocalDateTime
      ├── ZonedDateTime
      ├── Instant
      ├── Period
      ├── Duration
      ├── format.DateTimeFormatter
      └── interfaces (Temporal, TemporalAdjuster, etc.)

Date/Time API
Implement the Temporal or TemporalAccessor interfaces to handle date-time operations

Temporal -> objects that implement the Temporal interface
  - LocalDateTime - Date and time without timezone	LocalDateTime.of(2024, 4, 20, 10, 0)
  - ZonedDateTime - Date and time with timezone	ZonedDateTime.now(ZoneId.of("UTC"))
  - OffsetDateTime - Date and time with offset from UTC	OffsetDateTime.now()
  - Instant - A moment on the timeline in UTC	Instant.now()
  - LocalTime - Time without date or timezone	✅ But only if paired with same base
  - OffsetTime - Time with offset from UTC	✅ Same as above

ChronoLocalDate is an interface in the Java java.time.chrono package.
It represents a date without time or timezone, similar to LocalDate, but with support for different calendar systems — not just the default ISO (Gregorian) calendar.

TemporalAccessor is an interface in the java.time.temporal package that provides a read-only view of date-time objects.
A general interface that allows you to access fields of a date-time (like year, month, day, hour...), but not modify them.
Implementations:
- LocalDate - Date without time
- LocalDateTime - Date with time
- ZonedDateTime - Date-time with a time-zone
- OffsetDateTime - Date-time with an offset from UTC
- Instant - A timestamp
- Year, MonthDay, LocalTime - Partial representations
Methods:
- boolean isSupported(TemporalField field) → Checks if a certain field (like ChronoField.YEAR) is supported.
- long getLong(TemporalField field) → Gets the value of a supported field.
- int get(TemporalField field) → Like getLong() but returns int.

DayOfWeek is an enum in the java.time
- DayOfWeek.MONDAY
- DayOfWeek.TUESDAY
- DayOfWeek.WEDNESDAY
- DayOfWeek.THURSDAY
- DayOfWeek.FRIDAY
- DayOfWeek.SATURDAY
- DayOfWeek.SUNDAY
Each value has an associated int from 1 (Monday) to 7 (Sunday), following the ISO-8601 standard.
- int getValue() - Returns 1–7 for Monday–Sunday
- String name() - Returns the name (e.g., "MONDAY")
- DayOfWeek plus(long days) - Adds days to current day
- DayOfWeek minus(long days) - Subtracts days from current day
- static DayOfWeek of(int dayOfWeek) - Returns DayOfWeek from int (1–7)
- static DayOfWeek from(TemporalAccessor) - Gets the day from another date/time object

ChronoUnit: Time Measurement Units -> Represents units of time: days, months, hours, etc.
DayOfWeek: Enumerates the Days (Monday to Sunday) -> Represents named days of the week. Used for checking or manipulating day-specific logic (like checking if a day is SUNDAY, or moving to MONDAY).

Month is an enum in the java.time package:
public enum Month {
    JANUARY, FEBRUARY, MARCH, APRIL, MAY, JUNE,
    JULY, AUGUST, SEPTEMBER, OCTOBER, NOVEMBER, DECEMBER
}
- getValue() → returns int (1–12)
- plus(long months) → returns a new Month after adding months
- minus(long months) → subtracts months
- length(boolean leapYear) → returns number of days in that month
- firstDayOfYear(boolean leapYear) → day-of-year when that month starts

with() Method — Overview ->
- The with() method belongs to the Temporal interface
- It returns a copy of the original object, with one field changed (but all other fields preserved).
Methods:
- public LocalDate withYear(int year)
- public LocalDate withMonth(int month)                       // 1 to 12
- public LocalDate withDayOfMonth(int dayOfMonth)             // 1 to 31
- public LocalDate withDayOfYear(int dayOfYear)               // 1 to 365 (or 366 leap year)
- public LocalDate with(TemporalAdjuster adjuster)            // LocalDate firstMonday = date.with(TemporalAdjusters.firstInMonth(DayOfWeek.MONDAY));
- public LocalDate with(TemporalField field, long newValue)   // LocalDate changedYear = date.with(ChronoField.YEAR, 2000);
Example:
LocalDate original = LocalDate.now();
Option 1: LocalDate newYear = original.withYear(2000);       // changes year
Option 2: LocalDate newDate = original.with(ChronoField.YEAR, 2000);
Option 3: LocalDate newDate = original.with(TemporalAdjusters.firstDayOfMonth());
 */

/*
---------------------------------------------- LocalDate - date without time, e.g., 2025-01-28  ----------------------------------------------
Object -> LocalDate
Implements: Temporal, TemporalAdjuster, Comparable<T>, ChronoLocalDate (for LocalDate)

Factory Method (no public constructor):
public static LocalDate now()  - Returns the current date from the system clock.
public static LocalDate of(int year, int month, int dayOfMonth) - Description: Returns an instance of LocalDate initialized with the specified year, month, and day.

static LocalDate parse(CharSequence text) -> Uses the default ISO_LOCAL_DATE_TIME format, Expected format: yyyy-MM-dd'T'HH:mm:ss // String datetime = "2023-08-15T14:30:00";
static LocalDate parse(CharSequence text, DateTimeFormatter formatter) -> allows  to define a custom format.

LocalDate plusDays(long daysToAdd) - Returns a copy of this date with the specified number of days added.
LocalDate minusDays(long daysToSubtract) - Returns a copy of this date with the specified number of days subtracted.
boolean isBefore(LocalDate other) - Checks if this date is before the specified date.
boolean isAfter(LocalDate other) - Checks if this date is after the specified date.
public boolean isLeapYear() - check if the year is leap
String format(DateTimeFormatter formatter) - Formats this date using the specified formatter.

Component	Method	Returns
Day of week - getDayOfWeek() - DayOfWeek enum (MONDAY, etc.)
Day of month - getDayOfMonth() - int (1–31)
Day of year - getDayOfYear() - int (1–366)
Month - getMonth() - Month enum (JANUARY, etc.)
Year - getYear() - int (e.g., 2025)
------------------------------------------------------------------------------------------------------------------------------------------------
*/

/*
---------------------------------------------- LocalTime - a time without date, e.g., 10:15:30 ----------------------------------------------
Object -> LocalTime
Implements: Temporal, TemporalAdjuster, Comparable<T>, ChronoLocalDateTime (for LocalDateTime).

Factory Method (no public constructor):
public static LocalTime now() - Returns the current time from the system clock.
public static LocalTime of(int hour, int minute, int second) - LocalTime instance initialized with the specified hour, minute, and second.
static LocalTime parse(CharSequence text) -> Uses the default ISO_LOCAL_DATE_TIME format, Expected format: yyyy-MM-dd'T'HH:mm:ss
static LocalTime parse(CharSequence text, DateTimeFormatter formatter) -> allows  to define a custom format.

LocalTime plusHours(long hoursToAdd) - Returns a copy of this time with the specified hours added.
LocalTime minusMinutes(long minutesToSubtract) - Returns a copy of this time with the specified minutes subtracted.

Fields constants:
 - LocalTime.MIDNIGHT - Exactly midnight - 00:00 (00 hours, 00 minutes)
 - LocalTime.NOON - Exactly noon - 12:00 (12 hours, 00 minutes)
 - LocalTime.MAX - The maximum possible time value - 23:59:59.999999999 (just before the next day)
------------------------------------------------------------------------------------------------------------------------------------------------
*/

/*
---------------------------------------------- LocalDateTime - date and time without a timezone, e.g., 2025-01-28T10:15:30 ----------------------------------------------
Object -> LocalDateTime
Implements: Temporal, TemporalAdjuster, Comparable<T>

Factory Method (no public constructor):
public static LocalDateTime now() - Returns the current date and time from the system clock.
public static LocalDateTime of(int year, int month, int dayOfMonth, int hour, int minute) - LocalDateTime instance initialized with the specified date and time.

static LocalDateTime parse(CharSequence text) -> Uses the default ISO_LOCAL_DATE_TIME format, Expected format: yyyy-MM-dd'T'HH:mm:ss
static LocalDateTime parse(CharSequence text, DateTimeFormatter formatter) -> allows  to define a custom format.

LocalDate toLocalDate() - Extracts the LocalDate part of this date-time.
LocalTime toLocalTime() - Extracts the LocalTime part of this date-time.
String format(DateTimeFormatter formatter) - Formats this date-time using the specified formatter.
------------------------------------------------------------------------------------------------------------------------------------------------
*/

/*
---------------------------------------------- ZonedDateTime - a date and time with a timezone, e.g., 2025-01-28T10:15:30+01:00[Europe/Paris] ----------------------------------------------
Object -> ZonedDateTime
Implements: Temporal, TemporalAdjuster, Comparable<ZonedDateTime>

Factory Method (no public constructor):
public static ZonedDateTime now() - current date and time with the system's default timezone.
static ZonedDateTime now(ZoneId zone)
public static ZonedDateTime of(int year, int month, int dayOfMonth, int hour, int minute, int second, int nanoOfSecond, ZoneId zone) - ZonedDateTime instance with a specific timezone.
static ZonedDateTime of(LocalDate date, LocalTime time, ZoneId zone)
static ZonedDateTime ofInstant(Instant instant, ZoneId zone)

ZoneId getZone() - Returns the time-zone of this date-time.
Instant toInstant() - Converts this ZonedDateTime to an Instant.
LocalDateTime toLocalDateTime()
ZonedDateTime withZoneSameInstant(ZoneId zone) - Returns a copy of this date-time with a different time zone, adjusting the date and time so the instant remains the same.

ZoneId
- Constructors:
ZoneId.of(String zoneId) -> Creates a ZoneId from a string name // ZoneId zoneId = ZoneId.of("Asia/Tokyo");
ZoneId.systemDefault() -> Gets the system's default time zone // ZoneId systemZone = ZoneId.systemDefault();  // e.g., "Europe/London"
ZoneId tokyoZone = ZoneId.of("Asia/Tokyo");
ZonedDateTime tokyoNow = ZonedDateTime.now(tokyoZone);
- Methods:
String getId() -> Returns the ID, like "Europe/Berlin"
ZoneRules getRules() -> Gets the rules defining this time zone (offsets, DST, etc.)
static Set<String> getAvailableZoneIds() -> Returns all available time zone IDs
static ZoneId of(String zoneId) -> Gets a ZoneId from a string
static ZoneId systemDefault() -> Gets system default zone
- Universal / GMT
  "UTC"
  "GMT"
  "Etc/UTC"
  "Etc/GMT"
- Offsets:
  "+02:00"
  "-05:00"
- 🇺🇸 America
  "America/New_York"
  "America/Los_Angeles"
- 🇪🇺 Europe
  "Europe/London"
  "Europe/Paris"
- Asia
  "Asia/Tokyo"
  "Asia/Shanghai"
- 🇦🇺 Australia
  "Australia/Sydney"
  "Australia/Melbourne"
- Africa
  "Africa/Cairo"
- Pacific & Others
  "Pacific/Auckland"
------------------------------------------------------------------------------------------------------------------------------------------------
*/

/*
---------------------------------------------- Instant - a timestamp (point in time) in UTC, e.g., 2025-01-28T09:15:30Z ----------------------------------------------
Object -> Instant
Implements: Temporal, TemporalAdjuster, Comparable<Instant>

Factory Method (no public constructor):
public static Instant now() - the current timestamp in UTC.
public static Instant ofEpochMilli(long epochMilli) - returns an Instant initialized to the given epoch milliseconds.

long toEpochMilli() - Converts this Instant to the number of milliseconds since the epoch.
Instant plusSeconds(long secondsToAdd) - Returns a copy of this instant with the specified number of seconds added.

Factory methods:
public static Instant now();
public static Instant now(Clock clock);
public static Instant ofEpochSecond(long epochSecond);
public static Instant ofEpochSecond(long epochSecond, long nanoAdjustment);
public static Instant ofEpochMilli(long epochMilli);
public static Instant parse(CharSequence text);

Plus-Minus:
public Instant plus(long amountToAdd, TemporalUnit unit);
public Instant plusSeconds(long secondsToAdd);
public Instant plusMillis(long millisToAdd);
public Instant plusNanos(long nanosToAdd);

Conversions:
public long toEpochMilli();
public int getNano();
public long getEpochSecond();
public String toString();
------------------------------------------------------------------------------------------------------------------------------------------------
*/

/*
---------------------------------------------- Duration - time in seconds and nanoseconds (useful for intervals) ----------------------------------------------
Object -> Duration
Implements: TemporalAmount

Factory Method (no public constructor):
public static Duration ofDays(long days) - creates a Duration of a specific number of days.
public static Duration between(Temporal startInclusive, Temporal endExclusive) - creates a Duration representing the amount of time between two Temporal instances.

long toHours() - Converts this duration to hours.
long toMinutes() - Converts this duration to minutes.
Duration plus(Duration durationToAdd) - Returns a copy of this duration with another duration added.

Factory methods:
public static Duration ofDays(long days);
public static Duration ofHours(long hours);
public static Duration ofMinutes(long minutes);
public static Duration ofSeconds(long seconds);
public static Duration ofSeconds(long seconds, long nanoAdjustment);
public static Duration ofMillis(long millis);
public static Duration ofNanos(long nanos);
public static Duration between(Temporal startInclusive, Temporal endExclusive); (!)
public static Duration parse(CharSequence text);

Plus-Minus:
public Duration plus(Duration duration);
public Duration plus(long amountToAdd, TemporalUnit unit);
public Duration plusDays(long daysToAdd);
public Duration plusHours(long hoursToAdd);
public Duration plusMinutes(long minutesToAdd);
public Duration plusSeconds(long secondsToAdd);
public Duration plusMillis(long millisToAdd);
public Duration plusNanos(long nanosToAdd);

Conversions:
public long toDays();
public long toHours();
public long toMinutes();
public long toSeconds();
public long toMillis();
public long toNanos();
public String toString();
------------------------------------------------------------------------------------------------------------------------------------------------
*/

/*
---------------------------------------------- Period - date-based amount of time, such as 2 years, 3 months, and 4 days ----------------------------------------------
Object -> Period
Implements: ChronoPeriod

Factory Method (no public constructor):
public static Period of(int years, int months, int days) - Creates a Period of the specified amount of time.

public static Period between(ChronoLocalDate startDate, ChronoLocalDate endDate) -> calculates the difference between years, months, days

Period plusYears(long yearsToAdd) - Returns a copy of this period with the specified number of years added.
int getDays()
int getYears() - Returns the number of years in this period.
int getMonths() - Returns the number of months in this period.

Period VS Duration
                 - Period                                       - Duration
What it measures - Date-based amount (like years, months, days) - Time-based amount (like hours, minutes, seconds, nanoseconds)
Best for	     - Dates (e.g., LocalDate)	                    - Times (e.g., LocalDateTime, Instant)
Example	         - "2 years, 3 months, and 5 days"	            - "5 hours, 30 minutes, and 15 seconds"
Created by	     - Period.between(startDate, endDate)	        - Duration.between(startDateTime, endDateTime)
Can you get total
days directly?	 - ❌ (Period separates years/months/days)	    - ✅ (Duration can be converted to total seconds, minutes, hours, etc.)
Classes 	     - LocalDate, YearMonth, etc. (date-only)	    - Instant, LocalDateTime, OffsetDateTime (date+time)
------------------------------------------------------------------------------------------------------------------------------------------------
*/

/*
---------------------------------------------- DateTimeFormatter (Abstract, New API - java.time package) - formats and parses date and time objects in a thread-safe manner ----------------------------------------------
Object -> DateTimeFormatter
Implements: Formatter<TemporalAccessor>

Factory Method (no public constructor):
public static DateTimeFormatter ofPattern(String pattern) - Creates a formatter with a specified pattern.
public static DateTimeFormatter ISO_LOCAL_DATE - A pre-defined formatter for ISO-8601 local date strings.

String format(TemporalAccessor temporal) - Formats a date-time object to a string.
TemporalAccessor parse(CharSequence text) - Parses the text to a date-time object.

Allowed Pattern Characters:

Year (y)
y: Year (e.g., 2025)
yyyy: Four digits for the year (e.g., 2025)
yy: Last two digits of the year (e.g., 25 for the year 2025)

Month (M)
M: Month (1-12)
MM: Two digits (01-12)
MMM: Abbreviated month name (e.g., Jan, Feb, etc.)
MMMM: Full month name (e.g., January, February, etc.)

Day (d)
d: Day of the month (1-31)
dd: Two digits (01-31)

Hour (H, h)
H: Hour of the day (0-23)
HH: Two digits (00-23)
h: Hour of the day (1-12)
hh: Two digits (01-12)

Minute (m)
m: Minute of the hour (0-59)
mm: Two digits (00-59)

Second (s)
s: Second of the minute (0-59)
ss: Two digits (00-59)

Fraction of Second (S)
S: Millisecond (e.g., 200 for 2025-01-28T16:53:44.200)
SSS: Three digits for milliseconds (e.g., 2025-01-28T16:53:44.200)

AM/PM (a)
a: AM/PM marker (e.g., AM, PM)

Timezone (z, Z)
z: Abbreviated timezone (e.g., PST, UTC)
Z: Full timezone offset (e.g., +02:00, -0800)

Day:
EE: short day name
EEEE: full day name

Zone Offset (+02:00, -05:00, etc.)
➡️ Pattern symbol: XX
✅ Example output: +02:00, -05:00

Zone Name (Europe/Berlin, America/New_York, etc.)
➡️ Pattern symbol: VV
✅ Example output: Europe/Berlin, America/New_York

Literal Characters

Any other characters in the pattern string are treated as literals, so -, /, or : are treated as separators in the format.
For example: "yyyy-MM-dd HH:mm:ss" is interpreted with dashes and colons as separators between year, month, day, etc.

Example Patterns:
"yyyy-MM-dd": Formats as 2025-01-28
"yyyy/MM/dd HH:mm:ss": Formats as 2025/01/28 16:53:44
"yyyy MMM dd": Formats as 2025 Jan 28
"yyyy-MM-dd'T'HH:mm:ss.SSS": Formats as 2025-01-28T16:53:44.280

Full String example (with extra words, we use ''):
        String pattern14 = "'Today is' EEEE, d 'of' MMMM yyyy 'at' HH:mm";
        DateTimeFormatter ftf14 = DateTimeFormatter.ofPattern(pattern14);
------------------------------------------------------------------------------------------------------------------------------------------------
*/

/*
---------------------------------------------- ChronoUnit ----------------------------------------------

ChronoUnit is an enum in the java.time package that provides constants for various units of time, such as days, hours, minutes, years, etc.

The ChronoUnit enum implements the TemporalUnit interface, which allows you to manipulate temporal values (such as LocalDate, LocalTime, LocalDateTime, etc.).

ChronoUnit.DAYS: Represents days.
ChronoUnit.HOURS: Represents hours.
ChronoUnit.MINUTES: Represents minutes.
ChronoUnit.SECONDS: Represents seconds.
ChronoUnit.MONTHS: Represents months.
ChronoUnit.YEARS: Represents years.

public long between(Temporal startInclusive, Temporal endExclusive) - calculates the number of days between
public Temporal addTo(Temporal temporal, long amount) - Adds the specified amount of the current unit (like days, months, etc.) to the temporal object.

Example of methods:
LocalDate startDate = LocalDate.of(2025, 1, 1);
LocalDate endDate = LocalDate.of(2025, 12, 31);
long daysBetween = ChronoUnit.DAYS.between(startDate, endDate);
------------------------------------------------------------------------------------------------------------------------------------------------
*/

/*
---------------------------------------------- TemporalAdjusters ----------------------------------------------

Utility class with static methods.

Usage:
The method with(TemporalAdjuster adjuster) in LocalDate applies an adjuster to return a modified date.
LocalDate today = LocalDate.of(2025, 1, 15);
LocalDate firstDayNextMonth = today.with(TemporalAdjusters.firstDayOfNextMonth());

public static TemporalAdjuster firstDayOfMonth() -> Returns an adjuster that sets the date to the first day of the month.
public static TemporalAdjuster lastDayOfMonth() -> Returns an adjuster that sets the date to the last day of the month.
public static TemporalAdjuster firstDayOfNextMonth() -> public static TemporalAdjuster firstDayOfNextMonth()
public static TemporalAdjuster firstInMonth(DayOfWeek dayOfWeek) -> Returns an adjuster that sets the date to the first occurrence of the specified day-of-week in the current month.
public static TemporalAdjuster lastInMonth(DayOfWeek dayOfWeek) -> Returns an adjuster that sets the date to the last occurrence of the specified day-of-week in the current month
public static TemporalAdjuster next(DayOfWeek dayOfWeek) -> Returns an adjuster that moves the date to the next occurrence of the specified day-of-week after the current date.
public static TemporalAdjuster nextOrSame(DayOfWeek dayOfWeek) -> public static TemporalAdjuster nextOrSame(DayOfWeek dayOfWeek)
public static TemporalAdjuster previous(DayOfWeek dayOfWeek) -> public static TemporalAdjuster previous(DayOfWeek dayOfWeek)
public static TemporalAdjuster previousOrSame(DayOfWeek dayOfWeek) -> Returns an adjuster that moves the date to the previous occurrence of the specified day-of-week, or returns the current date if it already matches.

2. DayOfWeek
MONDAY (1)
TUESDAY
WEDNESDAY
THURSDAY
FRIDAY
SATURDAY
SUNDAY (7)

public int getValue() -> returns the number
public static DayOfWeek of(int dayOfWeek) -> Returns the DayOfWeek corresponding to the given integer value. The value must be between 1 and 7.
public DayOfWeek plus(long days) / minus(long days) -> Returns the day-of-week that is the specified number of days after this one, wrapping around as necessary. For example, DayOfWeek.FRIDAY.plus(3) will result in DayOfWeek.MONDAY.
------------------------------------------------------------------------------------------------------------------------------------------------
 */

public class Main {
    public static void main(String[] args) {

    }
}