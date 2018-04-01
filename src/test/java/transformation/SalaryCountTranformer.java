package transformation;

import cucumber.api.Transformer;

public class SalaryCountTranformer extends Transformer<Integer>{

    @Override
    public Integer transform(String salary) {
        return salary.length();
    }
}
