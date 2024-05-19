package vn.edu.iuh.fit.subjectservice.enums;

import java.time.LocalTime;

public enum ThoiGian {
    T1(LocalTime.of(6, 30), LocalTime.of(7, 20)),
    T2(LocalTime.of(7, 20), LocalTime.of(8, 10)),
    T3(LocalTime.of(8, 10), LocalTime.of(9, 00)),
    T4(LocalTime.of(9, 10), LocalTime.of(10, 00)),
    T5(LocalTime.of(10, 00), LocalTime.of(10, 50)),
    T6(LocalTime.of(10, 50), LocalTime.of(11, 40)),
    T7(LocalTime.of(12, 30), LocalTime.of(13, 20)),
    T8(LocalTime.of(13, 20), LocalTime.of(14, 10)),
    T9(LocalTime.of(14, 10), LocalTime.of(15, 00)),
    T10(LocalTime.of(15, 10), LocalTime.of(16, 00)),
    T11(LocalTime.of(16, 00), LocalTime.of(16, 50)),
    T12(LocalTime.of(16, 50), LocalTime.of(17, 40)),
    T13(LocalTime.of(18, 00), LocalTime.of(18, 50)),
    T14(LocalTime.of(18, 50), LocalTime.of(19, 40)),
    T15(LocalTime.of(19, 40), LocalTime.of(20, 30));

    private final LocalTime gioBatDau;
    private final LocalTime gioKetThuc;

    ThoiGian(LocalTime gioBatDau, LocalTime gioKetThuc) {
        this.gioBatDau = gioBatDau;
        this.gioKetThuc = gioKetThuc;
    }
}
