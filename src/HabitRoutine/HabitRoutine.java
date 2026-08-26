package HabitRoutine;
import java.io.*;
import java.nio.file.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class HabitRoutine {

    static class Habit {
        final String key;
        final String time;
        final String label;
        final String tag;
        final String desc;

        Habit(String key, String time, String label, String tag, String desc) {
            this.key = key;
            this.time = time;
            this.label = label;
            this.tag = tag;
            this.desc = desc;
        }
    }

    private static final Path LOG_DIR = Paths.get("habit_logs");
    private static final DateTimeFormatter DATE_FMT = DateTimeFormatter.ISO_LOCAL_DATE;

    public static void main(String[] args) throws IOException {
        List<Habit> habits = buildTodayHabits();
        LocalDate today = LocalDate.now();

        Files.createDirectories(LOG_DIR);

        Map<String, Boolean> todayLog = loadLog(today);

         System.out.println(" Атомдық әдеттер — " + today.format(DATE_FMT));
        System.out.println("=========================================\n");

        Scanner scanner = new Scanner(System.in);

        for (Habit h : habits) {
            boolean alreadyDone = todayLog.getOrDefault(h.key, false);
            System.out.println("[" + h.time + "] " + h.label + "   (" + h.tag + ")");
            System.out.println("   " + h.desc);
            String prompt = alreadyDone
                    ? "   Орындалды ма? (белгіленген) [Enter=иә, n=жоқ]: "
                    : "   Орындалды ма? [y/n]: ";
            System.out.print(prompt);
            String answer = scanner.nextLine().trim().toLowerCase();

            boolean done;
            if (alreadyDone) {
                done = !answer.equals("n");
            } else {
                done = answer.equals("y") || answer.equals("иә") || answer.equals("да");
            }
            todayLog.put(h.key, done);
            System.out.println();
        }

        saveLog(today, todayLog);
        printProgress(habits, todayLog);
        printStreak(habits, today);
    }

      private static List<Habit> buildTodayHabits() {
        boolean longDay = LocalDate.now().getDayOfMonth() % 2 != 0;
        String sportDesc = longDay
                ? "Бүгін — ұзақ күн: 60 минут. Осы кезде орысша аудио/подкаст қой (тәуекел байлау)."
                : "Бүгін — қысқа күн: 30 минут. Осы кезде орысша аудио/подкаст қой (тәуекел байлау).";

        List<Habit> list = new ArrayList<>();
        list.add(new Habit("ru_words", "8:35", "Таңғы орысша сөздер", "2 минут ережесі",
                "Тіс тазалағаннан кейін бірден — 5 жаңа сөз."));
        list.add(new Habit("sport", "9:15", "Жаттығу + орысша аудио", "Кезектесу", sportDesc));
        list.add(new Habit("podcast_action", "—", "Подкасттан 1 әрекет", "Белсенді үйрену",
                "Жаттығудан кейін 2 минут: 1 негізгі идея + оны бүгін қалай қолданатыныңды жаз."));
        list.add(new Habit("ru_speak", "13:00", "Түскі орысша сөйлеу", "Іске асыру ниеті",
                "Түскі астан кейін 10-15 минут дауыстап сөйле немесе аудар."));
        list.add(new Habit("ru_grammar", "16:00", "Орысша грамматика + жеңіл оқу", "Жеке бөлінген уақыт",
                "30-40 минут грамматика, соңында 1 абзац жеңіл кітаптан оқы."));
        list.add(new Habit("coding", "17:00", "Кодинг", "Тұрақты қарқын",
                "1 сағат — қазіргі максимум, әзірге көбейтпе."));
        list.add(new Habit("reading", "21:00", "Кітап оқу (қаз/агыл)", "Қалыптасқан әдет",
                "10 бет, еркін."));
        list.add(new Habit("walk", "22:00", "Серуендеу", "Жаңа әдет",
                "45 минут далада, экраннан қашық."));
        list.add(new Habit("sleep_routine", "23:20", "Ұйқыға дайындық", "Жайлап ілгерілету",
                "Экрандарды өшір, жарықты азайт."));
        return list;
    }

    private static Path logFile(LocalDate date) {
        return LOG_DIR.resolve(date.format(DATE_FMT) + ".txt");
    }

    private static Map<String, Boolean> loadLog(LocalDate date) throws IOException {
        Map<String, Boolean> map = new LinkedHashMap<>();
        Path file = logFile(date);
        if (!Files.exists(file)) return map;

        for (String line : Files.readAllLines(file)) {
            String[] parts = line.split("=", 2);
            if (parts.length == 2) {
                map.put(parts[0], Boolean.parseBoolean(parts[1]));
            }
        }
        return map;
    }

    private static void saveLog(LocalDate date, Map<String, Boolean> log) throws IOException {
        List<String> lines = new ArrayList<>();
        for (Map.Entry<String, Boolean> e : log.entrySet()) {
            lines.add(e.getKey() + "=" + e.getValue());
        }
        Files.write(logFile(date), lines);
    }

    private static void printProgress(List<Habit> habits, Map<String, Boolean> log) {
        long done = habits.stream().filter(h -> log.getOrDefault(h.key, false)).count();
        int total = habits.size();
        int percent = (int) Math.round((done * 100.0) / total);

        System.out.println("-----------------------------------------");
        System.out.println("Бүгінгі прогресс: " + done + " / " + total + "  (" + percent + "%)");
        System.out.println(progressBar(percent));
    }

    private static String progressBar(int percent) {
        int filled = percent / 5; // 20 ұяшық = 100%
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < 20; i++) sb.append(i < filled ? "█" : "·");
        sb.append("]");
        return sb.toString();
    }

    private static boolean isDayComplete(List<Habit> habits, Map<String, Boolean> log) {
        if (log.isEmpty()) return false;
        for (Habit h : habits) {
            if (!log.getOrDefault(h.key, false)) return false;
        }
        return true;
    }

    private static void printStreak(List<Habit> habits, LocalDate today) throws IOException {
        StringBuilder chain = new StringBuilder();
        int streak = 0;
        boolean streakBroken = false;

         List<Boolean> last14 = new ArrayList<>();
        for (int i = 0; i < 14; i++) {
            LocalDate d = today.minusDays(i);
            Map<String, Boolean> log = loadLog(d);
            boolean complete = isDayComplete(habits, log);
            last14.add(complete);
            if (!streakBroken) {
                if (complete) streak++;
                else streakBroken = true;
            }
        }
        Collections.reverse(last14);
        for (boolean c : last14) chain.append(c ? "■ " : "· ");

        System.out.println();
        System.out.println("Тізбек: " + streak + " күн");
        System.out.println("Соңғы 14 күн: " + chain.toString().trim());
        System.out.println("=========================================");
    }
}