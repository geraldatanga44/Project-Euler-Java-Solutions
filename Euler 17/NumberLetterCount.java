public class NumberLetterCount {
    private static DigitData[] digitData() {
        return new DigitData[] { new DigitData("one", 1), new DigitData("two", 2), new DigitData("three", 3),
                new DigitData("four", 4), new DigitData("five", 5), new DigitData("six", 6), new DigitData("seven", 7),
                new DigitData("eight", 8), new DigitData("nine", 9), new DigitData("ten", 10),
                new DigitData("eleven", 11), new DigitData("twelve", 12), new DigitData("thirteen", 13),
                new DigitData("fourteen", 14), new DigitData("fifteen", 15), new DigitData("sixteen", 16),
                new DigitData("seventeen", 17), new DigitData("eighteen", 18), new DigitData("nineteen", 19),
                new DigitData("twenty", 20), new DigitData("thirty", 30), new DigitData("forty", 40),
                new DigitData("fifty", 50), new DigitData("sixty", 60), new DigitData("seventy", 70),
                new DigitData("eighty", 80), new DigitData("ninety", 90), new DigitData("one hundred", 100),
                new DigitData("two hundred", 200), new DigitData("three hundred", 300),
                new DigitData("four hundred", 400), new DigitData("five hundred", 500),
                new DigitData("six hundred", 600), new DigitData("seven hundred", 700),
                new DigitData("eight hundred", 800), new DigitData("nine hundred", 900),
                new DigitData("one thousand", 1000), };
    }

    public static String letterRepresentation(int digit) {
        var array = digitData();
        var str = "";
        for (DigitData d : array) {
            if (d.getRealValue() == digit) {
                str = d.getSpelledValue();
                break;
            }
        }
        return str;
    }

    private static String generateCombination(int value) {
        var and = "and";
        var result = "";

        while (value > 10) {
            if (value == 1000) {
                result = letterRepresentation(value);
                value = 0;
            }

            if (value > 10 && value < 20) {
                result = letterRepresentation(value);
                value = 0;
            }

            if (value < 1000 && value > 119) {
                var mode = value % 100;
                value = value - mode;
                result = letterRepresentation(value);

                if (mode != 0)
                    result = result.concat(" " + and + " ");

                value = mode;

                if (value > 10)
                    result = result.concat(" ");
                if (value < 20) {
                    result = result.concat(letterRepresentation(value));
                    value = 0;
                }
            }

            if (value > 100 && value <= 119) {
                var mode = value % 20;
                value = value - mode;
                result = letterRepresentation(value) + " " + and;
                result = result.concat(" " + letterRepresentation(mode));
                value = 0;
            }

            if (value <= 100) {
                var mode = value % 10;
                value = value - mode;
                result = result.concat(letterRepresentation(value));
                value = mode;
                if (value != 0)
                    result = result.concat(" ");
            }
        }
        return result.concat(letterRepresentation(value));
    }

    private static long generateOutput(int limit) {
        var summation = 0L;
        for (var x = 1; x <= limit; x++) {
            var str = generateCombination(x).replace(" ", "");
            summation += str.length();
        }
        return summation;
    }

    public static void main(String... args) {
        System.out.println(generateOutput(1000));
    }

}
