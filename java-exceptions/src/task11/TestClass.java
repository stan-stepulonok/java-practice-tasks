package task11;

public class TestClass {

    public String str;

    TestClass(Object str) throws CustomException {

        if (str.getClass() != String.class) {
            throw new CustomException();
        }
        this.str = (String) str;
    }

}
