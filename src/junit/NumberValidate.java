package junit;

public class NumberValidate {
    public boolean validate(Integer value){
        for (int i = 2; i < (value/2); i++) {
            if (value%i==0){
                return false;
            }
        }
        return true;
    }
}
