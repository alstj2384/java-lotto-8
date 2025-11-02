package lotto.domain.dto;

import java.util.Map;
import lotto.domain.Prize;

public record LottoResultDto(Map<Prize, Integer> results, double profit) {
}
