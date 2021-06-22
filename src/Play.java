import java.io.*;

public class Play {

    private static BufferedReader br;
    private static Character player = null;
    private static Battle battleScene = null;

    public static void main(String[] args) {

        br = new BufferedReader(new InputStreamReader(System.in));
        battleScene = new Battle();
        System.out.println("Введите имя персонажа:");

        try {
            command(br.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void command(String string) throws IOException {
        if (player == null) {
            player = new Person(
                    string,
                    100,
                    20,
                    20,
                    0,
                    20
            );
            System.out.println(String.format("Спасти наш мир от драконов вызвался %s! Да будет его броня крепка и бицепс кругл!",
                    player.getName()));
            printNavigation();
        }

        switch (string) {
            case "1": {
                System.out.println("Торговец уехал к бабуленьке в соседнюю деревню и пока не вернулся");
                command(br.readLine());
            }
            break;
            case "2": {
                commitFight();
            }
            break;
            case "3":
                System.exit(1);
                break;
            case "да":
                command("2");
                break;
            case "нет": {
                printNavigation();
                command(br.readLine());
            }
        }
        command(br.readLine());
    }

    private static void printNavigation() {
        System.out.println(String.format("Куда направимся воин, %s ?", player.getName()));
        System.out.println("1. К Торговцу");
        System.out.println("2. В темный лес");
        System.out.println("3. Выход из игры");
    }

    private static void commitFight() {
        battleScene.fight(player, createMonster(), new FightCallback() {
            @Override
            public void fightWin() {
                System.out.println(String.format("%s победил! Теперь у вас %d опыта и %d золота, а также осталось %d едениц здоровья.",
                        player.getName(), player.getExperience(), player.getGold(), player.getHealthPoint()));
                System.out.println("Желаете продолжить поход или вернуться в город? (да/нет)");
                try {
                    command(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void fightLost() {

            }
        });
    }

    public interface FightCallback {

        void fightWin();

        void fightLost();
    }

    private static Character createMonster() {
        int random = (int) (Math.random() * 10);
        if (random % 2 == 0) return new Goblin(
                "Гоблин",
                50,
                10,
                10,
                100,
                20
        );
        else return new Skeleton(
                "Скелет",
                25,
                20,
                20,
                100,
                10
        );
    }
}