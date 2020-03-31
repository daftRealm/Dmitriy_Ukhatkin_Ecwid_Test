package utilities;

import io.qameta.allure.Step;

public class BaseStep {

    @Step("Принудительное ожидание {time}")
    public BaseStep setTimeout(long time) {
        try {
            Thread.sleep(time);
        }
        catch (Exception ex) {
            return this;
        }
        return this;
    }
}
