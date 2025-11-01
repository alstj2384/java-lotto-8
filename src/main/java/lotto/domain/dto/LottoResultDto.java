package lotto.domain.dto;

import java.util.Map;
import lotto.domain.Prize;

public record LottoResultDto(Map<Prize, Integer> results, double profit) {
    public static LottoResultDto from(Map<Prize, Integer> results, double profit) {
        return new LottoResultDto(results, profit);
    }
}
