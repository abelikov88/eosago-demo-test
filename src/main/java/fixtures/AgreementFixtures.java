package fixtures;

import models.Agreement;
import utils.Parser;

import java.util.Map;

/**
 * @author abelikov
 */
public class AgreementFixtures {

    public static Agreement getAgreement(String agreementParams) {
        Map<String, Agreement> agreements = Parser.parseFromJson("agreement.json", Agreement.class);
        return agreements.get(agreementParams);
    }
}
