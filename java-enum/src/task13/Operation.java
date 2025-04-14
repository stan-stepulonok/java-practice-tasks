package task13;

public enum Operation {

    ADD,
    SUBTRACT {
        @Override
        public double executeOperation(double num1, double num2) {
            return num1 - num2;
        }
    },
    MULTIPLY {
        @Override
        public double executeOperation(double num1, double num2) {
            return num1 * num2;
        }
    },
    DIVIDE {
        @Override
        public double executeOperation(double num1, double num2) {
            double num = 0;
            try {
                num = num1 / num2;
            } catch (NullPointerException e) {
                System.out.println(e);
            }
            return num;
        }
    };

    public double executeOperation(double num1, double num2) {
        return num1 + num2;
    }

}
