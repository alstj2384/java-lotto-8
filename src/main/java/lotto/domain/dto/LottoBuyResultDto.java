package lotto.domain.dto;

import java.util.List;
import lotto.domain.Lotto;

public record LottoBuyResultDto(int size, List<Lotto> lottos) {
}
