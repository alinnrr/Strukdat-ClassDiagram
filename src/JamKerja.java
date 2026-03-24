import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class JamKerja {
    private static final LocalTime BUKA = LocalTime.of(8, 0);
    private static final LocalTime TUTUP = LocalTime.of(16, 0);

    public static boolean cek(LocalDateTime dt) {
        DayOfWeek hari = dt.getDayOfWeek();
        LocalTime jam = dt.toLocalTime();
        boolean hariOke = hari != DayOfWeek.SATURDAY    
                        && hari != DayOfWeek.SUNDAY;
        boolean jamOke = !jam.isBefore(BUKA) && !jam.isAfter(TUTUP);
        return hariOke && jamOke;
    }

    public static String namaHari(DayOfWeek d) {
        switch (d) {
            case MONDAY: return "Senin";
            case TUESDAY: return "Selasa";
            case WEDNESDAY: return "Rabu";
            case THURSDAY: return "Kamis";
            case FRIDAY: return "Jumat";
            case SATURDAY: return "Sabtu";
            default: return "Minggu";
        }
    }
}
 