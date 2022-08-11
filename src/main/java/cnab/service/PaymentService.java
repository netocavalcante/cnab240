package cnab.service;

import java.math.BigDecimal;

public interface PaymentService extends Service {
    BigDecimal getTotalOfCoin();
    BigDecimal getPaymentAmount();
}
