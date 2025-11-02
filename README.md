# java-lotto-precourse

# 기능 목록

## 입력

### 로또 구입 금액

- [x] 양수를 입력받는다
- [x] [예외] 공백 및 null 입력 시 IllegalArgumentException 발생
- [x] [예외] 숫자가 아닌 값이 입력되면 IllegalArgumentException 발생

### 당첨 번호

- [x] 번호는 쉼표(,)를 기준으로 구분한다
- [x] 입력 사이 공백 허용 (예: 1, 2, 3)
- [x] 숫자 사이의 공백은 허용하지 않음 (예: “1 2”)
- [x] [예외] 공백 및 null 입력 시 IllegalArgumentException 발생
- [x] [예외] 쉼표(,)와 숫자가 아닌 입력이 들어오면 IllegalArgumentException 발생
- [x] [예외] 숫자 사이에 공백이 입력되면 IllegalArgumentException 발생

### 보너스 번호

- [x] 숫자를 입력받는다
- [x] [예외] 공백 및 null 입력 시 IllegalArgumentException 발생
- [x] [예외] 숫자가 아닌 값이 입력되면 IllegalArgumentException 발생

---

## 출력

- [x] 발행한 로또 수량 출력
- [x] 발행한 로또 번호 출력 (오름차순 정렬)
- [x] 당첨 내역 출력
- [x] 수익률 출력
    - [x] 소수 둘째 자리에서 반올림
- [x] 예외 메시지 출력

---

## 로또 발행

- [x] 로또를 발행한다

---

## 로또 추첨

- [x] 당첨 번호를 입력으로 받는다
- [x] [예외] 로또 번호와 보너스 번호가 중복되면 IllegalArgumentException 발생

---

## 당첨 여부 확인

다음 기준에 따른 당첨 결과를 판단한다:

- [x] **1등**: 6개 번호 일치 → 2,000,000,000원
- [x] **2등**: 5개 번호 + 보너스 번호 일치 → 30,000,000원
- [x] **3등**: 5개 번호 일치 → 1,500,000원
- [x] **4등**: 4개 번호 일치 → 50,000원
- [x] **5등**: 3개 번호 일치 → 5,000원

---

## 수익률 계산

- [x] 수익률 = (총 당첨 금액 / 총 구매 금액) × 100
- [x] 소수 둘째 자리에서 반올림

---

## 도메인 설계

### 로또 (Lotto)

- [x] 로또 번호의 숫자 범위는 1 ~ 45
- [x] 중복되지 않는 숫자 6개
- [x] 로또는 오름차순으로 정렬된다
- [x] [예외] 범위를 벗어나는 경우 IllegalArgumentException 발생
- [x] [예외] 6자리가 아니면 IllegalArgumentException 발생
- [x] [예외] 번호가 중복되면 IllegalArgumentException 발생

---

### 당첨 로또 (WinningLotto)

- [x] 중복되지 않는 숫자 6개 + 보너스 번호 1개
- [x] 로또 번호와 보너스 번호 모두 중복되지 않아야 함
- [x] [예외] 보너스 번호가 로또 번호 중복되면 IllegalArgumentException 발생

---

### 로또 발행기 (LottoMachine)

- [x] 금액을 입력받아 로또를 발행
- [x] 로또 1장당 가격 단위(1000원) 검증
- [x] 최대 구매 가능한 로또 개수는 1,000,000개
- [x] [예외] 1장 미만 구매 시 IllegalArgumentException 발생
- [x] [예외] 1,000,000장 초과 구매 시 IllegalArgumentException 발생

---

### 로또 목록 (Lottos)

- [x] 여러 장의 로또를 관리
- [x] 당첨 로또와 비교하여 당첨 결과 판단
- [x] 당첨 등수별 결과 반환 (Enum 활용)

---

### 로또 영수증 (LottoResults)

- [x] 구매한 로또 정보 보관
- [x] 당첨 내역 정보 제공 (필요 시)
- [x] 수익금 계산

---

### 로또 실행기 (LottoGameApp)

- [x] 입력 및 로또 게임 흐름 제어

---

## 예외 처리 규칙

- [x] 잘못된 값 입력 시 IllegalArgumentException 또는 IllegalStateException 발생
- [x] 에러 메시지는 [ERROR]로 시작
- [x] 예외 발생 시 해당 부분부터 입력을 다시 받음
- [x] Exception이 아닌 명확한 예외 유형 사용

---
